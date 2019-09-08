//package vending.sample.dj;

import java.util.Scanner;

public class VendingMachine_new {					// 자판기 클래스 입니다. 
	private final String ADMIN_ID = "1";           	// 관리자 로그인 기능을 위해 있습니다. 파이널상수로 정해져있습니다.
	private final String ADMIN_PASSWORD = "1";

	private int inputMoney;							// 사용자가 투입 할 돈을 담는 변수입니다. 
	private Scanner scanner;     					// 스캐너를 쓰기 위해 스캐너타입의 변수를 선언했습니다.
	private int total;								// 총매출액을 담기 위한 변수선언입니다.
	private boolean isAdmin;						// 관리자인지 아닌지 파악하기 위한 변수선
	private Drink choice;							// 드링크 타입의 변수선언, 사용자가 음료를 고르면 여기에 그 주소값이 저
	private Option option;							// 옵션타입의 옵션변수 선언, 옵션 선택시 여기에 그 데이터를 저장하고 주소를
													// 담게됩니다. 

	private Drink[] drinks;							// 드립크 타입의 배열 선언. 
	private Option[] options;						// 옵션 타입의 옵션 선언.

	public VendingMachine_new() { // 기본 음료 셋팅
		scanner = new Scanner(System.in);           // 스캐너사용을 위한 스캐너 객체생
		drinks = new Drink[] { new Carbonated("탄산", 1300, 10), new Tea("차", 800, 20), new Coffee("커피", 500, 50) };
		options = new Option[] { new Water(100), new Ice(100), new Pearl(50) };
	}												// 음료수들이랑 옵션들을 자판기가 생성됨과 동시에 채워넣습니다. 

	public void start() { //초기화면					
		while (true) {
			System.out.println("번호를 선택해주세요.");	
			System.out.println("1. 자판기 사용\t2. 관리자 모드\t3.종료");
			System.out.print(">> ");
			int num = scanner.nextInt();			// 여기서 관리자모드와 일반사용자모드를 번호로 입력받습니다.
			switch (num) {							
			case 1:
				startVending();						// 1번일 경우 일반 사용자 모드이며, 바로 이 함수를 호출합니다.
				break;
			case 2:
				adminMode();						// 2번일 경우 관리자 모드 사용이며, 바로 이 함수를 호출합니다.
				break;
			case 3:
				endVending();						// 3번일 경우 종료하겠다는 뜻이며, 바로 프로그램을 종료하는 함수를 호출합니다.
				break;
			default:
				System.out.println("다시 입력해주세요."); //그 외 버튼을 입력하면 다시 입력해달라는 메시지가 출력됩니다.
				return;
			}
		}
	}

