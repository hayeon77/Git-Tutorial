//package vending;

import java.util.Scanner;

public class VendingMachine {                              //자판기 클래
    private Drink[] drinks;	                               //Drink 타입으로 배열 선언
    private int inputMoney;		                           //사용자에게 받을 돈을 담는  변수 선언
    Scanner scanner;		                               //입력받기위한 Scanner 변수 선언

    public VendingMachine() {                              //생성 될  때 관리자로부터(처음부터) 기본 음료랑 가격 수량이 결정됨
        scanner = new Scanner(System.in);
        drinks = new Drink[] { new Carbonated("탄산", 1300, 10)  // 드링크
                , new Tea("차", 800, 20)
                , new Coffee("맥심", 500, 50) };
    }

    public void start() {                                  // 완전 처음 시작     자판기프로그램 시작

        while (true) {                                     //와일문 시작 여기서 일반모드와 관리자모드를 선택 할 수 있음.
            System.out.println("번호를 선택해주세요.");
            System.out.println("1. 자판기 사용\t2. 관리자모드 실행\t3.종료");
            int num = scanner.nextInt();                   // 사용자에게 모드 입력받음 1번 이면 자판기 사용 함수 호
            switch (num) {
                case 1:
                    startVending();
                    break;
                case 2:								       // 2번이면, 관리자모드 함수를 호출
                    adminMode();
                    break;
                case 3:
                    System.out.println("시스템을 종료합니다."); // 3번 누르면 걍 아무것도 안하고 종료
                    System.exit(0);
                    break;
                default:
                    System.out.println("다시 입력해주세요.\n");
                    return;
            }
        }
    }

    private void startVending() { // 자판기 사용 시작  // 만약 위에 While 문에서 1을 선택했다면 이 함수를 호출
        System.out.println("자판기 사용을 시작합니다~");
        while (true) {				               // While문 무한 반복 , 밑에 3가지의 함수를 계속해서 호출하고 계속 반복함.
            showDrinkPrice();
            input();
            comparison();
        }
    }

    public void showDrinkPrice() { // 메뉴 출력   // drinks 배열의 모든 값들의 속값들을 출력함 (= 음료수 정보 출력)
        for (int i = 0; i < drinks.length; i++) {
            System.out.println((i + 1) + ".\t" + drinks[i].toString());  // toString() 은 해당 클래스의 변수들의 정보를 출력해줌
        }											                // 원래 toString() 은 자신(클래스)의 주소값을 반환하는 함수이나
    }											                   	// 여기선 오버라이드해서 재활용

    private void input() {                         // 금액 투입
        System.out.println("금액을 넣어주세요.");       // 위에서 음료정보를 출력받았으니, 이제 돈을 넣을 차례임
        try {
            this.inputMoney = scanner.nextInt();   // 사용자으로 부터 돈을입력받습니다.
        }catch (Exception e) {
            System.out.println("다시 입력해주세요.\n"); // 만약 위 try구문으로부터 오류가 발생한다면 뻑나지않고 예외처리
        }
    }

    public void comparison() {              // 선택된 음료와 사용자가 입력했던 돈과 비교하는 함수
        Drink drink = choiceDrink();        // 밑에 있는 choiceDrink() 함수를 호출해서 그에 맞는 음료수 드링크 주소를 drink 변수에담음
                                            // (=스위치문에 따라 선택된 맞는 드링크 타입의 주소를 반환함)
                                            // 그에 따라 가면 선택된 드링크에 대한 정보가 있음.
        if (drink.count > 0) {              // 여기서 사용자가 자판기에 입력한 금액과 선택된 드링크의 가격정보와 비교하여 살 수 있는지 없는지
                                            // 확인하는 구간이다.
                                            // 먼저 사용자가 사고자하는 음료수의 제고가 있는지 없는지 부터 확인한 후, 잔액과 가격을 비교한다.
            if (inputMoney < drink.price) {
                System.out.println("잔액이 부족합니다.");
                showDrinkPrice();   // 잔액이 부족하면 다시 선택하라고 다시 또 showDrinkPrice() 함수를 호출함.

                comparison();
            } else {                // 잔액이 음료수 금액보다 많으면 음료수 구입을 하게됨. 최종적으로 음료가 나왔다는 메시지가 뜸
                inputMoney -= drink.price;
                drink.disCount();
                System.out.println(drink.name + "가(이) 나왔습니다. \n");
                checkChange();      // 그리고 잔돈확인을 해줌.
            }
        } else {                    // 만약 구매 하고 싶은 음료의 제고가 없을 시, 바로 여기로 와서 종료한다.
            System.out.println("품절입니다.");
        }
    }

