package day9;

/*
 * 状态模式
 * 		允许对象在内部状态发生改变时改变它的行为，对象看起来好像修改了它的类
 * 
 * 优点
 * 		1、封装了转换规则。 
 * 		2、将所有与某个状态有关的行为放到一个类中，并且可以方便地增加新的状态，只需要改变对象
 * 状态即可改变对象的行为。 
 * 
 * 缺点
 * 		1、状态模式的使用必然会增加系统类和对象的个数。 
 * */

//状态接口
interface State{
	void doAction(Player p);
}

//开始状态
class Start implements State{
	@Override
	public void doAction(Player p) {
		System.out.println("Player is Start...");
		p.setState(this);
	}
	public String toString() {
		return "[State]: Start";
	}
}

//暂停状态
class Suspend implements State{
	@Override
	public void doAction(Player p) {
		System.out.println("Player is Suspend...");
		p.setState(this);
	}
	public String toString() {
		return "[State]: Suspend";
	}
}

//结束状态
class Stop implements State{
	@Override
	public void doAction(Player p) {
		System.out.println("Player is Stop...");
		p.setState(this);
	}
	public String toString() {
		return "[State]: Stop";
	}
}

//运动员类
class Player{
	private State state;
	public void setState(State state) {
		this.state=state;
	}
	public State getState() {
		return this.state;
	}
}



public class StatePattern {
		public static void main(String[] args) {
			Player p=new Player();
			
			State start=new Start();
			start.doAction(p);
			System.out.println(p.getState());
			
			State stop=new Stop();
			stop.doAction(p);
			System.out.println(p.getState());
		}
}
