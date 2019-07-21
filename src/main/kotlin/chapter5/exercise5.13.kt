package chapter5

fun <A, B> Stream<A>.mapViaUnfold(f: (A) -> B): Stream<B> =
    unfold(this) {
        when (it) {
            is Stream.Cons -> Pair(f(it.h()), it.t())
            Stream.Empty -> null
        }
    }

fun <A> Stream<A>.takeViaUnfold(n: Int): Stream<A> =
    unfold(Pair(this, n)) {
        when (val s = it.first) {
            is Stream.Cons ->
                when {
                    it.second == 1 -> Pair(s.h(), Pair(Stream.empty(), 0))
                    it.second > 1 -> Pair(s.h(), Pair(s.t(), it.second - 1))
                    else -> null
                }
            Stream.Empty -> null
        }
    }

fun <A> Stream<A>.takeWhileViaUnfold(p: (A) -> Boolean): Stream<A> =
    unfold(this) {
        when (it) {
            is Stream.Cons ->
                if (p(it.h())) Pair(it.h(), it.t())
                else null
            Stream.Empty -> null
        }
    }

fun <A> Stream<A>.zipWith(s2: Stream<A>, f: (A, A) -> A): Stream<A> =
    unfold(Pair(this, s2)) {
        when {
            it.first is Stream.Empty || it.second is Stream.Empty -> null
            else -> {
                val one = it.first as Stream.Cons
                val two = it.second as Stream.Cons

                Pair(f(one.h(), two.h()), Pair(one.t(), two.t()))
            }
        }
    }

fun <A, B> Stream<A>.zipAll(s2: Stream<B>): Stream<Pair<A?, B?>> =
    unfold(Pair(this, s2)) {
        val first = it.first
        val second = it.second
        when {
            first is Stream.Cons && second is Stream.Cons ->
                Pair(Pair(first.h(), second.h()), Pair(first.t(), second.t()))
            first is Stream.Empty && second is Stream.Cons ->
                Pair(Pair(null, second.h()), Pair(Stream.empty<A>(), second.t()))
            first is Stream.Cons && second is Stream.Empty ->
                Pair(Pair(first.h(), null), Pair(first.t(), Stream.empty<B>()))
            else -> null
        }
    }

fun main() {
    val s1 = listOf(1, 2, 3, 4, 5, 10).toStream()
    val s2 = listOf("a", "b", "c", "d").toStream()

    println(s1.mapViaUnfold { (it + 2).toString() }.toList())
    println(s1.takeViaUnfold(3).toList())
    println(s1.takeWhileViaUnfold { it < 5 }.toList())
    println(s1.zipWith(s2) { a, b -> "$a$b" }.toList())
    println(s1.zipAll(s2).toList())
//    [3, 4, 5, 6, 7, 12]
//    [1, 2, 3]
//    [1, 2, 3, 4]
//    [1a, 2b, 3c, 4d]
//    [(1, a), (2, b), (3, c), (4, d), (5, null), (10, null)]

}