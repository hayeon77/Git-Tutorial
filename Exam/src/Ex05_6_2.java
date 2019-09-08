
public class Ex05_6_2 {

	public static void main(String[] args) {
		int sum = 0;

		for (int n = 1; n % 2 == 1; n++) {
			sum += n;
			if (sum > 1000) {
				System.out.println("합:" + sum);
				System.out.println("1000을 넘는 수:" + n);
				break;
			}
			n++;
		}
	}
}
//for문을 썼을 때, 만약 n++해서 2가 되면, 실행이 가능한지