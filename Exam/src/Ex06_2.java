
public class Ex06_2 {

	public static void main(String[] args) {
		/*
		 * int result; result=circle(10); System.out.println("원의 넓이:"+result); } Public
		 * static void circle(int a); int round=(2*3.14*a); return round;
		 * 
		 * }
		 * 
		 * 
		 * }
		 */

		// 2번
		for (int a = 1; a <= 100; a++) {
			if (print(a)) {
				System.out.println(a);
			}
		}
	}

	public static boolean print(int w) {
		if (w == 1)
			return false;

		for (int a = 2; a < w; a++) {
			if (w % a == 0)
				return false;
		}
		return true;
	}
}