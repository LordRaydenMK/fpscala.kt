package chapter5

fun <A> Stream<A>.forAll(p: (A) -> Boolean): Boolean =
    when (this) {
        is Stream.Cons -> p(h()) && t().forAll(p)
        Stream.Empty -> true
    }


fun main() {
    val s = listOf(1, 2, 3, 4, 5, 6).toStream()

    println(s.forAll { it < 5 })
    println(s.forAll { it < 7 })
//    false
//    true
}