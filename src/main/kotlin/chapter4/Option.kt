package chapter4

sealed class Option<out A> {
    data class Some<out A>(val get: A) : Option<A>()
    object None : Option<Nothing>()

    fun <B> map(f: (A) -> B): Option<B> =
        when (this) {
            is Some -> Some(f(get))
            None -> None
        }

    fun <B> flatMap(f: (A) -> Option<B>): Option<B> =
        when (this) {
            is Some -> f(get)
            None -> None
        }

    fun filter(f: (A) -> Boolean): Option<A> =
        if (this is Some && f(get)) this
        else None
}

fun <A, B> Option<A>.getOrElse(default: () -> B): B where A : B =
    when (this) {
        is Option.Some -> get
        Option.None -> default()
    }

fun <A, B> Option<A>.orElse(ob: () -> Option<B>): Option<B> where A : B =
    if (this is Option.Some) this
    else ob()