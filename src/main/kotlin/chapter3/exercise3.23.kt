package chapter3

import chapter3.List.Nil
import chapter3.List.Cons

fun <A> zipWith(l1: List<A>, l2: List<A>, f: (A, A) -> A): List<A> =
    when {
        l1 is Nil || l2 is Nil -> Nil
        l1 is Cons && l2 is Cons ->
            Cons(f(l1.head, l2.head), zipWith(l1.tail, l2.tail, f))
        else -> throw IllegalArgumentException("Wat!")
    }

fun main() {
    val l1 = List(listOf(1, 2, 3, 4))
    val l2 = List(listOf(5, 6, 7, 8))
    println(zipWith(l1, l2) { a, b -> a + b + 1 })
//  Cons(head=7, tail=Cons(head=9, tail=Cons(head=11, tail=Cons(head=13, tail=List.Nil))))
}