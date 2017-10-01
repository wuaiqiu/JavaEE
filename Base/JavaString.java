package day4;
import org.junit.Test;

/*
 * String 和 StringBuffer 和 StringBuilder
 *   a.String类是不可变类，任何对String的改变都会引发新的String对象的生成
 *   b.StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象。
 *   c.StringBuffer线性安全的，适合多线程中使用
 *   d.StringBuilder线程不安全，但速度快
 *   
 * String方法
 * 		int	length():返回此字符串的长度
 * 		char charAt(int index):返回指定索引处的 char 值。
 * 		byte[] getBytes():使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
 * 	 	boolean	equals(String str):将此字符串与其他String比较。
 * 		boolean	equalsIgnoreCase(String anotherString):将此 String 与另一个 String 比较，不考虑大小写。
 * 		String substring(int beginIndex):返回一个新的字符串，它是此字符串的一个子字符串。
 * 		String substring(int beginIndex, int endIndex):返回一个新字符串，它是此字符串的一个子字符串。
 * 		String concat(String str):将指定字符串连接到此字符串的结尾。
 * 		String replace(char oldChar, char newChar):返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。
 * 		String trim():返回字符串的副本，忽略前导空白和尾部空白。
 * 		static String valueOf(Object b):返回 Object 参数的字符串表示形式。
 * 	
 * StringBuffer方法(CharSequence为String的父接口)
 * 		StringBuffer(CharSequence seq)：构造一个字符串缓冲区，它包含与指定的 CharSequence 相同的字符
 * 		StringBuffer()：构造一个其中不带字符的字符串缓冲区，其初始容量为 16 个字符。
 * 		StringBuffer(int capacity)：构造一个不带字符，但具有指定初始容量的字符串缓冲区。
 * 		StringBuffer append(CharSequence s)：将指定的 CharSequence 追加到该序列。
 * 		int	length()：返回长度（字符数）
 * 		int	capacity()：返回当前容量。
 * 		String substring(int start, int end)：返回一个新的 String，它包含此序列当前所包含的字符子序列。
 * 		String toString():返回此序列中数据的字符串表示形式。
 * 
 * StringBuilder方法	
 * 		StringBuilder()：构造一个不带任何字符的字符串生成器，其初始容量为 16 个字符
 * 		StringBuilder(CharSequence seq)：构造一个字符串生成器，它包含与指定的 CharSequence 相同的字符
 * 		StringBuilder(int capacity)：构造一个不带任何字符的字符串生成器，其初始容量由 capacity 参数指定。
 * 		StringBuilder append(CharSequence s):向此 Appendable 追加到指定的字符序列。
 * 		int length():返回长度（字符数）。
 * 		int	capacity():返回当前容量
 * 		String	substring(int start, int end):返回一个新的 String，它包含此序列当前所包含字符的子序列。
 * 		String toString():返回此序列中数据的字符串表示形式。	
 * */


public class JavaString {

//----------------------------String-----------------------------//
		
		@Test
		 public void doStringTest() {  
			  
		        String str = new String("hello");  
		        long starttime = System.currentTimeMillis();  
		        for (int i = 0; i <  10000; i++) {  
		            str = str + "miss";  
		        }  
		        long endtime = System.currentTimeMillis();  
		        System.out.println((endtime - starttime)  
		                + " millis has costed when used String.");  
		}  
		 
//==>406 millis has costed when used String.

//--------------------------StringBuffer--------------------------//		 
		 
		 @Test
		 public void doStringBufferTest() {  
			  
		        StringBuffer sb = new StringBuffer("hello");  
		        long starttime = System.currentTimeMillis();  
		        for (int i = 0; i < 10000; i++) {  
		            sb = sb.append("miss");  
		        }  
		        long endtime = System.currentTimeMillis();  
		        System.out.println((endtime - starttime)  
		                + " millis has costed when used StringBuffer.");  
		    }  

//==>1 millis has costed when used StringBuffer.

//-----------------------------StringBuilder-------------------------//
		 
		 @Test
		 public  void doStringBuilderTest() {  
			  
		        StringBuilder sb = new StringBuilder("hello");  
		        long starttime = System.currentTimeMillis();  
		        for (int i = 0; i < 10000; i++) {  
		            sb = sb.append("miss");  
		        }  
		        long endtime = System.currentTimeMillis();  
		        System.out.println((endtime - starttime)  
		                + " millis has costed when used StringBuilder.");  
		    }  

//==>1 millis has costed when used StringBuilder.

}
