package chapter5

sealed class Stream<out A> {
    object Empty : Stream<Nothing>()
    data class Cons<out A>(val h: () -> A, val t: () -> Stream<A>) : Stream<A>()

    fun headOrNull(): A? =
        when (this) {
            Empty -> null
            is Cons -> h()
        }

    fun <B> foldRight(z: () -> B, f: (A, () -> B) -> B): B =
        when (this) {
            is Cons -> f(h()) { t().foldRight(z, f) }
            Empty -> z()
        }

    companion object {

        fun <A> cons(hd: () -> A, tl: () -> Stream<A>): Stream<A> {
            val head by lazy { hd() }
            val tail by lazy { tl() }
            return Cons({ head }, { tail })
        }

        fun <A> empty(): Stream<A> = Empty
    }
}

fun <A> List<A>.tail(): List<A> = drop(1)

fun <A> List<A>.toStream(): Stream<A> =
    if (isEmpty()) Stream.empty()
    else Stream.cons({ first() }, { tail().toStream() })

fun main() {
    val stream = listOf(1, 5, 10, 12, 15).toStream()
    println(Stream.empty<Unit>())
    println(stream.toList())

    println(stream.headOrNull())
}