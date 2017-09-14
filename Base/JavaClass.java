package Base;
/*
 * Java中的类
 * 		a.局部变量：在方法、构造方法或者语句块中定义的变量被称为局部变量。变量声明
 * 		和初始化都是在方法中，方法结束后，变量就会自动销毁
 * 		b.成员变量：成员变量是定义在类中，方法体之外的变量。这种变量在创建对象的时候
 * 		实例化。成员变量可以被类中方法、构造方法和特定类的语句块访问。
 * 		c.类变量：类变量也声明在类中，方法体之外，但必须声明为static类型。
 * 		d.常量:使用 final 关键字来修饰常量
 * 
 * 构造方法
 * 		a.每个类都有构造方法。如果没有显式地为类定义构造方法，Java编译器将会为该类提供
 * 		一个默认构造方法。
 * 		b.构造方法的名称必须与类同名，一个类可以有多个构造方法。
 * 
 * 源文件
 * 		a.一个源文件中只能有一个public类
 * 		b.一个源文件可以有多个非public类
 * 		c.源文件的名称应该和public类的类名保持一致。
 * 		d.如果一个类定义在某个包中，那么package语句应该在源文件的首行。
 * 		e.如果源文件包含import语句，那么应该放在package语句和类定义之间。
 * 
 * Import语句
 * 		a.一个完整的限定名，包括包名、类名
 * 
 * 
 * */

public class JavaClass {

	
		int b=10;
		/*全局变量(实例变量)
		 * 	a.访问修饰符可以修饰实例变量
		 * 	b.具有默认值
		 * 
		 * */
	
		
		final int d=10;
			/*
			 *final常量
			 * 	a.只能初始化一次且必须立即初始化 
			 * */
		
		
		
		
		static int c=10;
		/*静态变量（类变量）
		 * 	a.访问修饰符可以修饰静态变量
		 * 	b.具有默认值
		 *  c.在其他类时，静态变量可以通过：ClassName.VariableName的方式访问
		 *  d.在本类时，静态变量可以看成全局变量使用
		 *  e.局部变量不能被声明为 static 变量
		 * */
	
		
		
		

	public void fun1() {
		int a=10;
	
	/*
	 * 局部变量
	 * 		a.访问修饰符不能用于局部变量
	 * 		b.局部变量是在栈上分配的
	 * 		c.局部变量没有默认值，所以局部变量被声明后，必须经过初始化，才可以使用	
	 * */	
	}
	
	
	
	
	/*
	 * 静态方法(类方法)
	 * 		a.静态方法可以直接调用静态变量与方法
	 * 		b.静态方法需要进行实例化后才能调用非静态变量与方法
	 * 		c.普通方法可以直接调用静态方法
	 * 		d.其他类调用静态方法，使用ClassName.MethodName()
	 * */
	public static void fun2() {
			
			System.out.print(c);
			new JavaClass().fun1();
	}
	
	
	/*
	 * final方法
	 * 		final方法可以被子类继承，但是不能被子类修改。
	 * */
	final public void fun3() {
		
	}
	
	
	/*
	 *final 类
	 *	final 类不能被继承，没有类能够继承 final 类的任何特性。
	 *
	 *fianl class Person{}
	 * */
}
