import java.util.Arrays;
import java.util.Scanner;

public class GCJ2018QR_A {
    static Scanner in = new Scanner(System.in);
    int caseNum;

    public void solve() {
        String[] line = nl().split(" ");
        int D = Integer.parseInt(line[0]);
        Character[] P = line[1].chars().mapToObj(c -> (char) c).toArray(Character[]::new);

        int ans = 0;

        m:
        while (calD(P) > D) {
            for (int i = P.length - 1; i >= 1; i--) {
                if (P[i] == 'S' && P[i - 1] == 'C') {
                    swap(P, i, i - 1);
                    ans++;
                    continue m;
                }
            }
            printCase("IMPOSSIBLE");
            return;
        }
        printCase(ans + "");
    }

    int calD(Character[] chars) {
        int damage = 1;
        int totalDamage = 0;
        for (char c : chars) {
            if (c == 'C') damage *= 2;
            else totalDamage += damage;
        }
        return totalDamage;
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
        for (int i = 1; i <= T; i++) new GCJ2018QR_A(i).solve();
    }

    public GCJ2018QR_A(int caseNum) {
        this.caseNum = caseNum;
    }
}
