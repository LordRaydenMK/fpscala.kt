package chapter6

interface RNG {

    fun nextInt(): Pair<Int, RNG>
}

data class SimpleRNG(val seed: Long = 42) : RNG {

    override fun nextInt(): Pair<Int, RNG> {
        val newSeed = (seed * 0x5DEECE66DL + 0xBL) and 0xFFFFFFFFFFFFL
        val nextRNG = SimpleRNG(newSeed)
        val n = (newSeed ushr 16).toInt()
        return Pair(n, nextRNG)
    }
}

typealias Rand<A> = (RNG) -> Pair<A, RNG>

fun int(): Rand<Int> = { it.nextInt() }

fun <A> unit(a: A): Rand<A> = {rng ->
    Pair(a, rng)
}

fun <A, B> map(s: Rand<A>, f: (A) -> B): Rand<B> = { rng ->
    val (a, rng2) = s(rng)
    Pair(f(a), rng2)
}