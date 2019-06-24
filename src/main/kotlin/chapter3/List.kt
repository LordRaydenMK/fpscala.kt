package chapter3

sealed class List<out A> {
    object Nil : List<Nothing>() {
        override fun toString(): String = "List.Nil"
    }

    data class Cons<out A>(val head: A, val tail: List<A>) : List<A>()

    companion object {

        operator fun <A> invoke(xs: kotlin.collections.List<A>): List<A> =
            when {
                xs.isEmpty() -> Nil
                else -> Cons(xs.first(), List(xs.drop(1)))
            }
    }
}

fun <A> emptyList(): List<A> = List.Nil