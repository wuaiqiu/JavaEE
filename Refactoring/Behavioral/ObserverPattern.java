package day9;

import java.util.ArrayList;
import java.util.List;
/*
 * 观察者模式
 * 		解决一个对象（观察目标）状态改变给其他对象（有依赖关系，观察者对象）通知的问题
 * 
 * 优点
 * 	 	1、观察者和观察目标是抽象耦合的。 
 * 	 	2、建立一套触发机制。
 * 
 * 缺点
 * 		1、如果一个观察目标对象有很多的直接和间接的观察者的话，将所有的观察者都通知到会花费很多
 * 时间。 
 * 		2、如果在观察者和观察目标之间有循环依赖的话，观察目标会触发它们之间进行循环调用，可能导
 * 致系统崩溃。 
 * 		3、观察者模式没有相应的机制让观察者知道所观察的目标对象是怎么发生变化的，而仅仅只是知
 * 道观察目标发生了变化。
 * */

//观察目标类
class Person{
  private List<Observer> observers = new ArrayList<Observer>();

  public void attach(Observer observer){
     observers.add(observer);        
  }

  public void notifyAllObservers(){
     for (Observer observer : observers) {
        observer.update();
     }
  }     
}

//观察者抽象类
abstract class Observer{
	protected Person person;
	public abstract void update();
}

//观察者实现类Student
class Student extends Observer{
	public Student(Person p) {
		this.person=p;
		p.attach(this);
	}
	@Override
	public void update() {
		System.out.println("Student is Update...");
	}
}

//观察者实现类Teacher
class Teacher extends Observer{
	public Teacher(Person p) {
		this.person=p;
		p.attach(this);
	}
	@Override
	public void update() {
		System.out.println("Teacher is Update...");
	}
}

//观察者实现类Worker
class Worker extends Observer{
	public Worker(Person p) {
		this.person=p;
		p.attach(this);
	}
	@Override
	public void update() {
		System.out.println("Worker is Update...");
	}
}



public class ObserverPattern {
	public static void main(String[] args) {
		Person p=new Person();
		new Student(p);
		new Teacher(p);
		new Worker(p);
		p.notifyAllObservers();
	}
}
