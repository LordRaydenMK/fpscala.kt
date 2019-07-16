package chapter5

fun <A> Stream<A>.takeWhile2(p: (A) -> Boolean): Stream<A> =
    foldRight({ Stream.empty() }) { a, b ->
        if (p(a)) Stream.cons({ a }, b) else Stream.empty()
    }


fun main() {
    val s = listOf(1, 2, 3, 4, 5, 6).toStream()

    println(s.takeWhile2 { it < 5 }.toList())
    println(s.takeWhile2 { it % 2 == 0 }.toList())
//    [1, 2, 3, 4]
//    []
}