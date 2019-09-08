
public class Ex06_1 {

	public static void main(String[] args) {
		// 1¹ø
		number(35, 5);
		///
		number(4, 39);
	}

	public static void number(int a, int b) {
		System.out.println(a + "+" + b + "=" + (a + b));
		System.out.println(a + "-" + b + "=" + (a - b));
		System.out.println(a + "/" + b + "=" + (a / b));
		System.out.println(a + "%" + b + "=" + (a % b));
		System.out.println(a + "x" + b + "=" + (a * b));

		// 2¹ø

		qq(1, 9);
		qq(-7, -3);
		qq(5, -2);
	}

	public static void qq(int a, int b) {
		if (a > b)
			System.out.println(a - b);
		else
			System.out.println(b - a);
	}
}