	private void startVending() { // 자판기 사용 시작
		System.out.println("*****자판기 사용을 시작합니다.*****\n");
		while (true) {
			showMenu();									// 음료수 메뉴를 보여주는 함수를 호출합니다. 주석을 읽고있는 당신도showMenu()로 가서
														// 그 함수를 이해하고 다시 여기로 와서 읽어주길 바란다.
			choice = choiceMenu();						// choiceMenu() 호출하면서 작동시키고 그 리턴값을 choice에 넣는다.
														// choiceMenu() 로 가서 이해하고 다시 여기로 오세요.
			
			if (choice == null) {						// 만약 choice에 주소가담겨있지 않다면 ??? 어떤 경우에 이런 일이 발생할까? 
				
				System.out.println("다시 선택해 주세요.");	// 지금 choiceMenu() 함수를 보고 왔다면, 이 메시지는 사용자가 선택한 음료수가 
				continue;								// 다 팔려서 품절일 때 나오는 메시지라는걸 이해해야한다. 
														// 자판기를 돌려봐도 "다시선택해주세요"라는 메시지는 보기 힘들었을 것이다. 
														// 이유는 해당 음료가 품절되어야 보이는 메시지이기 때문이다. 
			}										   
			String option = choiceOptions(choice);      // choiceOption() 으로 가서 프로그램이 진행되고 끝나면 다시 여기로 온다. 
													    // 다시 거기로 가세요
			
														// 여기서 리턴값은 사용자에게 옵션의 양 (적게,보통,많게) 를 보여주는 것 외엔	
														// 큰 의미있는 기능이 있지않다.... 
														
														
			
														// 진짜 의미있는 함수는 이 checkChoiceMenu() 함수이다. 
														// 그리고 다시 checkChoiceMenu() 로 가서 이해하고 다시 여기로 오세요.
			
			switch (checkChoiceMenu(option)) {			// 여기서 만약 1을 리턴 받았다면, 스위치문에 의해 1번 경로를 타고(주문완료)
			case 1:
				input();								// 주문완료 했으므로, 사용자에게 돈을 요구한다. 
				start();								// 위 input() 함수를 무난히 통과했다면, 다시 주문을 하기 위해 start() 함수 호
				break;
			case 2:										// 2번 , 주문취소를 리턴 받았다면, continue 문이 이어지므로, while문 처음으로 다시
														// 가서 다시 음료메뉴 보여주고..다시 고르게 하고..뭐 다시 반복되는거다.
				continue;
			case 3:
				System.out.println("초기화면으로 이동합니다."); // 3번을 리턴 받았다면, 초기화면으로 바로 간다. 초기화면으로 가려면 
				start();								  // 이 함수를 호출하면 된다. 

			default:                                   // 만약 사용자가 주문표까지 받을 상태에서 주문완료도 아니고 주문취소도 아니고 초기화면이동 
				System.out.println("잘못된 입력입니다. 메뉴선택화면으로 이동합니다.");  //도 아닌 다른 숫자를 눌렀다면 이곳으로 빠지게된다. 
				continue;								// 결국 다시 while문 처음으로 돌아가서 음료메뉴를 보게된다..
			}

		}
	}

	private void showMenu() { // 메뉴 출력      		// 드링크 배열에 음료수 종류별로 저장되어있다. 그걸 여기서 출력해서 보여준
		System.out.println("[메뉴 선택]\n");			// 메뉴선택을 하라고 출력해주고,
		int index = 1;
		for (int i = 0; i < drinks.length; i++) {	// 여기서 포문으로 돌며서 저장된 음료수 정보들을 출력해준다.
			System.out.println(index + ".\t" + drinks[i].toString());
			index++;
		}

		if (isAdmin) {								// 만약 사용자가 일반사용자가아니라 관리자를 통해서 들어온거라면 
													// 다음과 같이 음료와 옵션(재료들)들의 재고까지 보여준다. 
			for (int i = 0; i < options.length; i++) {
				System.out.println(index + ".\t" + options[i].toString());
				index++;							// 메뉴 출력 될 때 그냥 앞에 있는 숫자, 신경안서도 됨.
			}
		}
	}

	private void input() { // 금액 투입                 //사용자로부터 돈을 입력받는 함
		System.out.println("금액을 넣어주세요.");
		System.out.print(">> ");

		while (true) {
			inputMoney = scanner.nextInt();    		  //사용자로부터 돈을 받는다. 

			if (inputMoney < choice.price) {		  //입력 받은 돈이 사용자가 고른 음료수가격보다 낮으면, 
				inputMoney = 0;						  //사용자로부터 받은  돈을  0 으로 고치고( 어차피 못 사니깐 사용자에게 돈 다시 준거)
				System.out.println("다시 넣어주세요.");	  //다시 넣어달라고 요청 
				System.out.print(">> ");
				continue;							  //음료 가격에 맞는 금액이 투입 될 때까지 무한 반복.
			} else {
				total += choice.price;   			  //음료를 살 수 있는 금액이 들어오면, 매출총액에 합산시킴.
				choice.disCount();					  //quiz : 여기서 choice는 어떤 타입인가?
				System.out.println(choice.name + "가(이) 나왔습니다.");
				System.out.println("거스름 돈 : " + checkChange(inputMoney, choice.price)+"\n");
				
				break;
			}
		}
	}

