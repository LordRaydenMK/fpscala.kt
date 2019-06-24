package chapter2

fun <A, B, C> uncurry(f: (A) -> (B) -> C): (A, B) -> C =
    { a, b -> f(a)(b) }