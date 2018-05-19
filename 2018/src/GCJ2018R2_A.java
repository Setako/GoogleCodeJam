import java.util.*;

public class GCJ2018R2_A {
    static Scanner in = new Scanner(System.in);
    int caseNum;

    List<Character[]> result = new ArrayList<>();

    int N;

    public void solve() {
        nl();
        int[] arr = nia();
        N = arr.length;

        if (Arrays.stream(arr).sum() != N || arr[0] == 0 || arr[N - 1] == 0) {
            printCase("IMPOSSIBLE");
            return;
        }

        int nextAllocate = 0;
        for (int i = 0; i < arr.length; i++) {
            int required = arr[i];
            if (required != 0 && nextAllocate < i) {//left
                int taken = Math.min(required, i - nextAllocate);
                int offset = i - nextAllocate - taken;
                makeLeft(i, taken + offset);
                nextAllocate += taken;
                required -= taken;
            }
            if (required != 0 && nextAllocate == i) {
                makeMid();
                nextAllocate++;
                required--;
            }
            if (required != 0 && nextAllocate > i) {
                int offset = nextAllocate - i - 1;
                makeRight(i, offset + required);
                nextAllocate += required;
            }
        }

        printCase(result.size()+1+"");
        for (int i = result.size() - 1; i >= 0; i--) {
            for (Character c : result.get(i)) {
                if (c == null) {
                    System.out.print('.');
                } else {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
        for (int i = 0; i < N; i++) {
            System.out.print('.');
        }
        System.out.println();



    }

    public Character[] getRow(int row) {
        while (result.size() < row + 1) {
            result.add(new Character[N]);
        }
        return result.get(row);
    }

    public void makeLeft(int baseIndex, int num) {
        for (int i = 0; i < num; i++) {
            int height = i;
            int col = baseIndex - (i + 1);
            getRow(height)[col] = '\\';
        }
    }

    public void makeRight(int baseIndex, int num) {
        for (int i = 0; i < num; i++) {
            int height = i;
            int col = baseIndex + (i + 1);
            getRow(height)[col] = '/';
        }
    }

    public void makeMid() {

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
        for (int i = 1; i <= T; i++) new GCJ2018R2_A(i).solve();
    }

    public GCJ2018R2_A(int caseNum) {
        this.caseNum = caseNum;
    }
}
