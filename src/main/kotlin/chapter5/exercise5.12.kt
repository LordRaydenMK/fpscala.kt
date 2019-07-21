package chapter5

fun fibsViaUnfold(): Stream<Int> = unfold(Pair(0, 1)) {
    Pair(it.first, Pair(it.second, it.first + it.second))
}

fun fromViaUnfold(n: Int): Stream<Int> = unfold(n) { Pair(it, it + 1) }

fun <A> constantViaUnfold(a: A): Stream<A> = unfold(a) { Pair(a, a) }

fun ones(): Stream<Int> = unfold(1) { Pair(1, 1) }


fun main() {
    println(fibsViaUnfold().take(10).toList())
    println(fromViaUnfold(5).take(7).toList())
    println(constantViaUnfold(2).take(5).toList())
    println(ones().take(5).toList())
//    [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
//    [5, 6, 7, 8, 9, 10, 11]
//    [2, 2, 2, 2, 2]
//    [1, 1, 1, 1, 1]
}