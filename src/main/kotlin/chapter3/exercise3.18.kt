package chapter3

import chapter3.List.Cons

fun <A, B> map(l: List<A>, f: (A) -> B): List<B> =
    foldRight(l, emptyList()) { a, acc -> Cons(f(a), acc) }

fun main() {
    val l = List(listOf(1, 2, 3, 4))
    println(map(l) { it + 5 })
//  Cons(head=6, tail=Cons(head=7, tail=Cons(head=8, tail=Cons(head=9, tail=List.Nil))))
}