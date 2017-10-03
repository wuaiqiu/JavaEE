package day9;

/*
 *责任链模式
 *		 为请求创建了一组接收者的链
 *
 *优点
 *		1、降低耦合度。它将请求的发送者和接收者解耦。 
 *		2、简化了对象。使得对象不需要知道链的结构。 
 *		3、增强给对象指派职责的灵活性。通过改变链内的成员或者调动它们的次序，允许动态地新增或者
 *删除责任。 
 *		4、增加新的请求处理类很方便。
 *
 *缺点
 *		1、不能保证请求一定被接收。 
 *		2、系统性能将受到一定影响，而且在进行代码调试时不太方便，可能会造成循环调用。 
 *		3、可能不容易观察运行时的特征，有碍于除错。
 * */

//记录器抽象类
abstract class Logger{
	public static final int INFO=1;
	public static final int DEBUG=2;
	public static final int ERROR=3;
	
	protected int level;	//记录级别
	protected Logger nextLogger=null;//下一个记录器
	
	//实现责任链
	public void setNextLogger(Logger nextLogger){
	      this.nextLogger = nextLogger;
	}

	public void logMessage(int level, String message){
	      if(this.level <= level){
	    	  write(message);
	      }
	      if(nextLogger !=null){
	         nextLogger.logMessage(level, message);
	      }
	}

	abstract protected void write(String message);
	
}

//INFOLOGGER实现类
class INFOLogger extends Logger{

	public INFOLogger() {
		this.level=Logger.INFO;
	}
	
	@Override
	protected void write(String message) {
		System.out.println("INFO: "+message);
	}

}

//DEBUGLOGGER实现类
class DEBUGLogger extends Logger{

	public DEBUGLogger() {
		this.level=Logger.DEBUG;
		setNextLogger(new INFOLogger());
	}
	
	@Override
	protected void write(String message) {
		System.out.println("DEBUG: "+message);
	}
}

//ERRORLOGGER实现类
class ERRORLogger extends Logger{
	public ERRORLogger() {
		this.level=Logger.ERROR;
		setNextLogger(new DEBUGLogger());
	}
	
	@Override
	protected void write(String message) {
		System.out.println("INFO: "+message);
	}
}



public class ChainOfResponsibilityPattern {
	
	public static void main(String[] args) {
				Logger log=new ERRORLogger();
				log.logMessage(Logger.INFO, "这里有一个注意错误");
				log.logMessage(Logger.DEBUG, "这里有一个调试错误");
				log.logMessage(Logger.ERROR, "这里有一个严重错误");
	}
}
