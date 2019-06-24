package chapter3

fun <A> length(ls: List<A>): Int =
    foldRight(ls, 0) { _, acc -> acc + 1 }

fun main() {
    val l = List(listOf(1, 2, 3, 4))
    println(length(l))
//    4
}