import java.util.Arrays;
import java.util.Scanner;

public class GCJ2018P_A {
    public static Scanner in = new Scanner(System.in);

    public static void solve(int caseNum) {
        int a = ni();
        int b = ni();
        int n = ni();
        nl();
        guess(a + 1, b);
    }

    public static int guess(int a, int b) {
        int mid = a + ((b - a) / 2);
        System.out.println(mid);
        switch (nl()) {
            case "CORRECT":
                return mid;
            case "TOO_SMALL":
                return guess(mid + 1, b);
            case "TOO_BIG":
                return guess(a, mid - 1);
            case "WRONG_ANSWER":
                return -1;
            default:
                throw new IllegalStateException();
        }
    }


    public static int ni() {
        return in.nextInt();
    }

    public static String nl() {
        return in.nextLine();
    }

    public static int[] nia() {
        return Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static void main(String... argv) {
        final int T = ni();
        nl();
        for (int i = 0; i < T; i++) solve(i);
    }
}
