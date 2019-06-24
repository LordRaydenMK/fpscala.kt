package chapter3

import chapter3.List.Nil
import chapter3.List.Cons

fun <A, B> foldRight(ls: List<A>, z: B, f: (A, B) -> B): B =
    when (ls) {
        is Nil -> z
        is Cons -> f(ls.head, foldRight(ls.tail, z, f))
    }

fun main() {
    val l = List(listOf(1, 2, 3, 4))
    println(foldRight(l, emptyList<Int>()) { a, b -> Cons(a, b) })
//    Cons(head=1, tail=Cons(head=2, tail=Cons(head=3, tail=Cons(head=4, tail=List.Nil))))
}