import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GCJ2017QR_B {
	Scanner in;
	BufferedWriter out;
	int T;

	public GCJ2017QR_B() throws IOException {
		String name = "System";

		in = new Scanner(new File(name + ".in"));
		out = new BufferedWriter(new FileWriter(name + ".out"));
		T = in.nextInt();
		in.nextLine();

		for (int c = 1; c <= T; c++) {
			solve(c);
		}

		in.close();
	}

	void setNine(int[] arr, int lastDifferentNumIndex) {
		for (int i = lastDifferentNumIndex + 1; i < arr.length; i++) {
			arr[i] = 9;
		}
	}

	void solve(int c) {
		char[] a = in.nextLine().toCharArray();
		int[] arr = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			arr[i] = Integer.parseInt(a[i] + "");
		}

		int lastNum = 0;
		int lastDifferentNumIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > lastNum) {
				lastDifferentNumIndex = i;
				lastNum = arr[i];
			} else if (arr[i] == lastNum) {

			} else {
				arr[lastDifferentNumIndex] = arr[lastDifferentNumIndex] - 1;
				setNine(arr, lastDifferentNumIndex);
			}
		}
		String reslut = "";
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 && arr[i] == 0) {
				continue;
			}
			reslut = reslut + arr[i];
		}

		qw(String.format("Case #%d: %s\n", c,reslut));

		// %s = string
		// %c = char
		// %b = bool
		// %d = long
		// %f = float
		// %n = ln
	}

	void qw(String string) {
		System.out.print(string);
		try {
			out.write(string);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		new GCJ2017QR_B();
	}
}
