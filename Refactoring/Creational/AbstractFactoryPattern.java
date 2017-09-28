package day24;

/*
 * 抽象工厂模式
 *		用于创建其他种类工厂的超级工厂
 *
 * 优点:
 * 		1.当一个产品族(某个Factory的实现类)中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象
 * 
 * 缺点：
 * 		1.产品族扩展非常困难，要增加一个系列（某个Factory），既要在抽象的 Factory 里加代码，又要在具体的实现工厂类的里面加代码。
 * */

//Person系列接口
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

//Color系列接口
interface Color{
	void draw();
}

//Color接口实现类Red
class Red implements Color{

	@Override
	public void draw() {
		System.out.println("This is Red");
	}
	
}

//Color接口实现类Green
class Green implements Color{
	@Override
	public void draw() {
		System.out.println("This is Green");
	}
}


//所有系列的工厂接口
interface Factory{
	Person getPerson(String Person);
	Color getColor(String Color);
}

//Person系列的工厂接口实现工厂类PersonFactory
class PersonFactory implements Factory{

	@Override
	public Person getPerson(String Person) {
		switch (Person) {
		case "Teacher":
			return new Teacher();
		case "Student":
			return new Student();
		default:
			return null;
		}
	}

	@Override
	public Color getColor(String Person) {
		return null;
	}
	
}


//Color系列的工厂接口实现工厂类ColorFactory
class ColorFactory implements Factory{

	@Override
	public Person getPerson(String Person) {
		return null;
	}

	@Override
	public Color getColor(String Color) {
		switch (Color) {
		case "Red":
			return new Red();
		case "Green":
			return new Green();
		default:
			return null;
		}
	}
}

//超级工厂，生产某个系列的工厂
class SuperFacotry{
	
	public Factory getFactory(String name) {
		switch (name) {
		case "Color":
			return new ColorFactory();
		case "Person":
			return new PersonFactory();
		default:
			return null;
		}
	}
}


public class AbstractFactoryPattern {

		public static void main(String[] args) {
			SuperFacotry sf=new SuperFacotry();
			Factory f=sf.getFactory("Person");
			Person p=f.getPerson("Teacher");
			p.run();
		}
}
