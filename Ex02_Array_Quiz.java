
public class Ex02_Array_Quiz {
	public static void main(String[] args) {
		// 수학과 학생들의 기말고사 시험점수
		int[] score = new int[] { 79, 88, 97, 54, 56, 95 };
		int max = score[0]; // 79
		int min = score[0]; // 79

		// 제어문을 사용해서 max라는 변수에 시험점수 최대값을, min변수에는 최소값을 담도록 하시오.
		// 화면에는 max=97, min=54라고 찍히면 됩니다. 단, for문은 한 번만 사용.

		for (int i = 0; i < score.length; i++) {
			// System.out.println(score[i]);
			if (score[i] > max) {
				max = score[i];
			}
			if (score[i] < min) {
				min = score[i];
			}
		}
		System.out.println("최대값:" + max);
		System.out.println("최소값:" + min);

		int[] number = new int[10];

		// 10개 방의 값을 1~10까지의 값으로 초기화 하세요
		// number[0] >>1.........number[9] >>10으로...
		// for문을 사용하세요

		for (int i = 0; i < number.length; i++) {
			number[i] = i + 1;
		}

		for (int i = 0; i < number.length; i++) {
			System.out.print(number[i] + "\t");
		}
		System.out.println();

		// 어느 학생의 기말고사 시험점수(5과목)
		int sum = 0;
		float average = 0f;
		int[] jumsu = { 100, 59, 90, 60, 78 };
		/*
		 * 1. 총과목수 2. 과목의 합 3. 과목의 평균을 구하세요 단, 2번과 3번문제는 하나의 for문만 사용해서 구하시오
		 */

		for (int i = 0; i < jumsu.length; i++) {
			// System.out.println(jumsu[i]);
			// sum = sum+jumsu[1];
			sum += jumsu[1];
			// average = sum / jumsu.length; ㅇ연산은 매번 수행 >> 1번만 수행 >>ㅣ점
			// 어느 시점에 평균 (모든 합을 다 누적하고 나서)
			if (i == jumsu.length - 1) {
				average = sum / (float) jumsu.length;
			}
		}
		System.out.printf("총과목수:[%d], 총점:[%d], 평균:[%f]", jumsu.length, sum, average);
	}

}
