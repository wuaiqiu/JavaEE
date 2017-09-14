package Base;

/*
 * 泛型
 * 		泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。
 * */

public class JavaGenericity {

			/*
			 * 泛型方法
			 * 		a.所有泛型方法声明都有一个【类型参数声明】，该【类型参数声明】
			 * 			在方法返回类型之前
			 * 		b.每一个【类型参数声明】包含一个或多个类型参数，参数间用逗号隔开
			 * 		c.泛型方法体的声明和其他方法一样。
			 * 		d.【类型参数】只能代表引用型类型
			 * 		e.【类型参数】能被用来声明返回值类型
			 * */
			public <E,T> T fun(E e,T t) {
				System.out.println("this is fun");
					return t;
			}
			
			
			//具有限制的泛型方法
			public <T extends Number> void fun2(T t) {
				System.out.println(t);
			}
			
			
			/*
			 *类型通配符
			 *		a.Box<Number>并不是Box<Integer>的父类，而利用通配符则可以在逻辑上表示父子关系
			 *		b.类型通配符一般是使用?代替具体的类型参数。?是传入的实参不是形参
			 *		b.Generi<?>代表所有类的父类，此处为Object 
			 * */
			public void fun3(Generi<?> g) {
				
			}
			
			
			/*
			 * 类型通配符上限
			 * */
			public void fun4(Generi<? extends Number> g) {
				
			}
			
			
			/*
			 * 类型通配符下限
			 * */
			public void fun5(Generi<? super Number> g) {
				
			}
}	


/*
 * 泛型类
 * 		泛型类的声明和非泛型类的声明类似，除了在类名后面添加了【类型参数声明】。
 * */
class Generi <T>{
	 private T t;
	 
	  public void add(T t) {
	    this.t = t;
	  }
	 
	  public T get() {
	    return t;
	  }
}
