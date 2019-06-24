package chapter3

import chapter3.List.Nil
import chapter3.List.Cons

fun <A> filter2(l: List<A>, f: (A) -> Boolean): List<A> =
    flatMap(l) { if (f(it)) Cons(it, Nil) else emptyList<A>() }

fun main() {
    val l = List(listOf(1, 2, 3, 4, 5, 6, 7, 8))
    println(filter2(l) { it % 2 == 0 })
//  Cons(head=2, tail=Cons(head=4, tail=Cons(head=6, tail=Cons(head=8, tail=List.Nil))))
}