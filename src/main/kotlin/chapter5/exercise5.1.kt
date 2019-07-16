package chapter5

fun <A> Stream<A>.toList(): List<A> =
    when (this) {
        Stream.Empty -> emptyList()
        is Stream.Cons -> listOf(this.h()) + t().toList()
    }

fun <A> Stream<A>.toListFast(): List<A> {
    val list = mutableListOf<A>()
    tailrec fun loop(s: Stream<A>): List<A> =
        when (s) {
            Stream.Empty -> list
            is Stream.Cons -> {
                list.add(s.h())
                loop(s.t())
            }
        }
    return loop(this)
}