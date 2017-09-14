package Base;

/*
 * 抽象类：
 * 		a.抽象类不能用来实例化对象
 * 		b.抽象类不能用final修饰
 * 		c.包含抽象方法的类一定是抽象类
 * */

public abstract class JavaAbstract {

		/*
		 * 抽象方法
		 * 		a.该方法的的具体实现由子类提供
		 * 		b.抽象方法不能被声明成 final 和 static
		 * 		c.任何继承抽象类的子类必须实现父类的所有抽象方法，除非该子类也是抽象类
		 * */
		abstract public void fun1();
}
