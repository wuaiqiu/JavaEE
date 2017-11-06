package Base;

/*
 *装箱
 *	 当基本数据类型被当作对象使用的时候，编译器会把内置类型装箱为包装类
 *
 *拆箱
 *	 当一个对象被当作基本数据类型使用的时候，编译器会把对象拆箱为基本数据类型
 *
 *包装类（int => Integer、long => Long、byte => Byte、double => Double、
 *	float => Float、short => Short、BigDecimal、BigInteger）都是抽象类 Number 的子类。
 *
 *Character 类在对象中包装一个基本类型 char 的值
 *
 * */

public class JavaNumber {
		
		Integer a=10;//自动装箱
		int b=a+1;	//自动拆箱

}
