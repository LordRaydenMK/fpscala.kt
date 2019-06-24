package chapter2

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C =
    { a -> f(g(a)) }