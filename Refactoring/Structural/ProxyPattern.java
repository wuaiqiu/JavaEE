package day8;

/*
 * 代理模式(静态代理，运行前必须编写好代理类)
 * 		实现一个访问某个对象的中间层类
 * 
 * 优点
 * 		1、职责清晰。 
 * 		2、高扩展性。 
 * 		3、智能化。
 * 
 * 缺点
 *		1、实现代理模式需要额外的工作，静态代理模式的实现非常复杂。
 * */
interface Image{
	void display();
}

//需要被代理的对像
class RealImage implements Image{
	private String name;
	
	public RealImage(String name) {
		this.name=name;
	}

	@Override
	public void display() {
		System.out.println("Display: "+this.name);
	}
}

//代理类
class ImageProxy{
	private Image image;
	private String name;

	public ImageProxy(String name) {
		this.name=name;
	}
	
	public void display() {
		if(image==null) {
			image=new RealImage(this.name);
		}
		System.out.println("处理前....");
		image.display();
		System.out.println("处理后...");
	}
}

public class ProxyPattern {
	public static void main(String[] args) {
		ImageProxy ip=new ImageProxy("a.img");
		ip.display();
		ip.display();
	}
}
