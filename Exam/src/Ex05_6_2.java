
public class Ex05_6_2 {

	public static void main(String[] args) {
		int sum = 0;

		for (int n = 1; n % 2 == 1; n++) {
			sum += n;
			if (sum > 1000) {
				System.out.println("��:" + sum);
				System.out.println("1000�� �Ѵ� ��:" + n);
				break;
			}
			n++;
		}
	}
}
//for���� ���� ��, ���� n++�ؼ� 2�� �Ǹ�, ������ ��������