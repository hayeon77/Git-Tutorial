/*
public class Ex07_1 {

	public static void main(String[] args) {
		class Triangle {
		   int bottom;
		    int height;
		    
		    public Triangle(int bot, int hei) {
		        bottom = bot;
		        height = hei;
		    }
		      
		    public void InfoBottom(int bot) {
		        bottom = bot;
		    }
		    
		    public void InfoHeight(int hei) {
		        height = hei;
		    }
		    
		    public double ff() {
		        return bottom * height / 2;
		    }
		}
	
		class Triangle1 {
		    public static void main(String[] args) {
		        Triangle1 tr = new Triangle1(15, 3);
		        System.out.println("»ï°¢ÇüÀÇ ³ÐÀÌ: " + tr.ff());
		        
		        tr.InfoBottom(12);
		        tr.InfoHeight(3);
		        System.out.println("»ï°¢ÇüÀÇ ³ÐÀÌ: " + tr.ff());	
		    }
		}


	}

}
*/


public class Ex07_1 {

		class Point { 
		    int xPos, yPos;

		    public Point(int x, int y) {
		        xPos = x;
		        xPos = y;
		    }

		    public void Info() { 
		        System.out.println("[" + xPos + ", " + yPos + "]"); 
		    }
		}

		class Circle
		{
		    int rad;	
		    Point center;  
		    
		    public Circle(int x, int y, int r) {
		        center = new Point(x, y);
		        rad = r;
		    }
		    
		    public void Info() {
		        System.out.println("¹ÝÁö¸§: " + rad);
		        center.Info();
		    }
		}
	}
		
		
		class Round {
		    public Round(int i, int j, int k) {
				// TODO Auto-generated constructor stub
			}

			public static void main(String[] args) {
		
		        Round r = new Round(3, 2, 6);

		
		        r.Info();
		    }

			private void Info() {
				// TODO Auto-generated method stub
				
			}
		}


		