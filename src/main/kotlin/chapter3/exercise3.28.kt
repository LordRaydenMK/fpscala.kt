package chapter3

import chapter3.Tree.Leaf
import chapter3.Tree.Branch
import kotlin.math.max

fun <A, B> map(tree: Tree<A>, f: (A) -> B): Tree<B> =
    when (tree) {
        is Leaf -> Leaf(f(tree.a))
        is Branch -> Branch(map(tree.left, f), map(tree.right, f))
    }

fun main() {
    val tree = Branch(
        Leaf(5),
        Branch(
            Branch(Leaf(10), Leaf(1)),
            Leaf(2)
        )
    )
    println(map(tree) { it + 10 })
//    Branch(left=Leaf(a=15), right=Branch(left=Branch(left=Leaf(a=20), right=Leaf(a=11)), right=Leaf(a=12)))
}