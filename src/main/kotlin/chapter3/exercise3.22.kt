package chapter3

import chapter3.List.Nil
import chapter3.List.Cons

fun addElements(l1: List<Int>, l2: List<Int>): List<Int> =
    when {
        l1 is Nil || l2 is Nil -> Nil
        l1 is Cons && l2 is Cons ->
            Cons(l1.head + l2.head, addElements(l1.tail, l2.tail))
        else -> throw IllegalArgumentException("Wat!")
    }

fun main() {
    val l1 = List(listOf(1, 2, 3, 4))
    val l2 = List(listOf(5, 6, 7, 8))
    println(addElements(l1, l2))
//  Cons(head=6, tail=Cons(head=8, tail=Cons(head=10, tail=Cons(head=12, tail=List.Nil))))
}