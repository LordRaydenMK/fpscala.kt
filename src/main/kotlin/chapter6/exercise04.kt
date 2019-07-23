package chapter6

fun ints(count: Int, rng: RNG): Pair<List<Int>, RNG> {
    tailrec fun loop(count: Int, rng: RNG, acc: List<Int>): Pair<List<Int>, RNG> =
        if (count == 0) Pair(acc, rng)
        else {
            val (i, r) = rng.nextInt()
            loop(count - 1, r, acc + i)
        }
    return loop(count, rng, emptyList())
}

fun main() {
    println(ints(5, SimpleRNG()))
//    ([16159453, -1281479697, -340305902, -2015756020, 1770001318], SimpleRNG(seed=115998806404289))
}