    private Drink choiceDrink() {                   // 음료 선택(comparison 도와주는 메소드
        System.out.println("음료 번호를 선택해주세요.");   // 여기서 음료를 선택 할 수 있음. 음료는 1~3번까지 있으며,
        int num = scanner.nextInt();                // 사용자로부터 음료 선택지 번호 입력받음
        Drink drink = null;                         // 드링크타입의 드링크 변수 초기화시켜줌
        switch (num) {
            case 1:
            case 2:
            case 3:
            case 4:
                drink = drinks[num - 1];
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                System.out.println("다시 입력해주세요."); // 그 외의 것을 누르면 다시 입력해달라고 나온다.
                showDrinkPrice();                    // 다시 음료수 목록을 보여준다.
                comparison();                        // 사용자로 부터 선택받은 음료수의 재고가 있는지 없는지 확인하고, 있으면 다시 잔액과 비교
                                                     // 하는 함수를 호출
                break;
        }
        return drink;
    }

    private void adminMode() {                       // 관리자모드 메소드
        showDrinkPrice();                            // 일반 사용자 모드와 똑같이 일단 음료를 고르게 한다.( 넣기/빼기 를 하기위한 음료 선택)
        Drink drink = choiceDrink();                 // 선택된 음료에 맞는 주소를 drink 변수에 담는다.
        addSub(drink);                               // addSun 함수 파라미터(인자값)에 drink 주소를 넣고 호출한다.
    }

    private void addSub(Drink drink) {               // 음료 넣거나 빼는 메소드
        System.out.println("선택해주세요.");             // 솔직히 이 밑에 있는 건 주석 없어도 알아야 합니다!!!
        System.out.println("1. 넣기\t2. 빼기");
        int num = scanner.nextInt();
        if (num == 1) {
            System.out.println("몇개를 넣으겠습니까");
            num = scanner.nextInt();
            drink.count += num;
            System.out.println(drink.toString());     // 음료 추가 후, 변경된 재고량을 보여주는 역할
        } else if (num == 2) {
            System.out.println("몇개를 빼시겠습니까");
            num = scanner.nextInt();
            if (drink.count > num) {
                drink.count -= num;
            } else {
                System.out.println("갯수가 부족합니다. 다시 입력해주세요.");
                adminMode();
            }
        } else {
            System.out.println("다시 입력해주세요.");
            addSub(drink);
        }
    }

    private void checkChange() {                                        // 거스름돈, 남은돈 출력
        if (this.inputMoney < 500) {
            System.out.println("거스름돈: " + this.inputMoney + "원\n");   // 만약 잔액이 500원 보다 아래라면, 거스름돈 토해내고,
            endVending();                                               // 자판기를 종료함. 근데 설계가 잘 못 된게, 처음부터 500원
                                                                        // 이하를 넣으면 이 함수가 호출될 일이 없음. 그래서 사용자가
                                                                        // 계속 음료를 선택해달라는 화면에서 나갈 수 가 없음.
                                                                        // 숫자 외 다른 문자를
                                                                        // 누르면, 프로그램이 뻑나서 강제종료로 나올 수 있음.

        } else {
            System.out.println("남은 돈: " + this.inputMoney + "원\n");    // 만약 음료수를 뽑아 먹고도 500원 보다 많은 잔액이 남으면,
            showDrinkPrice();                                            // 계속 이 두 함수를 호출해서 (음료수 선택 - 잔액,금액 비교)
                                                                         // 이 두 과정을 반복하게 함. 결국 잔액이 500원 밑으로 내려가면
            comparison();                                                // 위의 if 문을 타게되어, 거스름 돈이 반환되는 형식임.
        }
    }





    private void endVending() { // 자판기 사용 종료
        System.out.println("자판기 사용을 종료합니다.");
        System.exit(0);                                           //자판기 사용을 중지하는 기능.
    }
}