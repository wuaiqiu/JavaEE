package Base;
/*
 * 封装
 * 	 1.封装可以被认为是一个保护屏障，防止该类的代码和数据被外部类定义的代码随机访问。
 * 	 2.要访问该类的代码和数据，必须通过严格的接口控制。
 *	 3.封装最主要的功能在于我们能修改自己的实现代码，而不用修改那些调用我们代码的程序片段。
 * */
public class JavaEncapsulation {
		
	public static void main(String[] args) {
		Encap p=new Encap();
		p.getFun();
		System.out.println(p.getName());
	}
		
}


class Encap{

	//封装方法，隐藏实现细节
	private void fun(){
		System.out.println("this is fun");
	}
	
	//封装属性
	private String name="zhangsan";
	
	//提供访问接口
	public void getFun() {
		fun();
	}
	
	//提供访问接口
	public String getName() {
		return this.name;
	}
}
