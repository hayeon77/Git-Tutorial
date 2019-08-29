import java.util.Arrays;

//배열은 객체다
//new, memory(heap)
//고정(정적) 배열(크기가 고정) >> 단점 때문에 collection(동적배열)
public class Ex01_Array_Basic {
	public static void main(String[] args) {
		// int score=10, score2=20, score3=30...;
		int[] score = new int[3];
		System.out.println("score 변수 (아파트 주소)" + score);
		// score 배열의 시작 주소값...
		// Array는 각각의 방을 가지고 있다 (방은 int크기만함)
		//각각의 방의 접근은 : 첨자, index >> 0번 방부터 시작>>시작값0
		//배열은 타입의 기본값을 초기값으로 갖는다.
		System.out.println(score[0]);
		System.out.println(score[1]);
		System.out.println(score[2]);
		
		score[1] = 1111;
		System.out.println(score[1]);
		
		//score[3] = 5000;
		//java.lang.ArrayIndexOutOfBoundsException: 3
		//에러가 발생했습니다.........그래서 당신의 프로그램을 강제로 종료하겠습니다ㅠ
		//try catch..오류를 수정하는 것이 아니고 프로그램이 강제 종료 되는 것을 막는 방법
		
		//Array 궁합이 제일 좋은 제어문..(for)
		for(int i =0; i < 3; i++) {
			System.out.printf("[%d]=%d\t",i,score[i]);
		}
		System.out.println();
//Tip Array 도와주는 보조 클래스 (helper 클래스)
		String result = Arrays.toString(score);
		System.out.println(result);
		Arrays.sort(score);
		result=Arrays.toString(score);
		System.out.println("sort:"+result); //처음 하는 분은 정렬하는 코드...
		
		//today point꼭 암기!
		//배열을 만드는 방법 3가지
		
		int[] arr = new int[5]; //기본 (방의 개수 지정하는 방법)
		int[] arr2 = new int[] {100,200,300}; //초기값을 가지고 방까지 만듦 
		int[] arr3 = {11,22,33,44,55}; //컴파일러가 알아서 new 자동 생성..
		//javascript : (Var) let cars = [11,22,33,44,55]
		
		for(int i =0; i<arr3.length ; i++) {
			System.out.println(arr3[i]);
		}
		
		//객체 선언 할당을 분리
		//Car c; 선언
		//c = new Car(); 할당
		
		//배열은 객체다
		int[] arr4;
		arr4 = new int[] {21,22,23,24,25}; //할당 arr4라는 변수에 주소값을 넘기는 것
		
		int[] arr5 = arr4; //주소값 할당
		System.out.println(arr5 == arr4);
		
		String[] strarray = new String[] {"가","나","다라마"};
		char[] ch = new char[10]; //빈문자 '\u0000'
		for(int j = 0; j < ch.length; j++) {
			System.out.println(">"+ch[j]+"<");
		}
		 
		//8가지 기본타입 + String  Array 생성 가능
		//*******클래스도 배열 생성 가능*********자동차 10대
		//클래스 == 설계도 == 타입
		//Car
		//Car c = new Car();
		//Car c2 = new Car();
		
		//Car[] cars = new Car[10];
		
		
		
		
		
		
	}

}
