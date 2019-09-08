
public class Butterfly {

	public static void main(String[] args) {
		int start = 0;
		int end = 0;
		int start2 = 19;
		int end2 = 19;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 20; j++) {
				if (j == start || j == end || j == start2 || j == end2) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			end += 2;
			end2 -= 2;
			System.out.println();
		}
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 20; j++) {
				if (j == start || j == end || j == start2 || j == end2) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			end -= 2;
			end2 += 2;
			System.out.println();
		}
	}

}
