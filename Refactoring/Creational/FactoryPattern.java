package day24;


/*
 * 工厂模式
 * 		用于创建不同的对象
 * 
 * 优点
 * 		1.一个调用者想创建一个对象，只要知道其名称就可以了
 * 		2.屏蔽产品的具体实现，调用者只关心产品的接口
 * 缺点
 * 		1.每次增加一个产品时，都需要增加一个具体类和对象实现工厂
 * */


//共同接口
interface Person{
	void run();
}

//接口实现类Student
class Student implements Person{

	@Override
	public void run() {
		System.out.println("我们是student...");
	}
	
}

//接口实现类Teacher
class Teacher implements Person{

	@Override
	public void run() {
		System.out.println("我们是teacher...");
	}
}

//工厂类PersonFactory，用于生产不同的Person实例
class PersonFactory{
	
	public Person get(String name) {
		switch (name) {
		case "Teacher":
			return new Teacher();
		case "Student":
			return new Student();
		default:
			return null;
		}
			
	}
	
}

public class FactoryPattern {

		public static void main(String[] args) {
			PersonFactory pf=new PersonFactory();
			Person p=pf.get("Teacher");
			p.run();
		}
}
