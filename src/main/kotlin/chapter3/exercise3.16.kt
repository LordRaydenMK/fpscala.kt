package chapter3

import chapter3.List.Cons

fun addOne(l: List<Int>): List<Int> =
    foldRight(l, emptyList()) { a, acc -> Cons(a + 1, acc) }

fun main() {
    val l = List(listOf(1, 2, 3, 4))
    println(addOne(l))
    //Cons(head=2, tail=Cons(head=3, tail=Cons(head=4, tail=Cons(head=5, tail=List.Nil))))
}