package Base;


/*
 *数组定义
 *	a.声明数组  int[] arr 或 int arr[]
 *	b.数组赋值   int[] arr=new int[4] 或 int[] arr={1,2,3}
 *	c.数组遍历 for(int p:arr){}
 *	d.多维数组 int[][] arr=new int[4][5];
 *	e.数组可以作为函数的参数
 *	f.数组可以作为函数的返回值
 *
 * */

public class JavaArray {
		
	public static void main(String[] args) {
			
			//声明数组
			int[] arr1=new int[4];
			int[] arr2= {1,2,3,4};

			//foreach遍历
			for(int p:arr2) {
				System.out.println(p);
			}
	}

	//值传递，不会影响原数组
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
