package day9;

import java.util.ArrayList;
import java.util.List;



/*
 * 命令模式
 * 		请求以命令的形式包裹在对象中，并传给调用对象。调用对象寻找可以处理该命令的合适的对象，
 * 并把该命令传给相应的对象，该对象执行命令。
 * 
 * 优点
 * 		1、降低了系统耦合度。 
 * 		2、新的命令可以很容易添加到系统中去。
 * 
 * 缺点
 * 		使用命令模式可能会导致某些系统有过多的具体命令类。
 * */

//请求类（包含两条请求	）
class Stock{
	public void buy() {
		System.out.println("This is buy"); 
	}
	public void sell() {
		System.out.println("This is sell");
	}
}

//命令接口
interface Order{
	void execute();
}

//请求实现类（命令对象）
class BuyStock implements Order{
	private Stock s;
	public BuyStock(Stock s) {
		this.s=s;
	}
	@Override
	public void execute() {
		s.buy();
	}	
}

//请求实现类（命令对象）
class SellStock implements Order{
	private Stock s;	
	public SellStock(Stock s) {
		this.s=s;
	}
	@Override
	public void execute() {
		s.sell();
	}	
}

//命令调用类
class Broker{
	private List<Order> orderList = new ArrayList<Order>(); 
	   public void takeOrder(Order order){
	      orderList.add(order);        
	   }

	   public void placeOrders(){
	      for (Order order : orderList) {
	         order.execute();
	      }
	      orderList.clear();
	   }
}

public class CommandPattern {
	
	public static void main(String[] args) {
		Stock s=new Stock();
		Order o1=new BuyStock(s);
		Order o2=new SellStock(s);
		
		Broker b=new Broker();
		b.takeOrder(o1);
		b.takeOrder(o2);
		b.placeOrders();
	}
}
