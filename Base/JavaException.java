package Base;

public class JavaException {
	/*
	 * a.自己编写处理代理，后面的程序可以继续执行
	 * 		try{}catch(Exception e){}
	 * b.自己处理不了，在方法上声明，告诉调用者
	 * 		throws
	 * c.throws与throw的区别
	 * 		throw:在方法体中，后面跟的是异常对象名，并且只有一个
	 * 		throws:在方法上声明，后面跟的是异常类名，可以有多个
	 * */
	
	 public void deposit(double amount) throws Exception{
		 		throw new Exception();
	  }
}