	private Drink choiceMenu() { //고른 음료 확인
		Drink drink = (Drink) choiceDrink();    // 다시 choiceDrink()를 호출하면서 그 타입을 Drink로 다운캐스 시키고 drink변수에 
		if (drink.count == 0) {					// 담는다.
												// 여기서 왜 다운캐스팅 했는지 이해를 해야한다. 
												// choiceDrink() 로 부터 처리되어 반환되는 타입은 Product타입이다.  
												// 근데 부모타입을 계속 쓰면 자식 자원에 접근 할 수 없을 뿐더러, 부모타입을 자식타입인
											    // Drink타입에 넣을 수가 없다. 따라서, 부모타입을 자식타입으로 다운캐스팅해야한다.
												
			
			
			
												// 위의 choiceMenu() 함수를 거치고 오면, drink 변수에 사용자가 선택한 음료의 배열방 주소값
			drink = null;						// 저장된다. 따라서 여기 if문에서 해당 음료의 count값에 접근해서 0이면 수량이 없기때문에
												// 여기서 품절입니다 메시지를 보여주는 것이고, 만약 수량이 있다면
			System.out.println("품절입니다.");
		}

		return drink;        					// choiceDrink() 함수에 의해 반환된 drink 타입의 주소를 반환한다. 
												// 즉 이 코드만 보면 아직 뭐가 반환될지모른다. 지금 당장  choiceDrink()로 가서 그 결과를 봐야지
	}											// 어떤 음료가 반환되는지 알 수 있다. 
	
	//음료 선택 과정에있어 호출 순서는 shwMenu() >> choiceMenu() >> choiceDrink() 순으로 호출하고 있으며, 
	//프로그램의 내용 흐름 순서대로 볼려면 위와는 반대로 choiceDrink() >> choiceMenu() 순으로 생각해야 한다. 
	
	private Product choiceDrink() { 			  	// 여기가 진짜 음료선택과정 시작.
		System.out.println("음료 번호를 선택해주세요.");	// 
		Product pick = null;						// Product 타입의 pick 변수를 우선  초기화시킨다.
		int num = 0;								// num 초기화 
		boolean isChoice = false;					// isChoice 초기화 
		do {
			System.out.print(">> ");
			isChoice = false;
			num = scanner.nextInt();                // 사용자가 고른 음료(1번~3번)를 여기다저장 
			if (num > 0 && num < 4)					// 사용자가 1~3번 중 메뉴 고른거 드링크배열에서 
				pick = drinks[num - 1];				// 여기서 -1을 하는 이유는 배열의 인덱스값은 0부터 시작하기 때문이다. 
													// 예를 들어 사용자가 1번 음료(탄산)를 선택 했다면, 배열방 1-1 = 0번 방,  drink[0]방에 가야
													// 그 방 안에 탄산 객체 주소가 담겨있다. 
			else if (isAdmin && (num > 3 && num < 7))	//  이 부분은 만약 지금 사용자가 관리자일 경우에 해당되는 내용이다. 4,5,6 번 옵션을 
				pick = options[num - 4];				//  여기서 -4를 한 이유는, 옵션의 배열방이 0부터 시작하는데 여기 메뉴에서는
														//  4부터 시작하기 때문이다. 
			else {
				System.out.println("선택 오류 입니다. 다시 입력해주세요."); // 일반사용자가 1번~3번 외 숫자를 입력할 시 여기로 온다.
																	// 관리자가 1번~6번 외 숫자를 입력할 시 여기로 온다. 
				isChoice = true;								    // isChoice 가 true면 계속 while문
			}														// 을 탈출 하지 못함.
		} while (isChoice);

		return pick;                                                // 선택된 옵션 혹은 드링크를 프로덕트타입의 주소로 반환한다. 
																	// 여기서 옵션타입의 주소값 이든 드링크타입의 주소값 이든 둘 다 반환 받기위해 
																	// 추상화 클래스인 Product클래스를 만든것이다. 
	}																// 그게 가능한 이유는 부모타입은 자식들 모든 타입들을 다 받아먹기때문이다.

