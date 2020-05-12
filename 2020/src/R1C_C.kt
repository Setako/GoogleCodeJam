import java.io.PrintStream
import java.math.BigInteger
import java.util.*

fun main() {
    val output = System.out
    val input = Scanner(System.`in`)
    Q1C_C(input, output).solve()
}

class Q1C_C(val input: Scanner, val output: PrintStream) {

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

    fun solution(): Int {
        val N = ni()
        val D = ni()
        val A = (1..N).map { input.nextLong() }

        val xs = A.groupBy { it }

        if (D == 2) {
            if (xs.any { it.value.size >= 2 }) return 0
            else return 1
        }

        if (D == 3) {
            if (xs.any { it.value.size >= 3 }) return 0
            else {
                var x = null
                var k = xs.entries.find { it.value.size == 2 }
                if (k != null) {
                    if (xs.entries.any { it.key > k.key }) return 1
                }
                if (xs.any { (k, v) ->
                            xs.containsKey(k / 2)
                        }) {
                    return 1
                } else {
                    return 2
                }
            }
        }
        TODO()
    }
}
