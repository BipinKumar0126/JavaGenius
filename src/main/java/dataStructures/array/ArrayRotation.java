package dataStructures.array;

import java.util.Arrays;
import dataStructures.utils.Util;


public class ArrayRotation {
 
    // Driver program to test above functions
    public static void main(String[] args) 
    {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};

		int[] arrCopy;
        
       	arrCopy = Arrays.copyOf(arr, arr.length);
        leftRotateByTempArray(arrCopy, 2);
        Util.printArray(arrCopy, 0, arrCopy.length-1);

        arrCopy = Arrays.copyOf(arr, arr.length);
        leftRotateOneByOne(arrCopy, 2);
		Util.printArray(arrCopy, 0, arrCopy.length-1);

        arrCopy = Arrays.copyOf(arr, arr.length);
        leftRotateByJuggling(arrCopy, 2);
		Util.printArray(arrCopy, 0, arrCopy.length-1);

        arrCopy = Arrays.copyOf(arr, arr.length);
        leftRotateByReversal(arrCopy, 2);
		Util.printArray(arrCopy, 0, arrCopy.length-1);

        arrCopy = Arrays.copyOf(arr, arr.length);
        leftRotateByShifting(arrCopy, 2);
    }
    
    /*
     * Time complexity O(n)
     * Auxiliary Space: O(1)
    */
    
	private static void leftRotateByReversal(int[] arr, int d) {
		int n = arr.length;
		
		Util.reverseArray(arr, 0, d - 1);
		Util.reverseArray(arr, d, n - 1);
		Util.reverseArray(arr, 0, n - 1);
	}

	/*
	 * Time complexity O(n)
	 * Auxiliary Space: O(1)
	*/
	
	private static void leftRotateByJuggling(int[] arr, int d) {
		int n = arr.length;
		int gcd = Util.gcd(n, d);
		
		for(int i = 0; i < gcd; i++) {
			int tmp = arr[i];
			int j = i;
			while(true) {
				int k = j + d;
                if (k >= n) 
                    k = k - n;
                if (k == i) 
                    break;
                arr[j] = arr[k];
				j = k;
			}
			arr[j] = tmp;
		}		
	}
	
	
	/*
	 * Time complexity O(n*d)
	 * Auxiliary Space: O(1)
	*/
	private static void leftRotateOneByOne(int[] arr, int d) {
		int n = arr.length;
		for(int i = 0; i < d; i++) {
			int tmp = arr[0];
			for(int j = 0; j + 1 < n; j++) {
				arr[j] = arr[j + 1];
			}
			arr[n - 1] = tmp;
		}
	}

	/*
	 * Time complexity O(n)
	 * Auxiliary Space: O(d)
	*/
	private static void leftRotateByTempArray(int[] arr, int d) {
		int n = arr.length;
		int[] tmp = new int[d];
		for(int i = 0; i < d; i++) {
			tmp[i] = arr[i];
		}
		
		for(int i = 0; i + d < n; i++) {
			arr[i] = arr[i + d];
		}
		
		for(int i = 0; i < d; i++) {
			arr[n - d + i] = tmp[i];
		}	
	}
	
	/*
	 * Time complexity O(n)
	 * Auxiliary Space: O(d)
	*/
	
	private static void leftRotateByShifting(int[] arr, int d) {
		int[] result = new int[arr.length];

		//right rotate
		for(int i = 0; i < arr.length; i++){
			result[(i+d) % arr.length] = arr[i];
		}
		//Left rotate
//		for(int i = 0; i < arr.length; i++){
//			result[(i+(arr.length-d)) % arr.length] = arr[i];
//		}

		Util.printArray(result, 0, result.length-1);
	}
}
