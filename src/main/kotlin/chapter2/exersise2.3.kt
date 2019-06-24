package chapter2

fun <A, B, C> curry(f: (A, B) -> C): (A) -> (B) -> C =
    { a -> { b -> f(a, b) } }