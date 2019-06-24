package chapter3

fun <A, B> foldRight2(l: List<A>, z: B, f: (A, B) -> B): B =
    foldLeft(l, z) { acc, a -> f(a, acc) }

fun main() {
    val l = List(listOf(1, 2, 3, 4))
    println(foldRight2(l, 0){ a, b -> a + b })
//    10
}