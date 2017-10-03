package day8;


import java.util.HashMap;

/*
 * 享元模式
 * 		用于减少创建对象的数量，以减少内存占用和提高性能
 * 
 * 优点
 * 		大大减少对象的创建，降低系统的内存，使效率提高。
 * 
 * 缺点
 * 		提高了系统的复杂度，需要分离出外部状态（随着环境的改变而改变，不能够共享的状态就是外部状态）
 * 和内部状态（在享元对象内部不随外界环境改变而改变的共享部分），而且外部状态具有固有化的性质，不应该
 * 随着内部状态的变化而变化，否则会造成系统的混乱。
 * */

//颜色接口
interface Color{
	void draw();
}

//颜色实现类
class ColorImp implements Color{
	private String name;
	
	public ColorImp(String name) {
		this.name=name;
	}
	
	@Override
	public void draw() {
		System.out.println("This color is:"+this.name);
	}
	
}

//颜色类工厂
class ColorFactory{

	//共享对象组
	 private static final HashMap<String, Color> color = new HashMap<>();
	 
	 public static Color getColor(String name) {
		 Color colorImp=color.get(name);
		 if(colorImp==null) {
			 colorImp=new ColorImp(name);
			 color.put(name, colorImp);
			 System.out.println(name+" is created...");
		 }
		 return colorImp;
	 }
}


public class FlyweightPattern {
		
		public static void main(String[] args) {
				String[] arr= {"Red","Blue","Black","Green"};
				for(int i=0;i<10;i++) {
					Color c=ColorFactory.getColor(arr[(int)(Math.random()*4)]);
					c.draw();
				}
		}
}
