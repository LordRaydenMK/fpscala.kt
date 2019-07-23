package chapter6

fun doubleViaMap(): Rand<Double> =
    map(::nonNegativeInt) { i ->
        i / (Int.MAX_VALUE.toDouble() + 1)
    }

fun main() {
    println(doubleViaMap()(SimpleRNG()))
//    (0.007524831686168909, SimpleRNG(seed=1059025964525))
}