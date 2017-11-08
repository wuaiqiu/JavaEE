/*
 *数组定义
 *	
 *	a.声明数组 int[] arr 或 int arr[]
 *	b.数组赋值 int[] arr=new int[4] 或 int[] arr={1,2,3}
 *	c.数组遍历 for(int p:arr){}
 *	d.多维数组 int[][] arr=new int[4][5];
 *	e.数组可以作为函数的参数
 *	f.数组可以作为函数的返回值
 *	g.Arrays方法
 *	  public static int binarySearch(Object[] a, Object key):用二分查找算法在给定数组中搜索给定值的对象(Byte,Int,double等)
 *	  public static boolean equals(long[] a, long[] a2):如果两个指定的 long 型数组彼此相等，则返回 true
 *	  public static void sort(Object[] a):对指定对象数组根据其元素的自然顺序进行升序排列	
 *	  public static void fill(int[] a, int val):用val值填充a数组
 *	h.数组复制
 *		(1).使用for循环逐个地复制数组元素
 *		(2).使用System类中的静态方法arraycopy
 *		(3).使用clone方法复制数组
 * */

public class JavaArray {	

	public static void main(String[] args) {
			int[] arr1= {3,2,7,1};
			Arrays.sort(arr1);    		//{1,2,3,7}
			int[] arr2=new int[4];
			Arrays.fill(arr2, 1);		//{1,1,1,1}
	}
	
	public int[] function(int[] arr) {
			return null;
	}
	
	@Test
	public void copy() {
		int[] arr= {1,2,3,4};
		
		int[] arr1=new int[4];
		for(int i=0;i<4;i++) {
			arr1[i]=arr[i];
		}
		
		int[] arr2=new int[4];
		System.arraycopy(arr, 0, arr2, 0, 4);
		
		int[] arr3=arr.clone();
	}
	
}