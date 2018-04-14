import java.util.Arrays;
import java.util.Scanner;

public class GCJ2018QR_C {
    static Scanner in = new Scanner(System.in);
    int caseNum;

    public void solve() {
        int a = ni();
        if (a != 20 && a != 200&&a!=10) throw new IllegalStateException(a+"");
        Map map = a == 20 ? new Map(5, 5) : a==200?new Map(20, 10):new Map(4,4);
        while (true) {
            int[] go = map.findMostValued();
            System.out.println((go[0] + 1) + " " + (go[1] + 1));
            System.out.flush();
            int y = ni();
            int x = ni();
            if (y + x == 0 || y + x == -2) {
                return;
            }
            map.prepare(y - 1, x - 1);
        }
    }

    class Map {
        int width;
        int height;

        boolean[][] prepared;
        int[][] valued;

        Map(int width, int height) {
            this.width = width;
            this.height = height;
            prepared = new boolean[height][width];
            valued = new int[height][width];
            for (int y = 1; y < height - 1; y++) {
                for (int x = 1; x < width - 1; x++) {
                    valued[y][x] = 9;
                }
            }
        }


        void prepare(int y, int x) {
            if (!prepared[y][x]) {
                for (int i = Math.max(x - 1, 1); i <= Math.min(x + 1, width - 2); i++) {
                    for (int j = Math.max(y - 1, 1); j <= Math.min(y + 1, height - 2); j++) {
                        valued[j][i] = valued[j][i] - 1;
                    }
                }
            }
            prepared[y][x] = true;
        }

        int[] findMostValued() {
            int[] res = new int[2];
            int highest = 0;

            for (int y = 1; y < height - 1; y++) {
                for (int x = 1; x < width - 1; x++) {
                    int value = valued[y][x];
                    if (value == 9) {
                        return new int[]{y, x};
                    } else if (value > highest) {
                        highest = value;
                        res[0] = y;
                        res[1] = x;
                    }
                }
            }
            if (highest == 0) return null;
            else return res;
        }


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
        for (int i = 1; i <= T; i++) new GCJ2018QR_C(i).solve();
    }

    public GCJ2018QR_C(int caseNum) {
        this.caseNum = caseNum;
    }
}
