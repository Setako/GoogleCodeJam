import java.util.*;

public class GCJ2018R1C_B {
    static Scanner in = new Scanner(System.in);
    int caseNum;

    int[] arr;

    HashMap<Integer, Integer> appearedTimes = new HashMap<>();

    HashSet<Integer> sold = new HashSet<>();

    public void solve() {
        int N = ni();

        for (int i = 0; i < N; i++) {
            step();
        }
    }

    public void step() {
        int flavorNum = ni();
        if (flavorNum == -1) {
            return;
        }
        int flavors[] = new int[flavorNum];
        for (int i = 0; i < flavorNum; i++) {
            flavors[i] = ni();
        }

        for (int i = 0; i < flavorNum; i++) {
            appearedTimes.put(flavors[i], appearedTimes.getOrDefault(flavors[i], 0) + 1);
        }

        int lessPeopleFlavor = -1;
        int lessPeople = Integer.MAX_VALUE;
        for (int i = 0; i < flavorNum; i++) {
            if (!sold.contains(flavors[i]) && appearedTimes.get(flavors[i]) < lessPeople) {
                lessPeople = appearedTimes.get(flavors[i]);
                lessPeopleFlavor = flavors[i];
            }
        }

        if (lessPeopleFlavor != -1) {
            sold.add(lessPeopleFlavor);
        }

        System.out.println(lessPeopleFlavor);
        System.out.flush();
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

    public static int numCharToInt(char c) {
        if (c < 48 || c > 57)
            throw new IllegalArgumentException();
        return c - 48;
    }

    public void printCase(String str) {
        System.out.printf("Case #%d: %s\n", caseNum, str);
    }

    public static void main(String... argv) {
        final int T = ni();
        nl();
        for (int i = 1; i <= T; i++) new GCJ2018R1C_B(i).solve();
    }

    public GCJ2018R1C_B(int caseNum) {
        this.caseNum = caseNum;
    }
}
