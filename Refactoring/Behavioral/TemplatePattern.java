package day9;
/*
 * 模板模式
 * 		在一个抽象类公开定义了执行它的方法的方式/模板。它的子类可以按需要重写方法实现，但调用将以
 * 抽象类中定义的方式进行
 * 
 * 优点
 * 		 1、封装不变部分，扩展可变部分。 
 * 		 2、提取公共代码，便于维护。 
 * 		 3、行为由父类控制，子类实现。
 * 
 * 缺点
 * 		 每一个不同的实现都需要一个子类来实现，导致类的个数增加，使得系统更加庞大。
 * */

abstract class Game{
	public abstract void start();
	public abstract void stop(); 
	 //模板方法，一般不能被子类修改所有用final修饰
	 public final void play(){
		 start();
		 stop();
	 }
}

//Game的实现类
class FootballGame extends Game{
	@Override
	public void start() {
		System.out.println("FootballGame is starting...");
	}
	@Override
	public void stop() {
		System.out.println("FootballGame is stoping...");
	}
}

//Game的实现类
class BasketballGame extends Game{
	@Override
	public void start() {
		System.out.println("BasketballGame is starting...");
	}
	@Override
	public void stop() {
		System.out.println("BasketballGame is stoping...");
	}
}



public class TemplatePattern {
	public static void main(String[] args) {
		Game g1=new FootballGame();
		g1.play();
		
		Game g2=new BasketballGame();
		g2.play();
	}
}
