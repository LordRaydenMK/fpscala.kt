package chapter2

fun <A> isSorted(arr: Array<A>, ordered: (A, A) -> Boolean): Boolean {
    tailrec fun loop(index: Int): Boolean =
        if (index + 1 >= arr.size) true
        else if (!ordered(arr[index], arr[index + 1])) false
        else loop(index + 1)

    return loop(0)
}

fun main() {
    val arr1 = arrayOf(0, 1, 2, 3, 4, 5, 6, 10, 10, 15, 20)
    val arr2 = arrayOf(0, 1, 2, 1, 4, 5, 6, 10, 10, 15, 20)
    println(isSorted(arr1) { a, b -> a <= b })
    println(isSorted(arr2) { a, b -> a <= b })
    //true
    //false
}