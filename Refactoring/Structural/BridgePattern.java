package day3;

/*
 *桥接模式
 *	 用于把抽象化与实现化解耦，使得二者可以独立变化
 *
 *优点：
 *	 1、抽象和实现的分离。 
 *	 2、优秀的扩展能力。 
 *	 3、实现细节对客户透明。
 *
 *缺点:
 *	 桥接模式的引入会增加系统的理解与设计难度，由于聚合关联关系建立在抽象层，要求开发
 *者针对抽象进行设计与编程。
 * */

//桥接接口（让其实现类与使用此接口的类无关）
interface Color{
	void draw(String name);
}

//桥接接口实现类
class Red implements Color{
	@Override
	public void draw(String name) {
		System.out.println("This is Red "+name);
	}
}

//桥接接口实现类
class Green implements Color{
	@Override
	public void draw(String name) {
		System.out.println("This is Green "+name);
	}
}

//shape类（使用桥接接口）
class Shape{
	private Color c;
	private String name;
	
	public Shape(String name,Color c) {
		this.name=name;
		this.c=c;
	}
	
	public void draw() {
		c.draw(name);
	}
}


public class BridgePattern {
		public static void main(String[] args) {
			Shape s=new Shape("circle",new Red());
			s.draw();
		}
}
