//package vending.sample.dj;

class Drink extends Product { 						// Product 함수를 상속받는다.
	int price;                 						// 각 음료수의 가격이다.
	boolean isCostomIce;       						// 음료수마다 선택 할 수 있는 옵션이 있는데 각각 그게 서로 다르므로, 그것을 구분시키기위해 
													// boolean 으로 변수를 선언했다.
	boolean isCostomWater;     
	boolean isCostomPearl;     

	public Drink(String name, int price, int count) {	// Drink 클래스는 객체화됨과 (=생성될 때) 동시에, 그 음료의 이름과 가격, 수량을 입력받는다.
		this.name = name;								// 우리 자판기는 자판기가 생성될 때, 바로 이부분에서 자동으로 음료수이름과 가격, 수량이 
														// 고정으로 입력 받는다. 즉 자판기를 객체화함과 동시에,
														// Drink[0] 배열 방에 탄산, Drink[1] 방에는 차, Drink[2]방에는 커피를 담는다.
		this.price = price;								// Drink[] 생성과 담는 과정 은 여기에는 없고,(여기는 단지 Drink의 설계도이다) 
		this.count = count;								// VendingMachine_new 부분 초반에 있다. 
	}													// 매우 중요한 개념이므로 이 부분에서 이해안되면 질문해야한다. 

	public String toString() {                      // toString을 오버라이드해서 자신(=Drink 클래스)의 속성값(=변수 값)들을 출력하는 함수
		return name + ":\t" + price + "\t잔여갯수:" + count + "\t";	//로 바꿨다.
	}
	
	void disCount() {								// 음료가 팔리면 그 때마다 자신의 수량을 하나씩 빼는 역할이다.
		count--;
	}
}

class Carbonated extends Drink { // 탄산음료			// 구조를 일단 확인하자 제일 위에 Product >> Drink >> Carbonated 순으로 상속이 내려오고있다.
	public Carbonated(String name, int price, int count) { 
		super(name, price, count);					// 여기서 중요, 부모의 생성자의 파라미터값에 자신이 입력받은 파라미터의 똑같은 값을 그대로 넣어
													// 부모를 먼저 생성하고, 자신을 생성한다. 
		isCostomIce = true;							// 그냥 옵션값의 유무이다. 이 중 true라는 뜻은, 사용자가 탄산을 선택할 경우, 탄산옵션을 선택
													// 선택 할 수 있다는 뜻이다. 
		isCostomPearl = false;
		isCostomWater = false;
	}
	
}

class Tea extends Drink { // 차 종류					// 이하 생략 하겠다 위의 탄산 클래스와 구조가 같다. 
	public Tea(String name, int price, int count) {		
		super(name, price, count);
		isCostomIce = true;
		isCostomPearl = true;
		isCostomWater = true;
	}
	
}

class Coffee extends Drink { // 커피
	public Coffee(String name, int price, int count) {
		super(name, price, count);
		isCostomIce = true;
		isCostomPearl = true;
		isCostomWater = true;
	}
	
}
