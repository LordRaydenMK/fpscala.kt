package chapter3

fun <A, B> flatMap(l: List<A>, f: (A) -> List<B>): List<B> =
    concat(map(l) { f(it) })

fun main() {
    val l = List(listOf(1, 2, 3))
    println(flatMap(l) { List(listOf(it, it)) })
//  Cons(head=1, tail=Cons(head=1, tail=Cons(head=2, tail=Cons(head=2, tail=Cons(head=3, tail=Cons(head=3, tail=List.Nil))))))
}