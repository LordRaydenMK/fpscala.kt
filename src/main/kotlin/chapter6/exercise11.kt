package chapter6

sealed class Input
object Coin : Input()
object Turn : Input()

data class Machine(val locked: Boolean, val candies: Int, val coins: Int)

object Candy {

    fun update(): (Pair<Input, Machine>) -> Machine =
        { (i, s) ->
            when {
                s.candies == 0 -> s
                i == Coin && !s.locked -> s
                i == Turn && s.locked -> s
                i == Coin && s.locked -> Machine(false, s.candies, s.coins + 1)
                i == Turn && !s.locked -> Machine(true, s.candies - 1, s.coins)
                else -> throw IllegalStateException()
            }
        }
}

fun simulateMachine(inputs: List<Input>): State<Machine, Pair<Int, Int>> =
    State.sequence(inputs.map { State.modify<Machine> { s -> Candy.update()(Pair(it, s)) } })
        .flatMap { State.get<Machine>() }
        .map { Pair(it.coins, it.candies) }

fun main() {
    val input = listOf(Coin, Turn, Coin, Turn, Coin, Turn, Coin, Turn)
    val sim = simulateMachine(input)
    println(sim.run(Machine(true, 5, 10)))
//    ((14, 1), Machine(locked=true, candies=1, coins=14))
}