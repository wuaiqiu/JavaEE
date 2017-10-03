package day9;

import java.util.ArrayList;
import java.util.List;

/*
 * 备忘录模式
 * 		保存一个对象的某个状态，以便在适当的时候恢复对象
 * 
 * 优点
 * 		1、给用户提供了一种可以恢复状态的机制，可以使用户能够比较方便地回到某个历史的状态。 
 * 		2、实现了信息的封装，使得用户不需要关心状态的保存细节。
 * 
 * 缺点
 * 	 	消耗资源。如果类的成员变量过多，势必会占用比较大的资源，而且每一次保存都会消耗一定的内存。
 * */

//备忘录类
class Memento{
	private String state;
	public Memento(String state) {
		this.state=state;
	}
	public String getState() {
		return state;
	}
}

//游戏类（可以存档）
class Game{
	private String state;
	private List<Memento> mementoList = new ArrayList<Memento>();
	public void setState(String state) {
		this.state = state;
	}
	public String getState() {
		return state;
	}
	public void saveState() {
		mementoList.add(new Memento(state));
	}
	public Memento getSavedState(int index) {
		return mementoList.get(index);
	}
}


public class MementoPattern {
		public static void main(String[] args) {
			Game g=new Game();
			g.setState("State #1");
			g.setState("State #2");
			g.saveState();
			g.setState("State #3");
			System.out.println(g.getState());
			System.out.println(g.getSavedState(0).getState());
		}
}
