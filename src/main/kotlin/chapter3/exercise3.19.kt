package chapter3

import chapter3.List.Cons

fun <A> filter(l: List<A>, f: (A) -> Boolean): List<A> =
    foldRight(l, emptyList()) { a, acc -> if (f(a)) Cons(a, acc) else acc }

fun main() {
    val l = List(listOf(1, 2, 3, 4, 5, 6, 7, 8))
    println(filter(l) { it % 2 == 0 })
//  Cons(head=2, tail=Cons(head=4, tail=Cons(head=6, tail=Cons(head=8, tail=List.Nil))))
}