
public class Ex06_3 {

	public static void main(String[] args) {
		//number(100);

		        System.out.println("2ÀÇ 5½Â : " + ww(5));
		        System.out.println("2ÀÇ 7½Â : " + ww(7));
		    }
		    
		    public static int ww(int i) {
		        if(i == 0)
		            return 1;
		        
		        return 2 *ww(i - 1);
		    }
		    
		    //2¹ø
		    
	    public static int number(int a) {
	        if(a > 0) {
	            int b = a % 2;
	            a /= 2;
	            
	           number(a);
	            System.out.print(b);
	        }
	        
	        return 0;
	    }
	}



