package chapter5

fun fibs(): Stream<Int> {
    fun loop(prev: Int, cur: Int): Stream<Int> =
        Stream.cons({ prev }, { loop(cur, prev + cur) })
    return loop(0, 1)
}


fun main() {
    println(fibs().take(10).toList())
//    [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
}