package day9;

/*
 * 空对象模式
 * 		一个取代 NULL 对象的实例
 * 
 * */

//Person抽象类
abstract class Person{
	protected String name;
	public abstract String getName();
	public abstract void run();
}

//Person的实现类Student
class Student extends Person{
	public Student(String name) {
		this.name=name;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void run() {
		System.out.println(name+" is Running...");
	}
}

//Person的实现类Nil
class Nil extends Person{
	public Nil() {
		this.name="Nil";
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void run() {
		System.out.println(name+" is not a Person");
	}
}

//PersonFactory类
class PersonFactory{
	public static final String[] names = {"zhangsan", "lisi", "wangwu"};
	public static Person getPerson(String name){
	      for (int i = 0; i < names.length; i++) {
	         if (names[i].equalsIgnoreCase(name)){
	            return new Student(name);
	         }
	      }
	      return new Nil();
	   }
}

public class NullObjectPattern {
	public static void main(String[] args) {
		Person p1=PersonFactory.getPerson("zhangsan");
		System.out.println(p1.getName());
		p1.run();
		
		Person p2=PersonFactory.getPerson("eason");
		System.out.println(p2.getName());
		p2.run();
	}
}
