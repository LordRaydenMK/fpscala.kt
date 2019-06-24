package chapter3

import chapter3.Tree.Leaf
import chapter3.Tree.Branch
import kotlin.math.max

fun <A> depth(tree: Tree<A>): Int =
    when (tree) {
        is Leaf -> 1
        is Branch -> max(depth(tree.left) + 1, depth(tree.right) + 1)
    }

fun main() {
    val tree = Branch(
        Leaf(5),
        Branch(
            Branch(Leaf(10), Leaf(1)),
            Leaf(2)
        )
    )
    println(depth(tree))
//    4
}