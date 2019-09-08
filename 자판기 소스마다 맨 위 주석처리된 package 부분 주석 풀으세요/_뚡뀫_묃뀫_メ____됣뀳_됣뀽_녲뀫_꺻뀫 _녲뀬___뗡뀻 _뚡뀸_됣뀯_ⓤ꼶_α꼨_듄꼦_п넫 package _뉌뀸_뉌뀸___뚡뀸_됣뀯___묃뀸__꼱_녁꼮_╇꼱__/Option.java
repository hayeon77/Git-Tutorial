//package vending.sample.dj;

public class Option extends Product {			// Product 클래스를 상속 받는다. 

	public Option(int optionCount) {			// 해당 옵션의 수량을 결정받아(우리 자판기는 초반,자판기 생성과 동시에 이모든걸 고정적으로 저장한다.)
												// 저장한다. 
		this.count = optionCount;				// 생성자로부터 입력받은 수량을 count 변수에 저장한다. 여기에는 count변수가 없지만, 부모클래스인				
												// Product클래스에 count 변수가 존재한다. 부모꺼는 내꺼. 내꺼도 내꺼.
	}

	public void disOptionCount(int count) {		// 사용자가 헤당 옵션을 추가해서 먹으면 그만큼 수량이 줄어야한다. 그 역할을 한다.
		this.count -= count;
	}
}

class Water extends Option {					// 가장 자식인 자식 클래스, Product >> Option >> Water 로 상속이 내려온다.
												// 
	public Water(int optionCount) {				// 생성될 때 수량을 입력받는다. 
		super(optionCount);
	}

	@Override
	public String toString() {					// 해당 옵션의 남은 수량을 보여주는 역할이다. 
		return "물:\t\t" + "잔여갯수:" + count + "\t";
	}
}

class Ice extends Option {						// 이해 생략 하겠다 구조가 다 같다.
	public Ice(int optionCount) {
		super(optionCount);
	}

	@Override
	public String toString() {
		return "얼음:\t\t" + "잔여갯수:" + count + "\t";
	}
}

class Pearl extends Option {
	public Pearl(int optionCount) {
		super(optionCount);
	}

	@Override
	public String toString() {
		return "펄:\t\t" + "잔여갯수:" + count + "\t";
	}
}