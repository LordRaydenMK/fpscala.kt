package chapter6

data class State<S, out A>(val run: (S) -> Pair<A, S>) {

    fun <B> map(f: (A) -> B): State<S, B> = State { s ->
        val (a, s2) = run(s)
        Pair(f(a), s2)
    }

    fun <B> flatMap(f: (A) -> State<S, B>): State<S, B> = State { s ->
        val (a, s1) = run(s)
        f(a).run(s1)
    }

    companion object {

        fun <S, A> unit(a: A): State<S, A> = State { s -> Pair(a, s) }

        fun <S, A, B, C> map2(
            sa: State<S, A>,
            sb: State<S, B>,
            f: (Pair<A, B>) -> C
        ): State<S, C> = State { s ->
            val (a, s1) = sa.run(s)
            val (b, s2) = sb.run(s1)
            Pair(f(Pair(a, b)), s2)
        }

        fun <S, A> sequence(fs: List<State<S, A>>): State<S, List<A>> = State { s0 ->
            fs.fold(Pair(emptyList(), s0)) { pair, s ->
                val (acc, s1) = pair
                val (a, s2) = s.run(s1)
                Pair(acc + a, s2)
            }
        }

        fun <S> get(): State<S, S> = State { s -> Pair(s, s) }

        fun <S> set(s: S): State<S, Unit> = State { Pair(Unit, s) }

        fun <S> modify(f: (S) -> S): State<S, Unit> =
            get<S>().flatMap { set(f(it)) }
    }
}

typealias Random<A> = State<RNG, A>

fun main() {
    val five = Random.unit<RNG, Int>(5)
    val ten = five.map { it * 2 }
    println(five.run(SimpleRNG()))
    println(five.map { it * 2 }.run(SimpleRNG()))
    println(five.flatMap { ten }.run(SimpleRNG()))
    println(State.sequence(listOf(five, ten, five.map { it * 3 })).run(SimpleRNG()))
//    (5, SimpleRNG(seed=42))
//    (10, SimpleRNG(seed=42))
//    (10, SimpleRNG(seed=42))
//    ([5, 10, 15], SimpleRNG(seed=42))
}