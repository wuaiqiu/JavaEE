package day4;
/*
 *(1)基本数据类型
 * 	byte(8)	short(16) int(32) long(64) float(32) double(64)
 * 	boolean	char(16)
 * 	a.char字符需要单引号
 * 	b.前缀0表示8进制，而前缀0x代表16进制	
 * 	c.long类型需要在字面量后面加'L'，float类型需要在字面量后面加'f'
 * 	d.byte short int long默认值为0，float double默认值为0.0，boolean默认值为false，char默认值为ASCII码0
 * 	e.基本数据类型在全局时才有默认值
 * 
 *(2)引用类型
 * 	a.对象、数组都是引用数据类型。
 *  b.所有引用类型的默认值都是null。
 *  c.引用类型在全局时才有默认值
 *  
 *(3)自动类型转换
 * 	a.不能对boolean类型进行类型转换。
 * 	b.不能把对象类型转换成不相关类的对象。
 * 	c.在把容量大的类型转换为容量小的类型时必须使用强制类型转换。
 * 	d.浮点数到整数的转换是通过舍弃小数得到，而不是四舍五入。
 *  
 *(4)值传递与引用传递
 *   a.基本数据类型传值，对形参的修改不会影响实参；
 *   b.引用类型传引用，形参和实参指向同一个内存地址（同一个对象），所以对参数的修改会影响到实际的对象；
 *   c.String, Integer, Double等immutable的类型特殊处理，可以理解为传值，最后的操作不会修改实参对象。
 *   
 *(5)引用类型判断instanceof
 *	obj instanceof class :判断obj是否为class的实例
 * */

public class JavaDataType {
	static char d;
	
	public static void main(String[] args) {
		
		//基本数据类型
		char a='d';
		long b=12L;
		float c=2.2f;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println((int)d);
		
		//类型判断
		JavaDataType obj=new JavaDataType();
		System.out.println(obj instanceof JavaDataType);
		
		
		//值传递
		String str1="Hello";
		String str2=new String("Hello");
		fun(str1);//Hello
		fun(str2);//Hello
	}
	
	public static void fun(String name) {
		name="hello";
	}
}