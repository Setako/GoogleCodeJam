import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GCJ2017QR_A {
	Scanner in;
	BufferedWriter out;
	int T;

	public GCJ2017QR_A() throws IOException {
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

	boolean cp(char inp) {
		if (inp == '+') {
			return true;
		} else {
			return false;
		}
	}

	char exc(boolean inp) {
		if (inp) {
			return '+';
		} else {
			return '-';
		}
	}

	void fp(char[] fl, int K, int index) {
		for (int i = 0; i < K; i++) {
			fl[index + i] = exc(!cp(fl[index + i]));
		}
	}

	void solve(int c) {
		String strline = in.nextLine();
		char[] pcArr = strline.split(" ")[0].toCharArray();
		int K = Integer.parseInt(strline.split(" ")[1]);
		boolean end = false;
		boolean impossible = false;
		int count = 0;
		for (int i = 0; i < pcArr.length; i++) {
			if (pcArr.length - i < K) {
				end = true;
			}
			if (!cp(pcArr[i])) {
				if(!end){
					fp(pcArr, K, i);
					count ++ ;
				}
				else{
					impossible = true;
				}
			}
		}

		if (impossible) {
			qw(String.format("Case #%d: IMPOSSIBLE\n", c));
		} else {
			qw(String.format("Case #%d: %d\n", c,count));
		}

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
		new GCJ2017QR_A();
	}
}
