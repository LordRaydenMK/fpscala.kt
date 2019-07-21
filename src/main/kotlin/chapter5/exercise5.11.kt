package chapter5

fun <A, S> unfold(z: S, f: (S) -> Pair<A, S>?): Stream<A> =
    when (val result = f(z)) {
        null -> Stream.empty()
        else -> Stream.cons({ result.first }, { unfold(result.second, f) })
    }


fun main() {
    println(unfold(0) { Pair(it, it + 1) }.take(10).toList())
    println(unfold(0) { if (it < 10) Pair(it, it + 1) else null }.toList())
//    [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
//    [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
}