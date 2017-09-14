package Base;


/*
 *数组
 *	a.数组可以作为函数的参数
 *	b.数组可以作为函数的返回值
 * */

public class JavaArray {
		
	public  void printArray(int[] array) {
		  for (int i = 0; i < array.length; i++) {
		    System.out.print(array[i] + " ");
		  }
	}
	
	
	public static int[] reverse(int list) {
		  int[] result = new int[list];
		 
		  for (int i = 0, j = result.length - 1; i < list; i++, j--) {
		    result[j] = i;
		  }
		  return result;
		 } 
}
