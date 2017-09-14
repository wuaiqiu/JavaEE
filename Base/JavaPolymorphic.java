package Base;

/*
 *多态
 *	a.多态就是同一个接口，使用不同的实例而执行不同操作
 *	b.消除类型之间的耦合关系
 *
 *多态存在的三个必要条件
 *	a.继承
 *	b.重写
 *	c.父类引用指向子类对象 ;Parent p = new Child();
 *
 *流程
 *	当使用多态方式调用方法时，首先检查父类中是否有该方法，如果没有，则编译错误；
 *如果有，再去调用子类的同名方法。
 *
 * */

public class JavaPolymorphic {
			
		public static void main(String args[]) {
			Parent p=new Child();
			p.run();
			//p.work();报错

		}
}


abstract class Parent{
	abstract public void run();
} 

class Child extends Parent{
	public void run() {
		System.out.println("this is child run");
	}
	public void work() {
		System.out.println("this is child work");
	}
}
