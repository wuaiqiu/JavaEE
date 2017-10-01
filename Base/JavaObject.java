//-----------------------------------类的属性与方法-----------------------------------//

/*
 * Java中的属性
 * 		a.局部变量
 *		   1)访问修饰符不能用于局部变量
 *		   2)局部变量没有默认值，所以局部变量被声明后，必须经过初始化，才可以使用
 * 		b.成员变量
 *		   1)访问修饰符可以修饰实例变量
 *		   2)具有默认值
 * 		c.类变量（静态变量）
 *		   1)类变量也声明全局范围内，但必须声明为static类型
 *		   2)访问修饰符可以修饰静态变量
 *		   3)具有默认值
 *		   4)在其他类时，静态变量可以通过：ClassName.VariableName的方式访问
 *		   5)在本类时，静态变量可以看成全局变量使用
 *		   6)局部变量不能被声明为 static 变量
 * 		d.常量
 *		   1)使用 final 关键字来修饰常量
 *		   2)只能初始化一次且必须立即初始化 
 *
 * Java的方法
 * 		
 *		a.构造方法
 * 		  1)每个类都有构造方法。如果没有显式地为类定义构造方法，Java编译器将会为该类提供
 * 		一个默认构造方法。
 * 		  2)构造方法的名称必须与类同名，一个类可以有多个构造方法。
 *		b.成员方法
 *		c.类方法(静态方法)
 *		  1)静态方法可以直接调用静态变量与方法
 *		  2)静态方法需要进行实例化后才能调用非静态变量与方法
 *		  3)普通方法可以直接调用静态方法
 *		  4)其他类调用静态方法，使用ClassName.MethodName()
 *		d.final方法
 *		  1)final方法可以被子类继承，但是不能被子类修改
 * 
 * Java静态类：如果一个类要被声明为static的，只有一种情况，就是静态内部类
 * final 类:final 类不能被继承，没有类能够继承 final 类的任何特性
 * */

class JavaClass {

		int b=10;	//全局变量
	
		static int c=10;//类变量
		
		final int d=10;	//常量
		
		//构造方法
		public JavaClass(){

		}

		//成员方法
		public void fun1() {
		 	int a=10;//局部变量			
		}
	
		//静态方法(类方法)
		public static void fun2() {	
			System.out.print(c);
			new JavaClass().fun1();
		}
		
		//final方法
		final public void fun3() {
			
		}
		
}


//----------------------------------抽象类-------------------------------------//

/*
 * 抽象类：
 * 	a.抽象类不能用来实例化对象
 * 	b.抽象类不能用final修饰
 * 	c.包含抽象方法的类一定是抽象类
 * 	d.在抽象类中可以有构造方法，只是不能直接创建抽象类的实例对象，但实例化子类的时候，
 * 就会初始化父类，不管父类【是不是抽象类】都会调用父类的构造方法，初始化一个类，先初始化父类。 
 * */

abstract class JavaAbstract {

		/*
		 * 抽象方法
		 * 	a.该方法的的具体实现由子类提供
		 * 	b.抽象方法不能被声明成 final 和 static
		 * 	c.任何继承抽象类的子类必须实现父类的所有抽象方法，除非该子类也是抽象类
		 * */
		abstract public void fun1();
		public JavaAbstract() {
			System.out.println("this is abstract class");
		}
}


//-------------------------------接口------------------------------------------------------//

/*
 * 接口
 * 	a. implements 关键字可以变相的使java具有多继承的特性
 * 	b.一个抽象类型，是抽象方法的集合，接口通常以interface来声明
 * 	c.接口并不是类
 * 	d.除非实现接口的类是抽象类，否则该类要定义接口中的所有方法。
 * 	e.接口无法被实例化，但是可以被实现。
 * 	f.接口不能包含成员变量，除了 static final 变量。
 * 	h.在接口中 不可以有构造方法
 * */

public class JavaInterface {
	
		public static void main(String[] args) {
			Deal d=new Deal();
			d.run();
		}
}



interface InterFace{
		
		/*
		 * 	接口中每一个方法也是隐式抽象的,接口中的方法会被隐式的指定为 public abstract
		 * （只能是 public abstract，其他修饰符都会报错）。
		 * */
		void run();
		
		
		
		/*
		 * 接口中可以含有变量，但是接口中的变量会被隐式的指定为 public static final 变量
		 *（并且只能是 public，用 private 修饰会报编译错误）。
		 * */
		int a=10;
	
}

//实现接口
class Deal implements InterFace{
		
		@Override
		public void run() {
			System.out.println(a);
			
		}
}

//抽象类继承接口，可以不实现接口方法
abstract class DealTwo implements InterFace{
	
}



/*
 * 接口的继承
 * 	a.一个接口能继承另一个接口，和类之间的继承方式比较相似。接口的继承使用extends关键字
 * 	b.类的多继承是不合法，但接口允许多继承
 * */

interface InterFace2 extends InterFace{
	
}


//-------------------------------------访问控制---------------------------------------------//

/*
 *	访问控制
 *		public : 对所有类可见。使用对象：类、接口、变量、方法
 *		protected : 对同一包内的类和所有子类可见。使用对象：变量、方法。 注意：不能修饰类（外部类）。 
 *		default (即缺省，什么也不写）: 在同一包内可见，不使用任何修饰符。使用对象：类、接口、变量、方法。
 *		private : 在同一类内可见。使用对象：变量、方法。 注意：不能修饰类（外部类）
 * */


class JavaControlAccess {
		
		/*
		 * 私有变量
		 * 		a.私有变量只能通过类中公共的 getter 与 setter 方法被外部类操作。
		 * */
	   private String format;
	   
	   public String getFormat() {
	      return this.format;
	   }
	   
	   public void setFormat(String format) {
	      this.format = format;
	   }
}


//------------------------------------重写与重载---------------------------------------------//

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
 *
 *重写
 *		a.参数列表必须完全与被重写方法的相同
 *		b.返回类型必须完全与被重写方法的返回类型相同
 *		c.访问权限不能比父类中被重写的方法的访问权限更低
 *		d.声明为static的方法不能被重写
 *		e.重写方法不能抛出新的检查异常或者比被重写方法申明更加宽泛的异常	
 * */

public class JavaMethod {

	//可变参数
	public void fun1(int...var) {
		System.out.println(var.length);
	}
	
	
}

//-------------------------------继承--------------------------------------//

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

