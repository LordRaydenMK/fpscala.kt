package chapter3

import chapter3.Tree.Leaf
import chapter3.Tree.Branch

fun <A> size(tree: Tree<A>): Int =
    when (tree) {
        is Leaf -> 1
        is Branch -> 1 + size(tree.left) + size(tree.right)
    }

fun main() {
    val tree = Branch(
        Leaf(5),
        Branch(Leaf(1), Leaf(2))
    )
    println(size(tree))
//    5
}