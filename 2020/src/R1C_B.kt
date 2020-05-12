import java.io.PrintStream
import java.math.BigInteger
import java.util.*
import kotlin.collections.HashSet

fun main() {
    val output = System.out
    val input = Scanner(System.`in`)
    Q1C_B(input, output).solve()
}

class Q1C_B(val input: Scanner, val output: PrintStream) {

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
            w("Case #${it + 1}: ${solution()}")
            wl()
        }
    }

    fun solution(): String {
        var QRs = (0 until 10000)
                .map { i ->
                    input.nextLong().toString() to nw()
                }

        val xs = QRs.map { it.second.first() }.groupBy { it }.mapValues { it.value.size }
                .map { it.key to it.value }
                .sortedBy { it.second }
                .asReversed()
                .map { it.first }

        val zero = QRs.flatMap { it.second.asIterable() }.distinct().find { c -> !xs.contains(c) }!!

        return zero + xs.joinToString("")
    }
}
