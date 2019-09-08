
public class Ex05_7 {

	public static void main(String[] args) {
		// 5-7-1
		for (int a = 2; a <= 9; a += 2) {
			for (int b = 1; b <= 9; b++) {
				System.out.println(a + "x" + b + "=" + (a * b));
				if (b >= a) {
					break;
				}
			}
		}
		// 5-7-2
		for (int q = 0; q <= 9; q++) {
			for (int w = 0; w <= 9; w++) {
				if ((w * 10 + q) + (q * 10 + w) == 99)
					System.out.println(q + "," + w);
			}
		}
	}
}
