import kr.or.bit.Emp;

/* import kr.or.bit.emp;
 

public class Ex05_Array_Object {

	private static final Ex05_Array_Object ot = null;

	public static void main(String[] args) {
		//1.사원 3명을 만드세요 (단 배열을 사용해서)
		//Emp e = new Emp()
		//Emp e2 = new Emp() (x)
		
		emp[] emplist = new emp[3]; //방만 .... 방안에 채워 .... 별도의
		emplist[0] = new emp();
		emplist[0].setEmpno(1000);
		emplist[0].setEname("홍길동");
		
		emplist[1] = new emp();
		emplist[1].setEmpno(2000);
		emplist[1].setEname("김유신");
		
		emplist[2] = new emp();
		emplist[2].setEmpno(3000);
		emplist[2].setEname("유관순");
		
		//2. 사원 3명의 사번과 ,이름을 출력하세요
		for(int i = 0 ; i < emplist.length ; i++) {
			emplist[i].empInfoPrint();
		}
		
				//3. int[] emplist2 = new int [] {10,20,30}형식
				//사원 2명을 만드세요
          emp[] emplist2 = new emp[]{new emp(1,"이씨"), new emp(2,"박씨")};
          for(int i = 0; i < emplist2.length ; i++) {
        	  emplist2[i].empInfoPrint();
          }
          
      	//int[] emplist3 = {10,20,30} 형식
  		//사원  2명을 만드세요
      	emp[] emplist3 = {new emp(3,"김씨") , new emp(4,"홍씨")};
  		for(int i = 0 ; i < emplist3.length ; i++) {
  			emplist3[i].empInfoPrint();
  		}
          //배열에 있는 Ex05_Array_Object 마치고 나서.....
          //Array... 배열은 객체다
	int[] add(int[] param) { // param 변수가 받는 값은 무엇일까요 >
		int[] target = new int[param.length];
		for (int i = 0; i < param.length; i++) {
			target[i] = param[i] + 1;
		}
		return null;
	
	}
	
	//1 ok
	Human m = new Human(); //m은 human 객체의 주소값
	System.our.println("m의 주소값:"+m);
	ot.add(m);
	
	//2 ok
	ot.add(new Human()); //heap에서 생성된 주소 바로 전달
	
	//Array parameter로 또는 return Type 사용
	///////////////////////
	
	int[] source = {10,20,30,40,50};
	int[] target = ot.add(source);
	system.out.println(source==target);
	
	for(int value:target) {
		System.out.println(value);
	}
	
	int[]so = {10,20,30};
	int[]ta = {11,21,31};
	int[]ta2 = ot.add(so, ta);
	
	//개선된 for문 : 배열 or Collection (다중값)
	for(int value : target) {
		System.out.println(value);
	}
	for(int i =0; i < target.length;i++) {
		System.out.println(target[1]);
		
	}
	}
	
	int[] add(int[] so, int[] so2) {
		//자율코드 (에러 안나게끔 해보기)
		return null;
		
		
	int[] so = (10, 20, 30);
	int[] ta = (11, 21, 31);
	int[] ta2 = ot.add(so, ta);
	//개선된 for
	for(int value : ta2) {
		System.out.println(value);
	}
	}
	
	}
*/

public class Ex05_Array_Object {
	public static void main(String[] args) {
		//1.사원 3명을 만드세요 (단 배열을 사용해서)
		//Emp e = new Emp()
		//Emp e2 = new Emp() (x)
		
		Emp[] emplist = new Emp[3]; //방만 .... 방안에 채워 .... 별도의
		emplist[0] = new Emp();
		emplist[0].setEmpno(1000);
		emplist[0].setEname("홍길동");
		
		emplist[1] = new Emp();
		emplist[1].setEmpno(2000);
		emplist[1].setEname("김유신");
		
		emplist[2] = new Emp();
		emplist[2].setEmpno(3000);
		emplist[2].setEname("유관순");
		
		//2. 사원 3명의 사번과 ,이름을 출력하세요
		for(int i = 0 ; i < emplist.length ; i++) {
			emplist[i].empInfoPrint();
		}
		
		//int[] emplist2 = new int[] {10,20,30} 형식
		//사원 2명을 만드세요
		Emp[] emplist2 = new Emp[]{new Emp(1,"이씨"),new Emp(2,"박씨")};
		for(int i = 0 ; i < emplist2.length ; i++) {
			emplist2[i].empInfoPrint();
		}
		
		//int[] emplist3 = {10,20,30} 형식
		//사원  2명을 만드세요
		Emp[] emplist3 = {new Emp(3,"김씨") , new Emp(4,"홍씨")};
		for(int i = 0 ; i < emplist3.length ; i++) {
			emplist3[i].empInfoPrint();
		}
	}

}
