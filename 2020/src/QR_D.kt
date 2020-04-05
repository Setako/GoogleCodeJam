import java.io.PrintStream
import java.math.BigInteger
import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val output = System.out
    val input = Scanner(System.`in`)
    QR_D(input, output).solve()
}

class QR_D(val input: Scanner, val output: PrintStream) {

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
        val B = ni();
        nl();


        repeat(T) {
            var si: Int? = null;
            var ri: Int? = null;

            val odd = B % 2 != 0;

            // 0 1 2 3 4 (5)
            val knownHead = ArrayList<Boolean>((B / 2) + if (odd) 1 else 0);

            // 10 9 8 7 6
            val knownTail = ArrayList<Boolean>((B / 2));

            var asking = 0;
            var askingTimes = 0;
            fun ask(index: Int): Boolean {
                askingTimes++;
                output.println(index + 1);
                return (ni() == 1).also { nl(); }
            }

            fun flip() {
                knownHead.forEachIndexed { index, b -> knownHead[index] = !b }
                knownTail.forEachIndexed { index, b -> knownTail[index] = !b }
            }

            fun reverse() {
                knownHead.forEachIndexed { index, b ->
                    val temp = knownTail[index];
                    knownTail[index] = b
                    knownHead[index] = temp
                }
            }

            while (asking * 2 < B) {
                if (askingTimes % 10 == 0 && asking != 0) {
                    if (si == null || ri == null) {
                        val validationLeft = ask(0)
                        ask(0); // give up once chance
                        // flip all
                        if (validationLeft != knownHead[0]) flip()
                    } else {
                        val s = ask(si) == knownHead[si];
                        val r = ask(ri) == knownHead[ri];
                        when {
                            s && r -> Unit
                            !s && !r -> flip()
                            s && !r -> reverse()
                            !s && r -> flip().also { reverse() }
                        }
                    }
                }
                val left = ask(asking);
                val right = if ((asking + 1) * 2 <= B) ask(B - asking - 1) else null;
                if (si == null && right != null && left == right) si = asking
                if (ri == null && right != null && left != right) ri = asking
                knownHead.add(left);
                right?.let { knownTail.add(it) }
                asking++;
            }

//            while (askingTimes < 150) ask(0);
            output.println(knownHead.map { if (it) '1' else '0' }.joinToString("")
                    + knownTail.reversed().map { if (it) '1' else '0' }.joinToString(""));

            if (nl().contains("N")) return;

        }
    }
}
