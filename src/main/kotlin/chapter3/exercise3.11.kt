package chapter3

fun sum(l: List<Int>): Int = foldLeft(l, 0) { a, b -> a + b }

fun product(l: List<Double>): Double = foldLeft(l, 1.0) { a, b -> a * b }

fun <A> length2(l: List<A>): Int = foldLeft(l, 0) { acc, _ -> acc + 1 }

fun main() {
    val l = List(listOf(1, 2, 3, 4))

    println(sum(l))
    println(product(List(listOf(1.0, 2.0, 5.0))))
    println(length2(l))
//    10
//    10.0
//    4
}