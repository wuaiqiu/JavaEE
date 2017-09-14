package Base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.Test;

/*
 *反射
 *	 反射机制指的是程序在运行时能够获取自身的信息。在java中，只要给定
 *类的名字， 那么就可以通过反射机制来获得类的所有信息。 
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