package day13;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Test;

/*
 *反射
 *	 JAVA反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；
 *对于任意一个对象，都能够调用它的任意方法和属性； 利用反射可以模拟动态语言的特性：在运行
 *时检查语法错误
 * */

public class JavaReflect {

	@Test
	public void reflect() throws Exception {
		
		/*
		 * 获取Class对象
		 * 		Class c1 = Class.forName("Base.Box");	//利用Class静态方法
		 * 		Class c2 = Box.class	//利用类属性
		 * 		Class c3 =	new Box().getClass();  //利用Object类中的方法
		 * */
			
		Class c=Class.forName("Base.Box");
			
			
		
		
		/*
		 * 获取Box无参构造的实例对象
		 * 	Object o = c1.newInstance();
		 * */
		
		
		
		
		/*
		 *  获得构造函数的方法 
		 *	Constructor getConstructor(Class[] params)//根据指定参数获得public构造器
		 *	Constructor[] getConstructors()//获得public的所有构造器
		 *	Constructor getDeclaredConstructor(Class[] params)//根据指定参数获得public和非public的构造器
		 *	Constructor[] getDeclaredConstructors()//获得public和非public的构造器
		 * */
			Class[] cls= {String.class};
			Constructor cons=c.getConstructor(cls);
			System.out.println(cons.getName());
		
		
		
		
		/*
		 *  获得类方法的方法 
		 *	Method getMethod(String name, Class[] params),根据方法名，参数类型获得方法
		 *	Method[] getMethods()//获得所有的public方法
		 *	Method getDeclaredMethod(String name, Class[] params)//根据方法名和参数类型，获得public和非public的方法
		 *	Method[] getDeclaredMethods()//获得所以的public和非public方法 
		 * */

		Method meths=c.getDeclaredMethod("fun1",cls);
		System.out.println(meths.getName());
		
		/*
		 *  获得类中属性的方法 
		 *	Field getField(String name)//根据变量名得到相应的public变量
		 *	Field[] getFields()//获得类中所以public的方法
		 *	Field getDeclaredField(String name)//根据方法名获得public和非public变量
		 *	Field[] getDeclaredFields()//获得类中所有的public和非public方法 
		 * */

			
	}
}


class Box{
	
	public int a;

	public Box() {}
	
	public Box(String x) {}
	
	private void fun1(String y) {
		System.out.println("this is fun1");
	} 
}