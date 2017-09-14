package Base;

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
 *重写规则
 *		1.参数列表必须完全与被重写方法的相同
 *		2.返回类型必须完全与被重写方法的返回类型相同
 *		3.访问权限不能比父类中被重写的方法的访问权限更低
 *		4.声明为static的方法不能被重写
 *		5.重写方法不能抛出新的检查异常或者比被重写方法申明更加宽泛的异常
 *
 * */

public class JavaInhert {

}


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
