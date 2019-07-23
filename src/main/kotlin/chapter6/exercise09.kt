package chapter6

fun <A, B> mapViaFlatMap(s: Rand<A>, f: (A) -> B): Rand<B> =
    flatMap(s) { a -> unit(f(a)) }

fun <A, B, C> map2ViaFlatMap(
    ra: Rand<A>,
    rb: Rand<B>, f: (Pair<A, B>) -> C
): Rand<C> = flatMap(ra) { a ->
    flatMap(rb) { b ->
        unit(f(Pair(a, b)))
    }
}