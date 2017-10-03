package day9;

/*
 * 策略模式
 * 		一个系统需要动态地在几种算法中选择一种
 * 
 * 优点
 * 		 1、算法可以自由切换。 
 * 		 2、避免使用多重条件判断。 
 * 		 3、扩展性良好。
 * 
 * 缺点
 * 		 1、策略类会增多。 
 * 		 2、所有策略类都需要对外暴露。
 * */

//策略接口
interface Strategy{
	int doOperation(int a,int b);
}

//加法策略
class Add implements Strategy{
	@Override
	public int doOperation(int a, int b) {
		return a+b;
	}	
}

//减法策略
class Sub implements Strategy{
	@Override
	public int doOperation(int a, int b) {
		return a-b;
	}	
}

//乘法策略
class Mul implements Strategy{
	@Override
	public int doOperation(int a, int b) {
		return a*b;
	}	
}

//运算类
class Operation {
	private Strategy s;
	public Operation(Strategy s) {
		this.s=s;
	}
	public int operation(int a,int b) {
			return s.doOperation(a, b);
	}
}


public class StrategyPattern {
	public static void main(String[] args) {
		Operation op=new Operation(new Add());
		System.out.println("6 + 3 = "+op.operation(6, 3));
		
		op=new Operation(new Mul());
		System.out.println("6 * 3 = "+op.operation(6, 3));
	}
}
