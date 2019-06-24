package chapter3

sealed class Tree<out A> {
    data class Leaf<out A>(val a: A) : Tree<A>()
    data class Branch<out A>(val left: Tree<A>, val right: Tree<A>) : Tree<A>()
}

fun <A> treeOf(a: A): Tree<A> = Tree.Leaf(a)