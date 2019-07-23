package chapter6

fun intDouble(rng: RNG): Pair<Pair<Int, Double>, RNG> {
    val (i, r1) = rng.nextInt()
    val (d, r2) = double(r1)
    return Pair(Pair(i, d), r2)
}

fun doubleInt(rng: RNG): Pair<Pair<Double, Int>, RNG> {
    val (id, r) = intDouble(rng)
    return Pair(Pair(id.second, id.first), r)
}

data class Triple<A, B, C>(val first: A, val second: B, val third: C)

fun double3(rng: RNG): Pair<Triple<Double, Double, Double>, RNG> {
    val (d1, r1) = double(rng)
    val (d2, r2) = double(r1)
    val (d3, r3) = double(r2)
    return Pair(Triple(d1, d2, d3), r3)
}

fun main() {
    val (id, r1) = intDouble(SimpleRNG())
    val (di, r2) = doubleInt(r1)
    val (ddd, r3) = double3(r2)
    println(id)
    println(di)
    println(ddd)
//    (16159453, 0.5967354848980904)
//    (0.9386595427058637, -340305902)
//    Triple(first=0.8242210922762752, second=0.9008632311597466, third=0.4730720594525337)
}