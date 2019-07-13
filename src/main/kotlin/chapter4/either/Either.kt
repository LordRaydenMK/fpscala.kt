package chapter4.either

sealed class Either<out E, out A> {

    data class Left<out E>(val value: E) : Either<E, Nothing>()
    data class Right<out A>(val value: A) : Either<Nothing, A>()

    // Exercise 4.6
    inline fun <B> map(f: (A) -> B): Either<E, B> =
        when (this) {
            is Left -> Left(value)
            is Right -> Right(f(value))
        }
}

inline fun <EE, E, A, B> Either<E, A>.flatMap(
    f: (A) -> Either<EE, B>
): Either<EE, B> where E : EE =
    when (this) {
        is Either.Left -> Either.Left(value)
        is Either.Right -> f(value)
    }

inline fun <EE, E, A> Either<E, A>.orElse(
    b: () -> Either<EE, A>
): Either<EE, A> where E : EE =
    when (this) {
        is Either.Left -> b()
        is Either.Right -> this
    }

inline fun <EE, E, A, B, C> Either<E, A>.map2(
    b: Either<E, B>, f: (A, B) -> C
): Either<EE, C> where E : EE =
    flatMap { a -> b.flatMap { b -> Either.Right(f(a, b)) } }