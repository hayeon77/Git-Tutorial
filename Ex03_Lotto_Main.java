import java.util.Arrays;

/*
 1. 1~45까지의 난수를 발생시켜 6개의 배열에 담으세요
      (int)(Math.random()*45 + 1)
      lotto[0] = 44, lotto[1] = 1....lotto[5] = 33
 2. 배열에 담긴 6개의 배열값은 중복값이 나오면 안돼요 (중복값 검증 : 별찍기 비슷)
 3. 배열에 있는 6개의 값은 낮은 순으로 정렬시키세요 (정렬 : 자리바꿈)
 4. 위 결과를 담고 있는 배열을 출력하세요 (화면에 출력시키기)
 
 추후에는 별도의 클래스 분리해서 Lotto.java.....현재 main.......연습
 */

public class Ex03_Lotto_Main {

	public static void main(String[] args) {
		int[] lotto = new int[6];
		{
			for (int i = 0; i < 6; i++) {
				lotto[i] = (int) (Math.random() * 45 + 1);
				for (int j = 0; j < i; j++) {// j<i (채워진 개수만큼)
					if (lotto[i] == lotto[j]) {
						i--; // point! 같은 방의 값을 바꾸어야 한다
						break;
					}
				}
			}
			// 1. 6개 배열 모든 생성.. 배열값을 비교하고.. 중복값이 ...다시 6개를 만든다
			// 2. 배열값을 얻을 때마다 기존 방에 있는 값들과 비교한다

			// 정렬하기(6개의 배열 방이 만들어지고나서)
			// swap
			for (int i = 0; i < lotto.length; i++) {
				for (int j = i + 1; j < lotto.length; j++) {
					if (lotto[i] > lotto[j]) {
						int temp = lotto[i];
						lotto[i] = lotto[j];
						lotto[j] = temp;
					}
				}
			}

			// 출력하기
			for (int i = 0; i < lotto.length; i++) {
				System.out.println(lotto[i]);
			}
		}
	}
}
