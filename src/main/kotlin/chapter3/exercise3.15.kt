package chapter3

fun <A> concat(l: List<List<A>>): List<A> =
    foldLeft(l, emptyList()) { acc, a -> append(acc, a) }

fun main() {
    val l1 = List(listOf(1, 2, 3, 4))
    val l2 = List(listOf(5, 6, 7, 8))
    val l = List(listOf(l1, l2))
    println(concat(l))
    //Cons(head=1, tail=Cons(head=2, tail=Cons(head=3, tail=Cons(head=4, tail=Cons(head=5, tail=Cons(head=6, tail=Cons(head=7, tail=Cons(head=8, tail=List.Nil))))))))
}