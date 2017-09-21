
//-------------------------------继承--------------------------------//

/*
 * 继承
 * 		1.子类拥有父类非private的属性，方法
 * 		2.子类可以拥有自己的属性和方法，即子类可以对父类进行扩展。
 * 		3.子类可以用自己的方式实现父类的方法。
 * 		4.Java的继承是单继承，但是可以多重继承
 * 		5.提高了类之间的耦合性(继承的缺点，耦合度高就会造成代码之间的联系)
 * 
 * super 与 this 关键字
 *		1.super关键字：我们可以通过super关键字来实现对父类成员的访问，用来引用当前
 *					  对象的父类。
 *		2.this关键字：指向自己的引用。
 *
 *构造器
 *		1.子类不能继承父类的构造器,既不能重写
 *		2.父类的构造器带有参数的，则必须在子类的构造器中显式地通过super关键字调用父类
 *		的构造器并配以适当的参数列表。
 *		3.如果没有使用super关键字，系统会自动调用父类的无参构造器。
 *
 *
 * */

class Person{
	private void fun() {
		System.out.println("this is Person->fun");
	}
}

class Human extends Person{
	public void fun() {
		System.out.println("this is Human->Person");
	}
	
}


//-------------------------------------------多态--------------------------------------//


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



//--------------------------------------封装-------------------------------------------//
/*
 * 封装
 * 	 1.封装可以被认为是一个保护屏障，防止该类的代码和数据被外部类定义的代码随机访问。
 * 	 2.要访问该类的代码和数据，必须通过严格的接口控制。
 *	 3.封装最主要的功能在于我们能修改自己的实现代码，而不用修改那些调用我们代码的程序片段。
 * */
public class JavaEncapsulation {
		
	public static void main(String[] args) {
		Encap p=new Encap();
		p.getFun();
		System.out.println(p.getName());
	}
		
}


class Encap{

	//封装方法，隐藏实现细节
	private void fun(){
		System.out.println("this is fun");
	}
	
	//封装属性
	private String name="zhangsan";
	
	//提供访问接口
	public void getFun() {
		fun();
	}
	
	//提供访问接口
	public String getName() {
		return this.name;
	}
}


