package chapter3

import chapter3.List.Nil
import chapter3.List.Cons

fun <A> init(l: List<A>): List<A> =
    when (l) {
        is Nil -> throw IllegalArgumentException("init on empty list")
        is Cons -> {
            if (l.tail is Nil) Nil
            else Cons(l.head, init(l.tail))
        }
    }

fun main() {
    val l = List(listOf(1, 2, 3, 4))
    println(init(l))
//    Cons(head=1, tail=Cons(head=2, tail=Cons(head=3, tail=List.Nil)))
}