package Base;
/*
 * 基本数据类型
 * 	byte(8)	short(16)	int(32)	  long(64)	float(32)	double(64)
 * 	boolean	char(16)
 * 	a.char字符需要单引号
 * 	b.前缀0表示8进制，而前缀0x代表16进制	
 * 	c.long类型需要在字面量后面加'L'，float类型需要在字面量后面加'f'
 * 	d.byte short int long默认值为0，float double默认值为0.0，boolean默认值为false，char默认值为Unicode码0
 * 	e.基本数据类型在全局时才有默认值
 * 
 * 引用类型
 * 	a.对象、数组都是引用数据类型。
 *  	b.所有引用类型的默认值都是null。
 *  	c.引用类型在全局时才有默认值
 *  
 * 自动类型转换
 * 		a.不能对boolean类型进行类型转换。
 * 		b.不能把对象类型转换成不相关类的对象。
 * 		c.在把容量大的类型转换为容量小的类型时必须使用强制类型转换。
 * 		d.浮点数到整数的转换是通过舍弃小数得到，而不是四舍五入。
 *  
 * */

public class JavaDataType {
	static char d;
	
	public static void main(String[] args) {
		
		char a='d';
		long b=12L;
		float c=2.2f;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println((int)d);
		System.out.println("---");
		
		
	}

}
