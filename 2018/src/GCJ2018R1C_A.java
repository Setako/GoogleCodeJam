import java.util.*;

public class GCJ2018R1C_A {
    static Scanner in = new Scanner(System.in);
    int caseNum;

    public void solve() {
        int N = ni();
        int L = ni();
        nl();
        char[][] arr = new char[N][L];
        for (int i = 0; i < N; i++) {
            arr[i] = nl().toCharArray();
        }

        long[] possibility = new long[L];
        for (int i = L - 1; i >= 0; i--) {
            HashSet<Character> exist = new HashSet<>();
            int count = N;
            for (int j = 0; j < N; j++) {
                char looking = arr[j][i];
                if (exist.contains(looking)) {
                    count--;
                } else {
                    exist.add(looking);
                }
            }
            possibility[i] = count * (i + 1 < L ? possibility[i + 1] : 1);
        }


        HashMap<String, Long> wordPossi = new HashMap<>();
        for (int i = 0; i < N; i++) {
            char word[] = arr[i];
            for (int j = 1; j < L + 1; j++) {
                String wordStr = subStr(word, j);
                wordPossi.put(wordStr, wordPossi.getOrDefault(wordStr, j == possibility.length ? 0 : possibility[j]) - 1);
            }
        }

        printCase(walk(arr, "", wordPossi));


    }

    public static String walk(char[][] arr, String walked, HashMap<String, Long> wordPossi) {
        if (walked.length() == arr[0].length) return walked;

        for (int i = 0; i < arr.length; i++) {
            String word = walked + arr[i][walked.length()];
            if (!wordPossi.containsKey(word) || wordPossi.get(word) > 0) {
                return walk(arr, word, wordPossi);
            }
        }
        return "-";
    }

    public static String subStr(char[] word, int charNum) {
        char[] newWord = new char[charNum];
        System.arraycopy(word, 0, newWord, 0, charNum);
        return new String(newWord);
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
        for (int i = 1; i <= T; i++) new GCJ2018R1C_A(i).solve();
    }

    public GCJ2018R1C_A(int caseNum) {
        this.caseNum = caseNum;
    }
}
