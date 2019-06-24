package chapter2

/**
 * Find the n-th fibonacci number
 */
fun fib(n: Int): Int {
    tailrec fun loop(index: Int, prev: Int, cur: Int): Int =
        if (index == n) cur
        else loop(index + 1, cur, prev + cur)

    return loop(1, 0, 1)
}

fun main() {
    val firstTen = (1..10).map { fib(it) }
    println(firstTen.joinToString { it.toString() })
//    1, 1, 2, 3, 5, 8, 13, 21, 34, 55
}