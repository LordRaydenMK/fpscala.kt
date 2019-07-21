package chapter5

fun <A> constant(a: A): Stream<A> = Stream.cons({ a }, { constant(a) })

fun main() {
    println(constant(5).take(10).toList())
//    [5, 5, 5, 5, 5, 5, 5, 5, 5, 5]
}