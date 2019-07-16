package chapter5

fun <A> Stream<A>.take(n: Int): Stream<A> =
    when (this) {
        is Stream.Cons ->
            when {
                n == 1 -> Stream.cons(h, { Stream.empty() })
                n > 1 -> Stream.cons(h, { t().take(n - 1) })
                else -> Stream.empty()
            }
        Stream.Empty -> Stream.empty()
    }

tailrec fun <A> Stream<A>.drop(n: Int): Stream<A> =
    when (this) {
        is Stream.Cons -> if (n == 1) t() else t().drop(n - 1)
        Stream.Empty -> Stream.empty()
    }


fun main() {
    val s = listOf(1, 2, 3, 4, 5, 6).toStream()

    println(s.take(3).toList())
    println(s.take(10).toList())
    println(Stream.empty<Int>().take(7).toList())
//    [1, 2, 3]
//    [1, 2, 3, 4, 5, 6]
//    []
    println(s.drop(1).toList())
    println(s.drop(5).toList())
    println(s.drop(10).toList())
//    [2, 3, 4, 5, 6]
//    [6]
//    []

}