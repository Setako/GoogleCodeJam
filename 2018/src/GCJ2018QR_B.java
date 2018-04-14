import java.util.Arrays;
import java.util.Scanner;

public class GCJ2018QR_B {
    static Scanner in = new Scanner(System.in);
    int caseNum;

    public void solve() {
        int n = ni();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = ni();
        }

        int[] arr1 = new int[n / 2 + n % 2];
        int[] arr2 = new int[n / 2];

        for (int i = 0; i < n; i += 2) {
            arr1[i / 2] = arr[i];
        }
        for (int i = 1; i < n; i += 2) {
            arr2[i / 2] = arr[i];
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int prev = arr1[0];
        for (int i = 1; i < n; i++) {
            int curr = i % 2 == 0 ? arr1[i / 2] : arr2[i / 2];
            if (prev > curr) {
                printCase(i - 1 + "");
                return;
            }
            prev = curr;
        }

        printCase("OK");

    }


    public static <D> void swap(D[] arr, int i1, int i2) {
        D temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
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

    public void printCase(String str) {
        System.out.printf("Case #%d: %s\n", caseNum, str);
    }

    public static void main(String... argv) {
        final int T = ni();
        nl();
        for (int i = 1; i <= T; i++) new GCJ2018QR_B(i).solve();
    }

    public GCJ2018QR_B(int caseNum) {
        this.caseNum = caseNum;
    }
}
