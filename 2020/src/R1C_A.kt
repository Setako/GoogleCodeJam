import java.io.PrintStream
import java.lang.Math.abs
import java.math.BigInteger
import java.util.*

fun main() {
    val output = System.out
    val input = Scanner(System.`in`)
    Q1C_A(input, output).solve()
}

class Q1C_A(val input: Scanner, val output: PrintStream) {

    val ZERO = BigInteger.valueOf(0)
    fun ni(): Int = input.nextInt()
    fun nl(): String = input.nextLine()
    fun nw(): String = input.next()
    fun nil(): List<Int> = input.nextLine().split(" ").map { it.toInt() }
    fun nbil(): List<BigInteger> = input.nextLine().split(" ").map { it.toBigInteger() }

    fun w(str: String) = output.print(str)
    fun w(num: Number) = output.print(num.toString())
    fun w(arr: Array<Number>) = output.print(arr.joinToString(separator = " ", transform = Number::toString))
    fun w(arr: Collection<Number>) = output.print(arr.joinToString(separator = " ", transform = Number::toString))
    fun wl() = output.println()


    fun solve() {
        val T = ni();
        repeat(T) {
            w("Case #${it+1}: ${solution()}")
            wl()
        }
    }

    fun solution(): String {
        var X = ni()
        var Y = ni()
        val M = nw()

        (0..M.length).forEach { step ->
            if (step != 0) {
                when (M[step - 1]) {
                    'N' -> Y++
                    'E' -> X++
                    'S' -> Y--
                    'W' -> X--
                    else -> throw IllegalArgumentException()
                }
            }
//            println("${X + Y} -> $step")
            if (abs(X) + abs(Y) <= step) return step.toString()
        }
        return "IMPOSSIBLE"
    }
}
