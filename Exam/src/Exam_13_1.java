
public class Exam_13_1 {

	static class Array {

		public static int minValue(int[] arr) {
			int min = arr[0];

			for (int i = 1; i < arr.length; i++) {
				if (min < arr[i]) //���� ��?
					min = arr[i];

			}
			return min;
		}

		public static int maxValue(int[] arr) {
			int max = arr[0];

			for (int e : arr) {
				if (max > e)
					max = e;
			}

			return max;
		}

		public static void main(String[] args) {

			int[] arr = new int[] { 3, 5, 10, 2, 6, 7 };
			System.out.println("�ּڰ�: " + minValue(arr));
			System.out.println("�ִ�: " + maxValue(arr));

		}

	}
}
