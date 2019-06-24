package chapter3

import chapter3.List.Cons

fun doubleToString(l: List<Double>): List<String> =
    foldRight(l, emptyList()) { a, acc -> Cons(a.toString(), acc) }

fun main() {
    val l = List(listOf(1.0, 2.5, 3.6, 4.92))
    println(doubleToString(l))
    //Cons(head=1.0, tail=Cons(head=2.5, tail=Cons(head=3.6, tail=Cons(head=4.92, tail=List.Nil))))
}