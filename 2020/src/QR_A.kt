import java.io.PrintStream
import java.math.BigInteger
import java.util.*

fun main() {
    val output = System.out
    val input = Scanner(System.`in`)
    QR_A(input, output).solve()
}

class QR_A(val input: Scanner, val output: PrintStream) {

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

    fun solve() {
        val T = ni();
        (1..T).forEach { testCase ->
            val N = ni();
            val arr = Array(N) { Array(N) { 0 } };
            (0 until N).forEach { i ->
                (0 until N).forEach { j ->
                    arr[i][j] = ni();
                }
            }
            val rows = Array(N) { HashSet<Int>() }
            val cols = Array(N) { HashSet<Int>() };

            val rowsRepeat = Array(N) { false };
            val colsRepeat = Array(N) { false };

            (0 until N).forEach { i ->
                (0 until N).forEach { j ->
                    val value = arr[i][j];

                    if (rows[i].contains(value)) rowsRepeat[i] = true;
                    else rows[i].add(value);

                    if (cols[j].contains(value)) colsRepeat[j] = true;
                    else cols[j].add(value);
                }
            }


            val r1 = (0 until N).map { arr[it][it] }.sum()
            val r2 = rowsRepeat.filter { it }.count();
            val r3 = colsRepeat.filter { it }.count();

            w("Case #$testCase: $r1 $r2 $r3")
            wl()


        }

    }
}


