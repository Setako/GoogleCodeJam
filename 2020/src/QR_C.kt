import java.io.PrintStream
import java.math.BigInteger
import java.util.*

fun main() {
    val output = System.out
    val input = Scanner(System.`in`)
    QR_C(input, output).solve()
}

class QR_C(val input: Scanner, val output: PrintStream) {

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
            w("Case #$testCase: ");
            calc();
            wl();
        }
    }

    class Job(val index: Int, val from: Int, val end: Int, var C: Boolean = false)

    fun calc() {
        val N = ni();

        val jobs = ArrayList<Job>(N);
        (0 until N).forEach { jobs.add(Job(it, ni(), ni())) }

        var cFreeAt = 0;
        var jFreeAt = 0;
        jobs.sortedBy { it.from }.forEach { job ->
            if (cFreeAt <= job.from) {
                job.C = true;
                cFreeAt = job.end;
            } else if (jFreeAt <= job.from) {
                job.C = false;
                jFreeAt = job.end;
            } else {
                w("IMPOSSIBLE");
                return;
            }
        }

        w(jobs.map { if (it.C) 'C' else 'J' }.joinToString(""));

    }
}
