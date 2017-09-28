package day24;

/*
 * 单例模式
 * 		用于产生唯一的实例对象
 * 
 * 优点：
 * 		1.在内存里只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例
 * 		2.避免对资源的多重占用（比如写文件操作）
 * 
 * 缺点：
 * 		1.不能继承，与单一职责原则冲突（所有功能都在此类中完成）
 * */


//懒汉式，线程不安全：第一次调用才初始化，避免内存浪费；但在多线程不能保证单例
class Singleton{  
	//创建 Singleton的私有一个对象
    private static Singleton instance;  
    //让构造函数为 private，这样该类就不会被实例化
    private Singleton (){}  
   //获取唯一可用的对象
    public static Singleton getInstance() {  
	    if (instance == null) {  
	        instance = new Singleton();  
	    }  
	    return instance;  
    }  
    public void showMessage(){
	      System.out.println("Hello World");
	}
}  


//懒汉式，线程安全:第一次调用才初始化，避免内存浪费，但加锁会影响效率。
class Singleton {  
    private static Singleton instance;  
    private Singleton (){}  
    public static synchronized Singleton getInstance() {  
    if (instance == null) {  
        instance = new Singleton();  
    }  
    return instance;  
    }  
    public void showMessage(){
	      System.out.println("Hello World");
	}
} 


//饿汉式，线程安全：没有加锁，执行效率会提高。但类加载时就初始化，浪费内存
class Singleton {  
    private static Singleton instance = new Singleton();  
    private Singleton (){}  
    public static Singleton getInstance() {  
    	return instance;  
    }  
    public void showMessage(){
	      System.out.println("Hello World");
	}
}  


//双重校验锁（DCL，即 double-checked locking）,线程安全
class Singleton {  
    private volatile static Singleton singleton;  
    private Singleton (){}  
    public static Singleton getInstance() {  
	    if (singleton == null) {  
	        synchronized (Singleton.class) {   
	            singleton = new Singleton();  
	        }  
	    }  
	    return singleton;  
    }  
    public void showMessage(){
	      System.out.println("Hello World");
	}
}  


//静态内部类,线程安全
class Singleton {  
    private static class SingletonHolder {  
    	private static final Singleton INSTANCE = new Singleton();  
    }  
    private Singleton (){}  
    public static final Singleton getInstance() {  
    	return SingletonHolder.INSTANCE;  
    }  
    public void showMessage(){
	      System.out.println("Hello World");
	}
}   


public class SingletonPattern {

			public static void main(String[] args) {
				Singleton s=Singleton.getInstance();
				s.showMessage();
				Singleton s1=Singleton.getInstance();
				System.out.println(s==s1);
			}
}
