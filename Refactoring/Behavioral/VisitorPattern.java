package day9;
/*
 * 访问者模式
 * 		使用了一个访问者类，改变了元素类的执行算法
 * 
 * 优点
 * 		 1、符合单一职责原则。 
 * 		 2、优秀的扩展性。 
 * 		 3、灵活性。
 * 
 * */

//元素接口
interface ComputerPart {
	void accept(ComputerPartVisitor computerPartVisitor);
}

//元素实现类
class Keyboard implements ComputerPart{
	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
			computerPartVisitor.visit(this);
	}
}

//元素实现类
class Monitor implements ComputerPart{
	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
			computerPartVisitor.visit(this);
	}
}

//元素实现类
class Mouse implements ComputerPart{
	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
			computerPartVisitor.visit(this);
	}
}

//电脑类
class Computer{
	ComputerPart[] arr;
	public Computer() {
		arr= new ComputerPart[]{new Keyboard(),new Monitor(),new Mouse()};
	}

	public void accept(ComputerPartVisitor computerPartVisitor) {
		 for (int i = 0; i < arr.length; i++) {
	         arr[i].accept(computerPartVisitor);
	      }
	}
}


//访问者接口
interface ComputerPartVisitor{
	void visit(Keyboard keyboard);
	void visit(Monitor monitor);
	void visit(Mouse mouse);
}

//访问者实现类
class ComputerVisitor implements ComputerPartVisitor{
	@Override
	public void visit(Keyboard keyboard) {
		System.out.println("This is Keyboard...");
	}
	@Override
	public void visit(Monitor monitor) {
		System.out.println("This is Monitor...");
	}
	@Override
	public void visit(Mouse mouse) {
		System.out.println("This is Mouse...");
	}
}

public class VisitorPattern {
	public static void main(String[] args) {
		Computer com=new Computer();
		com.accept(new ComputerVisitor());
	}
}
