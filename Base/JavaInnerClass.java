package day13;


/*
 *使用内部类最吸引人的原因是：
 *		每个内部类都能独立地继承一个（类，接口），所以无论外围类是否已经继承了这个（类，接口），对
 *于内部类都没有影响。
 *		多重继承：接口只是解决了部分问题，而内部类使得多重继承的解决方案变得更加完整。
 *		内部类是个编译时的概念，一旦编译成功后，它就与外围类属于两个完全不同的类,在编译成功后，
 *会出现这样两个class文件：Outerclass.class和Outerclass$Innerclass.class。
 * */

public class JavaInnerClass {
	
		public static void main(String[] args) {
				
				//直接实例化内部类
				Outerclass out=new Outerclass();
				Outerclass.Innerclass in1=out.new Innerclass();
				in1.getAge();
				in1.getFun();
				
				
				//利用外部类获取内部类实例
				Outerclass.Innerclass in2=out.getInner();
				in2.getAge();
				in2.getFun();
				
				//外部类获取内部类属性与方法
				out.getFun2();
				
				//利用内部类获取外部类实例
				Outerclass out1=in2.getOuter();
				out1.fun();
				
				//局部内部类
				Outerclass2 out2=new Outerclass2();
				out2.fun();
				
				//匿名内部类
				Outerclass3 out3= new Outerclass3();
				Innerclass3 in3=out3.in3;
				in3.fun();
				
				//静态内部类
				Outerclass4 out4=new Outerclass4();
				out4.fun();
				
				Outerclass4.Innerclass4 in4=new Outerclass4.Innerclass4();
				in4.fun2();//调用非静态方法
				System.out.println(Outerclass4.Innerclass4.a);
			
		}

}





class Father{
	
}

class Mother{
	
}


/*
 * 1.成员内部类
 * 		a.成员内部类中不能存在任何static的变量和方法；
 * 		b.成员内部类是依附于外围类的，所以只有先创建了外围类才能够创建内部类。
 * */
class Outerclass extends Father{
	
	public int age=10;
	
	public void fun() {
		System.out.println("this is fun method");
	}
	
	//外部类获取内部类需要实例化内部类
	public void getFun2() {
		Innerclass in=getInner();
		in.fun2();
	
	}
	
	//利用外部类获取内部类实例
	public Innerclass getInner() {
		return new Innerclass();
	}
	
	//内部类，内部类可以访问外部类的属性与方法
	public class Innerclass extends Mother{
		
		public void fun2() {
			System.out.println("this is fun2");
		}
		
		public void getAge() {
			System.out.println("age-->"+age);
		}
		
		public void getFun() {
			fun();
		}
		
		//内部类获取外部类实例
		public Outerclass getOuter() {
			return Outerclass.this;
		}
	}
}


/*
 * 2.局部内部类
 * 		a.利用局部类完成一些辅助功能，用完即随方法一同销毁;
 * 		b.局部内部类不能使用修饰符
 * */
class Outerclass2{
	
	public int age=10;
	
	public void fun() {
		
		String name="zhangsan";
		
		class Innerclass2{
			public void fun2() {
				System.out.println("name-->"+name);
				System.out.println("age-->"+age);
			}
		}
		new Innerclass2().fun2();
	}
}


/*
 * 3.匿名内部类
 * 		a.匿名内部类必须要继承一个类或者实现一个接口
 * 		b.定义的匿名内部类是非持久，实例化出该对象后该类就会消失
 * 		c.匿名内部类为局部内部类
 * 		d.当所在的方法的形参需要被内部类里面使用时，该形参必须为final(不可改变)。因为内部类获取参数为拷贝引用。与方法内部参数无关
 * 		e.匿名类返回的是Innerclass3接口对象，实现多态
 * */
interface Innerclass3{
	void fun();
}


class Outerclass3{
	public int age=11;
	
	Innerclass3 in3=new Innerclass3() {
		public void fun() {
			System.out.println("实现Innerclass4接口的fun方法");
		}
	};
	
	public Innerclass3 fun2(final int a) {
		
		return new Innerclass3() {
			public void fun() {
				System.out.println(a);
			}
		};
	}
	
	
	
	
}


/*
 * 4.静态内部类
 * 		a.它的创建是不需要依赖于外围类的。
 * 		b.它不能使用任何外围类的非static成员变量和方法。
 * */

class Outerclass4{
	
	//外部类访问静态内部类方式
	public void fun() {
		new Innerclass4().fun2();
		System.out.println(Innerclass4.a);
	}
	
	
	static class Innerclass4{
		static int a=4;
		public void fun2() {
			System.out.println("this is fun2");
		}
	}
	
	
}