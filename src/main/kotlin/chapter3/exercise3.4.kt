package chapter3

import chapter3.List.Nil
import chapter3.List.Cons

fun <A> drop(l: List<A>, n: Int): List<A> =
    when (l) {
        is Nil -> Nil
        is Cons -> {
            if (n == 1) l.tail
            else drop(l.tail, n - 1)
        }
    }

fun main() {
    val l = List(listOf(1, 2, 3, 4))
    println(drop(l, 2))
//    Cons(head=3, tail=Cons(head=4, tail=List.Nil))
}