	private String choiceOptions(Drink drink) { //옵션 추가
		int input = 0;											    // 초기화 및 여기서(이 함수에서만) 쓸 지역변수 생성 
		String result = "";											// 위와 같음 필요에 의해 여기서 한 번 썼다가 이 함수가 끝나면 사라짐 

		System.out.println("\n[옵션 설정]\n");							// 사용자가 음료 선택 후, 여기서 옵션을 선택 한다. 
		
		if (drink.isCostomIce) {									// 만약 지금 사용자가 선택한 drink 주소값안의 isCostomIce 변수 값에 
																	// True 가 있다면, 그건 얼음을  선택 할 수 있는 음료를 골랐다는 뜻임.
																	// 따라서 여기 if 문에 걸려서 다음과 같은 옵션 설정 과정을 거치게됨.
			
			option=options[0];										// 현재 얼음이므로, 얼음 방에 가야한다. 얼음은 Option[0]에 
																	// 저장되어있다. 이런 방 번호는 자판기를 생성 할 때 이미 다 정했었다. 								
																	
			System.out.println("얼음 양 설정");						
			System.out.println("1.적게\t2.보통\t3.많게");               
			System.out.print(">> ");
			input = scanner.nextInt();
			if (input == 1) {
				result += "얼음 양 : 적게\n";
				option.disOptionCount(1);
			}
			else if (input == 2) {
				result += "얼음 양 : 보통 \n";
				option.disOptionCount(2);
			}
			else if (input == 3) {
				result += "얼음 양 : 많게\n";
				option.disOptionCount(3);
			}
		}
		if (drink.isCostomWater) {                                 // 위에 얼음과 같은 구조이므로 설명 생
			option=options[1];
			System.out.println("물 양 설정");
			System.out.println("1.적게\t2.보통\t3.많게");
			System.out.print(">> ");
			input = scanner.nextInt();
			if (input == 1) {
				result += "얼음 양 : 적게\n";
				option.disOptionCount(1);						   // 적게를 선택하면 1만차감된다. 
			}
			else if (input == 2) {
				result += "얼음 양 : 보통 \n";						   // 사용자가 보통을 선택했다면, 2를 뺀다. 
				option.disOptionCount(2);
			}
			else if (input == 3) {
				result += "얼음 양 : 많게\n";						   // 이하 생략...
				option.disOptionCount(3);
			}
		}
		if (drink.isCostomPearl) {								
			option=options[2];
			System.out.println("펄 추가 (+500원)");
			System.out.println("1.예\t2.아니오");
			System.out.print(">> ");
			input = scanner.nextInt();
			if (input == 1) {
				result += "펄 추가\n";
				drink.price += 500;
				option.disOptionCount(1);
			}
		}

		return result;											   // quiz :  여기서 반환되는 result의 타입과 그 내용을 설명하시오. 
	}															   

