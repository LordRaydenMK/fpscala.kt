package chapter3

import chapter3.List.Nil
import chapter3.List.Cons

fun <A> dropWhile(l: List<A>, f: (A) -> Boolean): List<A> =
    when (l) {
        is Nil -> Nil
        is Cons -> {
            if (f(l.head)) dropWhile(l.tail, f)
            else l
        }
    }

fun main() {
    val l = List(listOf(1, 2, 3, 4, 5, 6, 7))
    println(dropWhile(l) { it < 5 })
//    Cons(head=5, tail=Cons(head=6, tail=Cons(head=7, tail=List.Nil)))
}