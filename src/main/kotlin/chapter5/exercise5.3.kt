package chapter5

fun <A> Stream<A>.takeWhile(p: (A) -> Boolean): Stream<A> =
    when (this) {
        is Stream.Cons ->
            if (p(h())) Stream.cons(h, { t().takeWhile(p) })
            else Stream.empty()
        Stream.Empty -> Stream.empty()
    }


fun main() {
    val s = listOf(1, 2, 3, 4, 5, 6).toStream()

    println(s.takeWhile { it < 5 }.toList())
    println(s.takeWhile { it % 2 == 0 }.toList())
//    [1, 2, 3, 4]
//    []
}