package chapter4.either

import chapter3.List
import chapter3.foldRight

fun <E, A> sequence(es: List<Either<E, A>>): Either<E, List<A>> =
    traverse(es) { it }

fun <E, A, B> traverse(l: List<A>, f: (A) -> Either<E, B>): Either<E, List<B>> =
    foldRight(l, Either.Right(List.Nil) as Either<E, List<B>>) { a, acc: Either<E, List<B>> ->
        f(a).flatMap { b -> acc.map { List.Cons(b, it) } }
    }

fun main() {
    val l1 = List(listOf(5, 10, 15, 20))
    val l2 = List(listOf(5, 10, 11, 15, 20))
    val f: (Int) -> Either<String, String> = { a ->
        if (a % 5 == 0) Either.Right(a.toString())
        else Either.Left("Not divisible with 5: $a")
    }

    println(traverse(l1, f))
    println(traverse(l2, f))
//    Right(value=Cons(head=5, tail=Cons(head=10, tail=Cons(head=15, tail=Cons(head=20, tail=List.Nil)))))
//    Left(value=Not divisible with 5: 11)
}