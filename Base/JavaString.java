package Base;

import org.junit.Test;

/*
 * String 和 StringBuffer 和 StringBuilder
 *   a.String类是不可变类，任何对String的改变都 会引发新的String对象的生成
 *   b.StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象。
 *   c.StringBuffer线性安全的，适合多线程中使用
 *   d.StringBuilder线程不安全，但速度快
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
