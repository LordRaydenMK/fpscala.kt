package chapter5

fun from(n: Int): Stream<Int> = Stream.cons({ n }, { from(n + 1) })

fun main() {
    println(from(5).take(10).toList())
//    [5, 6, 7, 8, 9, 10, 11, 12, 13, 14]
}