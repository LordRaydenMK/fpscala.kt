package chapter3

import chapter3.List.Cons

fun <A> reverse(l: List<A>): List<A> =
    foldLeft(l, emptyList()) { acc, a -> Cons(a, acc) }

fun main() {
    val l = List(listOf(1, 2, 3, 4))
    println(reverse(l))
//    Cons(head=4, tail=Cons(head=3, tail=Cons(head=2, tail=Cons(head=1, tail=List.Nil))))
}