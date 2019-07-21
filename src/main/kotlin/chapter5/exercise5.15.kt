package chapter5

fun <A> Stream<A>.tails(): Stream<Stream<A>> =
    unfold(this) {
        when (it) {
            is Stream.Cons -> Pair(it, it.t())
            Stream.Empty -> null
        }
    }.append { Stream.cons({ Stream.empty<A>() }, { Stream.empty() }) }

fun main() {
    val s = listOf(1, 2, 3, 4, 5, 10).toStream()
    println(s.tails().map { it.toList() }.toList())
//    [[1, 2, 3, 4, 5, 10], [2, 3, 4, 5, 10], [3, 4, 5, 10], [4, 5, 10], [5, 10], [10], []]
}