package day9;

/*
 * 解释器模式
 * 		每一个语法规则都将对应一个解释器对象，用来处理相应的语法规则
 * 
 * 优点
 * 		1、可扩展性比较好，灵活。 
 * 		2、增加了新的解释表达式的方式。
 * 
 * 缺点
 * 		1、可利用场景比较少。
 * 		2、对于复杂的文法比较难维护。 
 * */

//解释器接口
interface Expression{
	boolean interpret(String context);
}

//包含规则解释器
class ContainExpression implements Expression{
		private String data;
		public ContainExpression(String data) {
			this.data=data;
		}
		@Override
		public boolean interpret(String context) {
			if(data.contains(context)) {
				return true;
			}else {
			   return false;
			}
		}
}

//AND规则解释器
class ANDExpression implements Expression{
		private Expression con1;
		private Expression con2;
		public ANDExpression(Expression con1,Expression con2) {
			this.con1=con1;
			this.con2=con2;
		}
		@Override
		public boolean interpret(String context) {
			return con1.interpret(context)&&con2.interpret(context);
		}
}

//OR规则解释器
class ORExpression implements Expression{
		private Expression con1;
		private Expression con2;
		public ORExpression(Expression con1,Expression con2) {
			this.con1=con1;
			this.con2=con2;
		}
		@Override
		public boolean interpret(String context) {
			return con1.interpret(context)||con2.interpret(context);
		}
}


public class InterpreterPattern {
		public static void main(String[] args) {
				Expression e1=new ContainExpression("Hello");
				Expression e2=new ContainExpression("World");
				
				Expression and=new ANDExpression(e1, e2);
				System.out.println(and.interpret("Hello"));
				
				Expression or=new ORExpression(e1, e2);
				System.out.println(or.interpret("Hello"));
		}
}
