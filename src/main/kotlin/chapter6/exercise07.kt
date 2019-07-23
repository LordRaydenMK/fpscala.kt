package chapter6

fun <A> sequence(fs: List<Rand<A>>): Rand<List<A>> = { rng ->
    fs.fold(Pair(emptyList(), rng)) { acc, rand ->
        val (l, r) = acc
        val (a, r1) = rand(r)
        Pair(l + a, r1)
    }
}

fun intsViaSequence(count: Int): (RNG) -> Pair<List<Int>, RNG> =
    sequence(List(count) { int() })

fun main() {
    println(sequence(listOf(unit(1), unit(2), unit(3)))(SimpleRNG()).first)
//    [1, 2, 3]
    println(intsViaSequence(4)(SimpleRNG()))
//    ([16159453, -1281479697, -340305902, -2015756020], SimpleRNG(seed=149370390209998))
}