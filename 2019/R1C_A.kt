import java.io.PrintStream
import java.math.BigInteger
import java.util.*
import kotlin.collections.HashMap

fun main() {
    val output = System.out
    val input = Scanner(System.`in`)
    Solution(input, output).solve()
}

class Solution(val input: Scanner, val output: PrintStream) {

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

    //

    var T: Int = 0;

    fun solve() {
        calc()
    }

    fun calc() {
        val T = ni()
        val F = ni()
        nl()


        for (i in 1..T) {

            val alphabets = arrayOf("A", "B", "C", "D", "E")

            var tried = 0
            var result = ""
            val count = hashMapOf(
                    "A" to 0,
                    "B" to 0,
                    "C" to 0,
                    "D" to 0,
                    "E" to 0
            )
            val availaleLines: HashMap<Int, Boolean> = HashMap((0..118).associateBy({ it }, { true }))
            for (stage in 1..5) {
                val linesResult: HashMap<Int, String?> = HashMap((0..118).associateBy({ it }, { null }))
                for (j in availaleLines.filter { it.value }.map { it.key }) {
                    tried++
                    if (tried > F) throw java.lang.IllegalStateException()
                    w(j * 5 + stage)
                    wl()
                    nl().let {
                        if (!alphabets.contains(it)) throw IllegalStateException("" + (j * 5 + stage))
                        linesResult[j] = it
                        count[it] = count[it]!! + 1
                    }
                }
                val charResult = count.entries.sortedBy { it.value }.first().key
                result += charResult

                linesResult.filter { it.value != charResult }.forEach { lineIndex: Int, charString: String? ->
                    availaleLines[lineIndex] = false
                }

                count.remove(charResult)
                count.keys.forEach { count[it] = 0 }

            }

            while (tried < F) {
                w(1)
                wl()
                nl()
                tried++
            }

            w(result)
            wl()

            val resp = nl()

            if (resp == "N") return
        }
    }

}
