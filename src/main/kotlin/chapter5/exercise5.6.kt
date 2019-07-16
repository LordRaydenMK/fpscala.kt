package chapter5

fun <A> Stream<A>.headOrNull2(): A? =
    foldRight<A?>({ null }) { a, _ -> a }


fun main() {
    val s = listOf(1, 2, 3, 4, 5, 6).toStream()

    println(s.headOrNull2())
    println(s.drop(3).headOrNull2())
    println(Stream.empty<Int>().headOrNull2())
//    1
//    4
//    null
}