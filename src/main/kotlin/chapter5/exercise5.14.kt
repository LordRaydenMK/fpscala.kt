package chapter5

fun <A> Stream<A>.startsWith(s: Stream<A>): Boolean =
    zipAll(s)
        .takeWhile { it.second != null }
        .forAll { it.first == it.second }

fun main() {
    val s1 = listOf(1, 2, 3, 4, 5, 10).toStream()
    val s2 = listOf(1, 2, 3).toStream()
    val s3 = listOf(5, 6, 6).toStream()

    println(s1.startsWith(s2))
    println(s1.startsWith(s3))
//    true
//    false
}