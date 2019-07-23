package chapter6

fun <A, B> flatMap(f: Rand<A>, g: (A) -> Rand<B>): Rand<B> = { rng ->
    val (a, r1) = f(rng)
    g(a)(r1)
}

fun nonNegativeLessThan(n: Int): Rand<Int> =
    flatMap(::nonNegativeInt) { i ->
        val mod = i % n
        if (i + (n - 1) - mod >= 0) unit(mod)
        else nonNegativeLessThan(n)
    }

fun main() {
    println(nonNegativeLessThan(10)(SimpleRNG()))
//    (3, SimpleRNG(seed=105902596452
}