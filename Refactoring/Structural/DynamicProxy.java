package day8;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * 动态代理(代理类在程序运行时创建的代理方式)
 * 	
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


//调用处理器(用于调用代理类的方法)
class ProxyHandler implements InvocationHandler{

	private Object image;

	public ProxyHandler(Object image){
		this.image=image;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("处理前...");
		Object result=method.invoke(image, args);
		System.out.println("处理后...");
		return result;
	}
	
}


//动态生成代理
public class DynamicProxy{

	/*
	 * newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
	 * 
	 * loader - 定义代理类的类加载器
	 * interfaces - 代理类要实现的接口列表
	 * h - 指派方法调用的调用处理程序
	 * */
	public static void main(String[] args) {
		Image image=(Image)Proxy.newProxyInstance(Image.class.getClassLoader(), new Class[] {Image.class}, new ProxyHandler(new RealImage("a.img")));
		image.display();
		
	}
}