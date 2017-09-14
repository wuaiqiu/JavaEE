package Base;

/*
 * 接口
 * 		a. implements 关键字可以变相的使java具有多继承的特性
 * 		b.一个抽象类型，是抽象方法的集合，接口通常以interface来声明
 * 		c.接口并不是类
 * 		d.除非实现接口的类是抽象类，否则该类要定义接口中的所有方法。
 * 		e.接口无法被实例化，但是可以被实现。
 * 		f.接口不能包含成员变量，除了 static 和 final 变量。
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
 * 		a.一个接口能继承另一个接口，和类之间的继承方式比较相似。接口的继承使用extends关键字
 * 		b.类的多继承是不合法，但接口允许多继承
 * */

interface InterFace2 extends InterFace{
	
}

