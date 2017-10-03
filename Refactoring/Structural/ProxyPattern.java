package day8;

/*
 * 代理模式
 * 		实现一个访问某个对象的中间层类
 * 
 * 优点
 * 		1、职责清晰。 
 * 		2、高扩展性。 
 * 		3、智能化。
 * 
 * 缺点
 * 		1、由于在客户端和真实主题之间增加了代理对象，因此有些类型的代理模式可能会造成请求的处理
 *速度变慢。 
 *		2、实现代理模式需要额外的工作，有些代理模式的实现非常复杂。
 * */
interface Image{
	void display();
}

//需要被代理的对像
class RealImage implements Image{
	private String name;
	
	public RealImage(String name) {
		this.name=name;
		loadImage(this.name);
	}
	
	
	private void loadImage(String name) {
		System.out.println("LoadImage: "+name);
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
		image.display();
	}
}

public class ProxyPattern {
	public static void main(String[] args) {
		ImageProxy ip=new ImageProxy("a.img");
		ip.display();
		ip.display();
	}
}
