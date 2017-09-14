package Base;
/*
 *	访问控制
 *		public : 对所有类可见。使用对象：类、接口、变量、方法
 *		protected : 对同一包内的类和所有子类可见。使用对象：变量、方法。 注意：不能修饰类（外部类）。 
 *		default (即缺省，什么也不写）: 在同一包内可见，不使用任何修饰符。使用对象：类、接口、变量、方法。
 *		private : 在同一类内可见。使用对象：变量、方法。 注意：不能修饰类（外部类）
 * */


public class JavaControlAccess {
		
		/*
		 * 私有变量
		 * 		a.私有变量只能通过类中公共的 getter 与 setter 方法被外部类操作。
		 * */
	   private String format;
	   
	   public String getFormat() {
	      return this.format;
	   }
	   
	   public void setFormat(String format) {
	      this.format = format;
	   }
}
