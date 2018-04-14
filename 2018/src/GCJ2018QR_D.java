import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class GCJ2018QR_D {
    static Scanner in = new Scanner(System.in);
    int caseNum;

    class Face {
        double x, y, z;

        double angleX = 0;
        double angleY = 0;

        public Face(double x, double y, double z, double angleX, double angleY) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.angleX = angleX;
            this.angleY = angleY;
        }

        void rotateX(double angle) {
            angleX += angle;

        }

        void rotateY(double angle) {
            angleY += angle;
        }

        public double getX() {
            if (angleX <= 90) return Math.sin(Math.toRadians(angleX)) * 0.5;
            else return Math.sin(Math.toRadians(180 - angleX)) * 0.5;
        }

        public double getY() {
            if (angleX <= 90) return Math.cos(Math.toRadians(angleX)) * 0.5;
            else return -Math.cos(Math.toRadians(180 - angleX)) * 0.5;
        }

        public double getZ() {
            return 0;
        }

        @Override
        public String toString() {
            return getY() + " " + getX() + " " + getZ();
        }
    }

    public void solve() {
        double a = in.nextDouble();
        double requiredAngle = Math.toDegrees(bs(
                a,1000,0,Math.PI/2,v->Math.cos(v)+Math.sin(v)
        ));
        Face fa = new Face(0.5, 0, 0, 0 + requiredAngle, 0);
        Face fb = new Face(0.5, 0, 0, 90 + requiredAngle, 0);
        printCase("");
        System.out.println(fa);
        System.out.println(fb);
        System.out.println("0 0 0.5");
    }

    public double bs(double value, int times, double a, double b, Function<Double, Double> func) {
        double trial = -1;
        while (times > 0) {
            times--;
            trial = (b - a) / 2 + a;
            double trialResult = func.apply(trial);
            if (trialResult == value) break;
            if (trialResult > value) {
                b = trial;
            } else {
                a = trial;
            }
        }
        return trial;
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
        for (int i = 1; i <= T; i++) new GCJ2018QR_D(i).solve();
    }

    public GCJ2018QR_D(int caseNum) {
        this.caseNum = caseNum;
    }
}
