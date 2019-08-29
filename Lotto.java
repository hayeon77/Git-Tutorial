package kr.or.bit;

import java.util.Random;
import java.util.Scanner;

public class Lotto {
   private int[] numbers;
   private Random random;
   private Scanner scanner;

   public Lotto() {
      numbers = new int[6];
      random = new Random();
      scanner = new Scanner(System.in);
   }

   // 각 기능 분리
   public void selectLottoNumber() {
    loop_1:  while (true) {
         String selection = showMenu(scanner);
         switch (selection) {
         case "1": // 로또 번호 함수 추출
            do {
               makeLottoNumber();
            } while (!checkAverage());
            showNumbers();
            break;
         case "2": // 프로그램 종료
        	 System.out.println("Good Lucky");
            break loop_1;
         default:
            System.out.println("Not in Operation.");
            break;
         }
      }
   }

   // 메뉴 설정 기능 함수
   private String showMenu(Scanner scanner) {
      System.out.println("********************");
      System.out.println("1. 당첨 예상 번호 추출하기");
      System.out.println("2. 프로그램 종료하기");
      System.out.println("********************");
      System.out.print("원하는 작업 번호를 선택하세요 >> ");

      return scanner.nextLine();
   }

   private void makeLottoNumber() {
      for (int i = 0; i < numbers.length; i++) {
         numbers[i] = random.nextInt(45) + 1;
         for (int j = i - 1; j >= 0; j--) {
            if (numbers[j] == numbers[i]) {
               i--;
               break;
            }
         }
      }
   }

   // 규칙 (배열의 합이 특정 범위에 해당되면 추출)
   private boolean checkAverage() {
      boolean result = false;
      int sum = 0;
      int average = 0;
      for (int value : numbers)
         sum += value;
      average = sum / numbers.length;
      System.out.println("평균 : " + average);

      return (average > 15 && average <= 25);
   }

   private void showNumbers() {
      sort();
      for (int value : numbers)
         System.out.printf("[%2d] ", value);
      System.out.println();
   }

   private void sort() {
      for (int i = 0; i < numbers.length; i++) {
//         for (int j = 0; j < lotto.length - 1; j++) {
//            if (lotto[j] > lotto[j + 1]) {
//               int temp = lotto[j + 1];
//               lotto[j + 1] = lotto[j];
//               lotto[j] = temp;
//            }
//         }

         // 선택정렬
         for (int j = i + 1; j < numbers.length; j++) {
            if (numbers[i] > numbers[j]) {
               int temp = numbers[i];
               numbers[i] = numbers[j];
               numbers[j] = temp;
            }
         }
      }

   }
}