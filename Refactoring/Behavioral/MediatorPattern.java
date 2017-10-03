package day9;

/*
 * 中介者模式
 * 		处理不同类（不同对象）之间的通信
 * 
 * 优点
 * 		1、降低了类的复杂度，将一对多转化成了一对一。 
 * 		2、各个类之间的解耦。
 * 
 * 缺点
 * 		中介者会庞大，变得复杂难以维护
 * */

//用于产生不同对象
class User{
	private String name;
	public User(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void sendMessage(String message) {
		Mediator.message(this,message);
	}
}


//中间类
class Mediator{
	public static void message(User user,String message) {
		System.out.println("["+user.getName()+"]: "+message);
	}
}


public class MediatorPattern {
	public static void main(String[] args) {
		User u1=new User("zhangsan");
		User u2=new User("lisi");
		u1.sendMessage("Hello,I am eason");
		u2.sendMessage("Hi,My name is jay");
	}
}
