//package vending.sample.dj;

public abstract class Product {  // 추상화 클래스이다. 드링크의 이름과 수량을 담고있다. 
	String name;				 // 이 추상화 클래스를 굳이 만든 이유는 Drink클래스와 Option 클래스을 묶어서 Product 타입으로 사용하기위함이다.
	int count;
}