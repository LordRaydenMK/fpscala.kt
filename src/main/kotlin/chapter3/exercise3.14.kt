package chapter3

import chapter3.List.Cons

fun <A> append(l1: List<A>, l2: List<A>): List<A> =
    foldRight(l1, l2) { a, acc -> Cons(a, acc) }

fun main() {
    val l1 = List(listOf(1, 2, 3, 4))
    val l2 = List(listOf(5, 6, 7, 8))
    println(append(l1, l2))
//    Cons(head=1, tail=Cons(head=2, tail=Cons(head=3, tail=Cons(head=4, tail=Cons(head=5, tail=Cons(head=6, tail=Cons(head=7, tail=Cons(head=8, tail=List.Nil))))))))
}