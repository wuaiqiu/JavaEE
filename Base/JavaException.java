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



	//测试自定义错误类
	public static void main(String[] args) {
			try {
				new Demo().fun();
			}catch(MyException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
	}
	
}


/*
 * 
 * IOException	-> Exception -> Throwable
 * 
 * Throwable函数
 * 	public String getMessage() 返回关于发生的异常的详细信息
 * 	public Throwable getCause()返回一个Throwable 对象代表异常原因。
 * 	public void printStackTrace()打印错误输出流。
 *  
 * */

/*
 * 自定义错误处理函数
 * 	
 * */
class MyException extends Exception{
	public MyException(String msg) {
		super(msg);
	}
}


class Demo{
	
	public void fun() throws MyException{
		throw new MyException("发现一个错误");
	}
}