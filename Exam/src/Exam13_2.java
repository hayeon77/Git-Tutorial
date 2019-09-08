/*

public class Exam13_2 {

	public static void main(String[] args) {
	//1번
		class ArrayAdder {
		    public static void addOneDArr(int[] arr, int add) { 
		        for(int i = 0; i < arr.length; i++)
		            arr[i] += add;
		    }
		    
		    public static void addTwoDArr(int[][] arr, int add) {
		        for(int i = 0; i < arr.length; i++)
		            addOneDArr(arr[i], add);
		    }
		    
		    public static void main(String[] args) {
		        int[][] arr = {
		            {1, 2, 3, 4},
		            {5, 6, 7, 8},
		            {9, 10, 11, 12}
		        };

		        addTwoDArr(arr, 2);
		        
		        for(int i = 0; i < arr.length; i++) {
		            for(int j = 0; j < arr[i].length; j++)
		                System.out.print(arr[i][j] + " ");
		            System.out.println();
		        }
		    }
		}
		/*
		//2번
		class ShiftArray {
		    public static void shiftTwoDArr(int[][] arr) {
		        int[] lastLow = arr[arr.length - 1];

		        for(int low = arr.length - 1; low > 0; low--)
		            arr[low] = arr[low - 1];
		        
		        arr[0] = lastLow;
		    }
		    
		    public static void showTwoDArr(int[][] arr) {
		        for(int i = 0; i < arr.length; i++) {
		            for(int j = 0; j < arr[i].length; j++)
		                System.out.print(arr[i][j] + " ");

		            System.out.println();
		        }
		    }
		    
		    public static void main(String[] args) {
		        int[][] arr = {
		            {1, 2, 3},
		            {4, 5, 6},
		            {7, 8, 9}
		        };

		        System.out.println("1차 shift...");
		        shiftTwoDArr(arr);
		        showTwoDArr(arr);
		        
		        System.out.println("2차 shift...");
		        shiftTwoDArr(arr);
		        showTwoDArr(arr);

		        System.out.println("3차 shift...");
			shiftTwoDArr(arr);
			showTwoDArr(arr);
		    }
		}
	

	}

}
	*/