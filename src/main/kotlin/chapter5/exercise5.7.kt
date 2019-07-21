package chapter5

fun <A, B> Stream<A>.map(f: (A) -> B): Stream<B> =
    foldRight({ Stream.empty() }) { a, acc ->
        Stream.cons({ f(a) }, acc)
    }

fun <A> Stream<A>.filter(p: (A) -> Boolean): Stream<A> =
    foldRight({ Stream.empty() }) { a, acc ->
        if (p(a)) {
            Stream.cons({ a }, acc)
        } else {
            acc()
        }
    }

fun <A> Stream<A>.append(s: () -> Stream<A>): Stream<A> =
    foldRight(s) { a, acc ->
        Stream.cons({ a }, acc)
    }

fun <A, B> Stream<A>.flatMap(f: (A) -> Stream<B>): Stream<B> =
    foldRight({ Stream.empty() }) { a, acc ->
        f(a).append(acc)
    }


fun main() {
    val s = listOf(1, 2, 3, 4, 5, 6).toStream()
    val s2 = listOf(22, 33, 44, 55).toStream()

    println(s.map { it * 2 + 1 }.toList())
    println(s.filter { it % 2 == 0 }.toList())
    println(s.append { s2 }.toList())
    println(s.flatMap { listOf(it, it).toStream() }.toList())
//    [3, 5, 7, 9, 11, 13]
//    [2, 4, 6]
//    [1, 2, 3, 4, 5, 6, 22, 33, 44, 55]
//    [1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6]
}