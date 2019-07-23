package chapter6

fun double(rng: RNG): Pair<Double, RNG> {
    val (n, nextRng) = nonNegativeInt(rng)
    return Pair(n / (Int.MAX_VALUE.toDouble() + 1), nextRng)
}

fun main() {
    val (i1, r1) = double(SimpleRNG())
    val (i2, r2) = double(r1)
    println(i1)
    println(i2)
//    0.007524831686168909
//    0.5967354848980904
}