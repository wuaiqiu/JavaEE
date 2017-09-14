package Base;

/*
 *方法
 *		a. main方法的args[]即是命令行参数列表
 *
 *重载
 *		a.被重载的方法必须改变参数列表(参数个数或类型或顺序不一样)
 *		b.被重载的方法可以改变返回类型；
 *		c.被重载的方法可以改变访问修饰符；
 *		d.被重载的方法可以声明新的或更广的检查异常；
 *		e.方法能够在同一个类中或者在一个子类中被重载。
 *		f.无法以返回值类型作为重载函数的区分标准。	
 * */

public class JavaMethod {

	//可变参数
	public void fun1(int...var) {
		System.out.println(var.length);
	}
	
	
}
