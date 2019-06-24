package chapter3

import chapter3.Tree.Leaf
import chapter3.Tree.Branch
import kotlin.math.max

fun maximum(tree: Tree<Int>): Int =
    when (tree) {
        is Leaf -> tree.a
        is Branch -> max(maximum(tree.left), maximum(tree.right))
    }

fun main() {
    val tree = Branch(
        Leaf(5),
        Branch(Leaf(1), Leaf(2))
    )
    println(maximum(tree))
//    5
}