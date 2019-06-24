package chapter3

import chapter3.List.Nil
import chapter3.List.Cons

tailrec fun <A, B> foldLeft(ls: List<A>, z: B, f: (B, A) -> B): B =
    when (ls) {
        Nil -> z
        is Cons -> foldLeft(ls.tail, f(z, ls.head), f)
    }



fun main() {
    val l = List(listOf(1, 2, 3, 4))
    println(foldLeft(l, 0) { a, b -> a + b })
//    10
}