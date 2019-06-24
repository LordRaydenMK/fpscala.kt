package chapter3

import chapter3.List.Nil
import chapter3.List.Cons

fun <A> setHead(l: List<A>, head: A): List<A> =
    when (l) {
        is Nil -> Cons(head, Nil)
        is Cons -> Cons(head, l)
    }

fun main() {
    val l = List(listOf(1, 2, 3, 4))
    println(setHead(l, 15))
//    Cons(head=15, tail=Cons(head=1, tail=Cons(head=2, tail=Cons(head=3, tail=Cons(head=4, tail=List.Nil)))))
}