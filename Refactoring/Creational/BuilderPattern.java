package day3;

import java.util.ArrayList;
import java.util.List;

/*
 * 建造者模式
 * 	组合一些简单单的对象成为复杂对象
 * 
 * 优点:
 * 		 1、建造者独立，易扩展。 
 * 	 	 2、便于控制细节风险。(让复杂的对象细化实现)	
 * 
 * 缺点:
 * 		1、产品必须有共同点，范围有限制。 
 * 		2、如内部变化复杂，会有很多的产品类。
 * */

//包装接口
interface Packing{
	String getPack();
}

//包装实现类Wrapper
class Wrapper implements Packing{
	@Override
	public String getPack() {
		return "Wrapper";
	}
}

//包装实现类Bottle
class Bottle implements Packing{
	public String getPack() {
		return "Bottle";
	}
}

//产品接口
interface Item{
	String name();
	Packing packing();
	int price();
}

//产品抽象类（一类产品）,Burger产品类
abstract class Burger implements Item{
	@Override
	public Packing packing() {
		return new Wrapper();
	}
}

//产品抽象类（一类产品）,Drink产品类
abstract class Drink implements Item{
	@Override
	public Packing packing() {
		return new Bottle();
	}
}

//Burger具体产品
class VegBurger extends Burger{
	@Override
	public String name() {
		return "VegBurger";
	}

	@Override
	public int price() {
		return 10;
	}	
}

//Burger具体产品
class ChickenBurger extends Burger{
	@Override
	public String name() {
		return "ChickenBurger";
	}

	@Override
	public int price() {
		return 15;
	}
}

//Drink具体类
class Coke extends Drink{
	@Override
	public String name() {
		return "Coke";
	}

	@Override
	public int price() {
		return 5;
	}
}

//Drink具体类
class Pepsi extends Drink{
	@Override
	public String name() {
		return "Pepsi";
	}

	@Override
	public int price() {
		return 3;
	}
}

//Meal组合类
class Meal{
	 private List<Item> items = new ArrayList<Item>();    
	   
	 public void addItem(Item item){
	      items.add(item);
	  }

	 public int getCost(){
	      int cost = 0;
	      for (Item item : items) {
	         cost += item.price();
	      }        
	      return cost;
	  }

	   public void showItems(){
	      for (Item item : items) {
	         System.out.print("Item : "+item.name());
	         System.out.print(", Packing : "+item.packing().getPack());
	         System.out.println(", Price : "+item.price());
	      }        
	   }    
}

//MealBuilder套餐类
class MealBuilder{
	
	public Meal MealA(){
		Meal meal=new Meal();
		meal.addItem(new VegBurger());
		meal.addItem(new Coke());
		return meal;
	}
	
	public Meal MealB(){
		Meal meal=new Meal();
		meal.addItem(new ChickenBurger());
		meal.addItem(new Pepsi());
		return meal;
	}
}


public class BuilderPattern {
		public static void main(String[] args) {
			MealBuilder mb=new MealBuilder();
			Meal m=mb.MealA();
			System.out.println("需要："+m.getCost()+"元");
			System.out.println("组合如下");
			m.showItems();
		
		}
}
