import java.io.PrintStream
import java.math.BigInteger
import java.util.*

fun main() {
    val output = System.out
    val input = Scanner(System.`in`)
    Q2_A(input, output).solve()
}

class Q2_A(val input: Scanner, val output: PrintStream) {

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
        var L = ni();
        var R = ni();

        var i = 1;
        while (L >= i || R >= i) {
            if (L >= R) L -= i;
            else R -= i;
            i++;
        }
        return "${i-1} $L $R"
    }
}
