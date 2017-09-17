package day13;



/*
 * 抽象类：
 * 		a.抽象类不能用来实例化对象
 * 		b.抽象类不能用final修饰
 * 		c.包含抽象方法的类一定是抽象类
 * 		d.在抽象类中可以有构造方法，只是不能直接创建抽象类的实例对象，但实例化子类的时候，
 * 就会初始化父类，不管父类是不是抽象类都会调用父类的构造方法，初始化一个类，先初始化父类。 
 * */

public abstract class JavaAbstract {

		/*
		 * 抽象方法
		 * 		a.该方法的的具体实现由子类提供
		 * 		b.抽象方法不能被声明成 final 和 static
		 * 		c.任何继承抽象类的子类必须实现父类的所有抽象方法，除非该子类也是抽象类
		 * */
		abstract public void fun1();
		public JavaAbstract() {
			System.out.println("this is abstract class");
		}
}
