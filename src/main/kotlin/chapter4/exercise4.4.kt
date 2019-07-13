package chapter4

import chapter4.Option.Some
import chapter4.Option.None
import chapter3.List
import chapter3.List.Nil
import chapter3.List.Cons

fun <A> sequence(a: List<Option<A>>): Option<List<A>> =
    when (a) {
        is Nil -> Some(Nil)
        is Cons -> a.head.flatMap { hh ->
            sequence(a.tail).map { Cons(hh, it) }
        }
    }

fun main() {
    val l1 = List(
        listOf<Option<Int>>(
            Some(5),
            Some(10),
            Some(15)
        )
    )
    val l2 = List(
        listOf(
            Some(5),
            Some(10),
            None,
            Some(15)
        )
    )
    println(sequence(l1))
    println(sequence(l2))
//    Some(get=Cons(head=5, tail=Cons(head=10, tail=Cons(head=15, tail=List.Nil))))
//    chapter4.Option$None@4f023edb
}