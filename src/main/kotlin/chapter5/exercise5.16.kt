package chapter5

fun <A, B> Stream<A>.scanRight(
    z: () -> B, f: (A, () -> B) -> B
): Stream<B> =
    foldRight(
        { Pair(z, listOf(z()).toStream()) },
        { a, p0 ->
            val p1 by lazy { p0 }
            val b2 = f(a, p1().first)
            Pair({ b2 }, Stream.cons({ b2 }, { p1().second }))
        }
    ).second

fun main() {
    val s = listOf(1, 2, 3).toStream()
    println(s.scanRight({ 0 }) { a, b -> a + b() }.toList())
//    [6, 5, 3, 0]
}