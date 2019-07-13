package chapter4

import chapter3.List
import chapter3.foldRight
import chapter3.map
import chapter4.Option.None
import chapter4.Option.Some

fun <A, B> traverse(l: List<A>, f: (A) -> Option<B>): Option<List<B>> =
    foldRight(l, Some(List.Nil) as Option<List<B>>) { a, acc ->
        map2(f(a), acc) { a, b -> List.Cons(a, b) }
    }

fun <A> sequence2(a: List<Option<A>>): Option<List<A>> =
    traverse(a) { it }

fun main() {
    val l1 = List(listOf(2, 4, 6, 8, 10))
    val l2 = List(listOf(2, 4, 7, 8, 10))
    val f: (Int) -> Option<Int> = { a -> if (a % 2 == 0) Some(a) else None }
    println(traverse(l1, f))
    println(traverse(l2, f))
//    Some(get=Cons(head=2, tail=Cons(head=4, tail=Cons(head=6, tail=Cons(head=8, tail=Cons(head=10, tail=List.Nil))))))
//    chapter4.Option$None@7adf9f5f
    println(sequence2(map(l1, f)))
    println(sequence2(map(l2, f)))
//    Some(get=Cons(head=2, tail=Cons(head=4, tail=Cons(head=6, tail=Cons(head=8, tail=Cons(head=10, tail=List.Nil))))))
//    chapter4.Option$None@7adf9f5f
}