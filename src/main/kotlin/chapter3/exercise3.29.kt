package chapter3

import chapter3.Tree.Leaf
import chapter3.Tree.Branch
import kotlin.math.max

fun <A, B> fold(tree: Tree<A>, l: (A) -> B, b: (B, B) -> B): B =
    when (tree) {
        is Leaf -> l(tree.a)
        is Branch -> b(fold(tree.left, l, b), fold(tree.right, l, b))
    }

fun <A> size2(tree: Tree<A>): Int =
    fold(tree, { 1 }) { left, right -> 1 + left + right }

fun maximum2(tree: Tree<Int>): Int =
    fold(tree, { max(it, Int.MIN_VALUE) }) { left, right -> max(left, right) }

fun <A> depth2(tree: Tree<A>): Int =
    fold(tree, { 1 }) { left, right -> max(left + 1, right + 1) }

fun <A, B> map2(tree: Tree<A>, f: (A) -> B): Tree<B> =
    fold(tree, { treeOf(f(it)) }) { left, right -> Branch(left, right) }

fun main() {
    val tree = Branch(
        Leaf(5),
        Branch(
            Branch(Leaf(10), Leaf(1)),
            Leaf(2)
        )
    )
    println(size2(tree))
    println(maximum2(tree))
    println(depth2(tree))
    println(map2(tree) { it + 10 })
//    7
//    10
//    4
//    Branch(left=Leaf(a=15), right=Branch(left=Branch(left=Leaf(a=20), right=Leaf(a=11)), right=Leaf(a=12)))
}