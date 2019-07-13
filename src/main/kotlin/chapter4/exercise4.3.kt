package chapter4

import chapter4.Option.None
import chapter4.Option.Some

fun <A, B, C> map2(a: Option<A>, b: Option<B>, f: (A, B) -> C): Option<C> =
    if (a is Some && b is Some) Some(f(a.get, b.get))
    else None