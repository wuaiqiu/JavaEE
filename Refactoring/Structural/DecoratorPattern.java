package day7;

/*
 * 装饰器模式
 * 		向一个现有的对象添加新的功能，同时又不改变其结构
 * 	
 * 优点
 * 		装饰类和被装饰类可以独立发展，不会相互耦合，装饰模式是继承的一个替代模式，装饰模式
 * 可以动态扩展一个实现类的功能。
 * 
 * 缺点
 * 		多层装饰比较复杂。	
 * */

//统一接口(被装饰接口)
interface Shape{
	void draw();
}

//接口的实现类
class Circle implements Shape{
	@Override
	public void draw() {
		System.out.print("this is Circle");
	}
}

//接口的实现类
class Rectangle implements Shape{
	@Override
	public void draw() {
		System.out.print("this is Rectangle");
	}
}

//装饰抽象类
abstract class ShapeDecorator implements Shape{
	Shape shape;
	public ShapeDecorator(Shape shape) {
		this.shape=shape;
	}
	
	@Override
	public void draw() {
		shape.draw();
	}
}  

//装饰实现类
class RedShapeDecorator extends ShapeDecorator{

	public RedShapeDecorator(Shape shape) {
		super(shape);
	}
	
	@Override
	public void draw() {
		super.draw();
		setColor();
	}
	
	private void setColor() {
		System.out.println(";the color is red");
	}	
}


public class DecoratorPattern {
	public static void main(String[] args) {
		RedShapeDecorator rsd1=new RedShapeDecorator(new Circle());
		RedShapeDecorator rsd2=new RedShapeDecorator(new Rectangle());
		rsd1.draw();
		rsd2.draw();
	}
}
