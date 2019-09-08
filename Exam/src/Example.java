
class animal{
    String name;
    int old;
    tiger t;

    animal(){
        this("틀렸어" , 4444);
    }

   public animal(String name, int old){
        this.name = name;
        this.old = old;
    }



animal Animal = new animal();




    void printInfoOne(){
        System.out.println("현재 이 동물의 이름음 : " + this.name);
        System.out.println("현재 이 동물의 나이는 : " + this.old);

    }
    void printInfoTwo(){
        System.out.println("현재 이 동물의 이름음 : " + this.name);
        System.out.println("현재 이 동물의 나이는 : " + this.old);
        System.out.println("현재 이 동물의 종은 : " + t.variety);
    }
}


class tiger extends animal{
    String variety ;

    tiger(){
        this.variety = "틀렸어 이게아니야";
    }
    tiger(String variety){
        this.variety = variety;
    }
}


class overloadingAndPrivate {
    public static void main(String[] args) {

        // 위의 클래스는 동물을 정의하는 animal 클래스와  tiger클래스가 있습니다.
        // 근데 제가 키보드가 미끄러워서 그만 코드들을 지워버리거나 엉뚱한 접근자를 쓰고 말았습니다. 찾아서 해결 해 주세요
        // 일단 코드들을 잘 보면서 역으로 원래는 어떤 모습이였을까 생각해보세요.
        // 위에 코드에 밑줄로 구분 한 부분에 적절한 작업을 해주시고, 여기 메인메소드에서 불러서 출력하세요.


        // 주의 할 점 : 위에서 밑줄로 구분 된 곳만 수정 or 작성 해 주시고, 나머지 코드는 수정하지 마시고, 잘 보고 이용하세요.

        // 최종적으로 출력이 다음과 같이 나오게 해주세요
        //-----------------------------------------------
        // 현재 이 동물의 이름은 : 박성호
        // 현재 이 동물의 나이는 : 31

        // 현재 이 동물의 이름은 : 피피
        // 현재 이 동물의 나이는 : 9
        // 현재 이 동물의 종은 : superCat
        //-----------------------------------------------

    }
}