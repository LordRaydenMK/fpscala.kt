package chapter3

import chapter3.List.Nil
import chapter3.List.Cons

fun <A> tail(l: List<A>): List<A> =
    when (l) {
        is Nil -> Nil
        is Cons -> l.tail
    }

fun main() {
    val l = List(listOf(1, 2, 3, 4))
    println(tail(l))
//    Cons(head=2, tail=Cons(head=3, tail=Cons(head=4, tail=List.Nil)))
}