	private int checkChoiceMenu(String option) { //주문표 출력        // 하...여기가 또 한 번의 고비...
																   // 우선 이 함수의 리턴 타입이 int 라는 걸 계속 말하면서 생각하자.
		System.out.println("---------주 문 표---------");			   // 보면 알겠지만, 사용자가 음료랑 옵션까지 선택하면 이 주문표가 출력된다.
		System.out.printf("선 택 음료 : %s\n", choice.name);		   // 현재 사용자가 그 상태라는 것도 잘 기억하자. 		
		System.out.println(option);								   // 이건 걍 사용자가 선택한 옵션양을 출력하는 부분 (적게, 보통, 많게)
		System.out.println("금액 : " + choice.price);				   // 생략 		
		System.out.println("------------------------");			   // 생략 

		System.out.println("1. 주문\t2. 주문취소\t 3. 초기화면");        // 중요 사용자가 최종 선택을 하는 구간이다. 1을 누르면 진짜 주문완료가된다는점
																   // 지금 그 순간이라는 걸 기억하자.
		System.out.print(">> ");
		return scanner.nextInt();								   // 여기가 중요하다 이 함수의 리턴타입은 인트다. 
																   // 근데 갑자기 사용자로부터 숫자를 입력받을려고한다.
																   // 여기에서 사용자가 1을 누르면 그 1번을 입력받고 1을 다시 리턴시키는거다.
																   // 여기서 1번이 바로 "주문완료"이다.  2번을 눌렀다면 여기서 2을 입력받고		
																   // 2을 리턴하는 것이다. 이제 다시 위로 올려서 startVending() 으로 가면
																   // 아마 1을 리턴 받았으면 그에 따른 주문완료 절차가 있을것이고,
																   // 아마 2을 리턴 받았으면 그에 따른 주문취소 절차가 이어질 것이라는걸	
																   // 지금 여기서 추측할 수 있어야 한다.

	}

	private void adminMode() { // 관리자모드 메소드   					// 여기서 부턴 알아서 ~~ 하세요 여기까지왔다면 이 이상은 다 이해 가능합니다.
		adminLogin();
		while (isAdmin) {
			System.out.println("───────────────관리자 메뉴───────────────");
			System.out.println("│1. 물품 관리\t\t2. 매출 확인\t\t 3.로그아웃  │");
			System.out.println("────────────────────────────────────");
			System.out.print(">> ");
			int num = scanner.nextInt();
			switch (num) {
			case 1:
				showMenu();
				Product drink = choiceDrink();
				addSub(drink);
				break;
			case 2:
				showTotal();
				break;
			case 3:
				adminLogout();
				break;
			default:
				System.out.println("다시 입력해주세요.");
				return;
			}
		}
	}

	private void adminLogin() { //관리자모드 로그인
		String id = "";
		String password = "";
		boolean isLogin = false;
		do {
			System.out.println("************관리자 로그인************");
			System.out.print("Id : ");
			id = scanner.next();
			System.out.print("Password : ");
			password = scanner.next();
			isLogin = id.equals(ADMIN_ID) && password.equals(ADMIN_PASSWORD);
			isAdmin = isLogin;
			System.out.println(isLogin ? "로그인 성공!" : "로그인 실패!");
		} while (!isLogin);

	}

	private void adminLogout() { //관리자모드 로그아웃
		isAdmin = false;
	}

	private void showTotal() { //매출 출력하는 관리자 전용 메소드
		System.out.println("매출 현황 : " + total + "원");
	}

	private void addSub(Product drink) { // 음료,옵션 넣거나 빼는 관리자 전용 메소드
		System.out.println("선택해주세요.");
		System.out.println("1. 넣기\t2. 빼기");
		System.out.print(">> ");
		int num = scanner.nextInt();
		if (num == 1) {
			System.out.println("몇개를 넣으겠습니까");
			System.out.print(">> ");
			num = scanner.nextInt();
			drink.count += num;
			System.out.println(drink.toString());
		} else if (num == 2) {
			System.out.println("몇개를 빼시겠습니까");
			System.out.print(">> ");
			num = scanner.nextInt();
			if (drink.count > num) {
				drink.count -= num;
			} else {
				System.out.println("갯수가 부족합니다. 다시 입력해주세요.");
				addSub(drink);
			}
		} else {
			System.out.println("다시 입력해주세요.");
			addSub(drink);
		}
	}

	private int checkChange(int inputMoney, int price) {    // 거스름돈, 남은돈 출력
		return inputMoney - price;							// 사용자가 투입한 돈에 해당 음료 가격만큼 차감되어 반환한다. 
	}

	private void endVending() { // 자판기 사용 종료
		System.out.println("자판기 사용을 종료합니다.");
		System.exit(0);
	}
}