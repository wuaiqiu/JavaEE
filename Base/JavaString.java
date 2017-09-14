package Base;

import org.junit.Test;

/*
 * StringBuffer 和 StringBuilder
 * 		a.StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象。
 * 		b.StringBuilder线程不安全，但速度快，推荐使用StringBuffer
 * */


public class JavaString {
			@Test
			public void fun1() {
				StringBuilder str=new StringBuilder();
				str.append("www.");
				str.append("baidu.com");
				System.out.println(str.toString());
				
			}
}
