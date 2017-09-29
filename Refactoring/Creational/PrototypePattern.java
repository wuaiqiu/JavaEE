package day3;

import java.util.HashMap;

/*
 *原型模式
 *		用于克隆重复的对象
 *
 *优点：
 *		1、性能提高(不需要多次实例化对象)。 
 *		2、逃避构造函数的约束。
 *
 *缺点：
 *		1、必须实现 Cloneable 接口
 *		2、当一个类引用不支持串行化的间接对象时，不能使用
 * */

//实现Cloneable
abstract class Person implements Cloneable{
		abstract void run();
		@Override
		public Object clone(){
			  Object clone = null;
		      try {
		         clone = super.clone();
		      } catch (CloneNotSupportedException e) {
		         e.printStackTrace();
		      }
		      return clone;
		}
}

//Person实现类Student
class Student extends Person{
	@Override
	void run() {
		System.out.println("this is Student");
	}
}

//Person实现类Teacher
class Teacher extends Person{
	@Override
	void run() {
		System.out.println("this is Teacher");
	}
}

//PersonCache存储对象实例类(利用HashMap<k,v>存储)
class PersonCache{
	private static HashMap<String,Person> hm=new HashMap<String, Person>();
	
	public static Person getPerson(String name) {
		Person p=hm.get(name);
		return (Person) p.clone();
	}
	
	public static void loadPerson() {
		Person s=new Student();
		hm.put("Student", s);
		Person p=new Teacher();
		hm.put("Teacher", p);
	}
}

public class PrototypePattern {
		
		public static void main(String[] args) {
			PersonCache.loadPerson();
			Student s=(Student) PersonCache.getPerson("Student");
			s.run();
		}
}
