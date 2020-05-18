import java.io.PrintStream
import java.math.BigInteger
import java.util.*
import kotlin.collections.HashMap
import kotlin.math.abs
import kotlin.math.absoluteValue

fun main() {
    val output = System.out
    val input = Scanner(System.`in`)
    Q2_B(input, output).solve()
}

class Q2_B(val input: Scanner, val output: PrintStream) {

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
        var C = ni();
        var D = ni();
        nl();
        var Xs = nil().mapIndexed { i, X -> (i + 2) to X }.toMutableList();
        Xs.add((1 to 0));

        var queries = (0 until D).map { ni() to ni() };

        var fixedTimes = Xs.filter { it.second >= 0 }.sortedBy { it.second }
        var dependTimes = Xs.filter { it.second < 0 }.sortedBy { it.second }.asReversed().let { LinkedList(it) }


        var computerReceiveTimeMap = HashMap<Int, Int>();
        fixedTimes.forEach { computerReceiveTimeMap[it.first] = it.second }

        var sentComputerCount = 0;
        fixedTimes.forEach { (computer, fixedTime) ->
            computerReceiveTimeMap[computer] = fixedTime
            sentComputerCount++;
            var internalTimeOffset = 1
            while (true) {
                var concurrentSentCount = 0;
                while (dependTimes.isNotEmpty() && abs(dependTimes.peek().second.absoluteValue) == sentComputerCount) {
                    concurrentSentCount++;
                    dependTimes.pop().let { computerReceiveTimeMap[it.first] = fixedTime + internalTimeOffset }
                }
                if (concurrentSentCount == 0) break;
                sentComputerCount += concurrentSentCount;
                internalTimeOffset++;
            }
        }

        return queries.map {
            val offset = abs(computerReceiveTimeMap[it.first]!! - computerReceiveTimeMap[it.second]!!)
            if (offset == 0) 1;// 0 is not allowed, offset = 0 = this path will not be used
            else offset;
        }.joinToString(" ")
    }
}
