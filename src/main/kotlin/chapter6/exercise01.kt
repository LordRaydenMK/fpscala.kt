package chapter6

fun nonNegativeInt(rng: RNG): Pair<Int, RNG> {
    val (n, nextRng) = rng.nextInt()
    return if (n >= 0) Pair(n, nextRng)
    else Pair(-(n + 1), nextRng)
}

fun main() {
    val (n1, rng1) = nonNegativeInt(SimpleRNG(42))
    val (n2, rng2) = nonNegativeInt(rng1)
    println(n1)
    println(n2)
//    16159453
//    1281479696
}