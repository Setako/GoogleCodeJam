import java.io.PrintStream
import java.math.BigInteger
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val output = System.out
    val input = Scanner(System.`in`)
    QR_B(input, output).solve()
}

class QR_B(val input: Scanner, val output: PrintStream) {

    val ZERO = BigInteger.valueOf(0)
    fun ni(): Int = input.nextInt()
    fun nl(): String = input.nextLine()
    fun nil(): List<Int> = input.nextLine().split(" ").map { it.toInt() }
    fun nbil(): List<BigInteger> = input.nextLine().split(" ").map { it.toBigInteger() }

    fun w(str: String) = output.print(str)
    fun w(num: Number) = output.print(num.toString())
    fun w(arr: Array<Number>) = output.print(arr.joinToString(separator = " ", transform = Number::toString))
    fun w(arr: Collection<Number>) = output.print(arr.joinToString(separator = " ", transform = Number::toString))
    fun wl() = output.println()

    class Group(
            var c: Int,
            var amount: Int
    )

    fun solve() {
        val T = ni();
        nl();
        (1..T).forEach { testCase ->
            val str = nl();

            val charGrps = ArrayList<Group>();

            var lastGrps: Group = Group(-1, 0);
            str.toCharArray().map { it.toInt() - 48 }.forEach {
                if (lastGrps.c != it) {
                    lastGrps = Group(it, 0)
                    charGrps.add(lastGrps)
                }
                lastGrps.amount++;
            }

            fun printOffset(offset: Int) {
                if (offset > 0) repeat(offset) { w("(") }
                if (offset < 0) repeat(-offset) { w(")") }
            }

            w("Case #$testCase: ");
            var current = 0;
            charGrps.forEach { grp ->
                val offset = grp.c - current;
                printOffset(offset);
                current = grp.c;
                val cha = (grp.c + 48).toChar();
                repeat(grp.amount) { w(cha + "") };
            }
            printOffset(0 - current);
            wl();
        }

    }
}
