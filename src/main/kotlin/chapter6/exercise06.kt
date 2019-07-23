package chapter6

fun <A, B, C> map2(
    ra: Rand<A>,
    rb: Rand<B>, f: (Pair<A, B>) -> C
): Rand<C> = { rng ->
    val (a, r1) = ra(rng)
    val (b, r2) = rb(r1)
    Pair(f(Pair(a, b)), r2)
}

fun <A, B> both(ra: Rand<A>, rb: Rand<B>): Rand<Pair<A, B>> =
    map2(ra, rb) { it }

fun randIntDouble(): Rand<Pair<Int, Double>> =
    both(int(), doubleViaMap())

fun randDoubleInt(): Rand<Pair<Double, Int>> =
    both(doubleViaMap(), int())

fun main() {
    println(randIntDouble()(SimpleRNG()))
    println(randDoubleInt()(SimpleRNG()))
//    ((16159453, 0.5967354848980904), SimpleRNG(seed=197491923327988))
//    ((0.007524831686168909, -1281479697), SimpleRNG(seed=197491923327988))
}