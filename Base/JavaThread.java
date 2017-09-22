//-----------------------------------多线程的实现----------------------------------//
/*
 * 多线程的实现
 * 	A.继承Thread类,重写该类的run()方法
 * 	B.实现Runable接口，并重写该接口的run()方法，创建Runnable实现类的实例，并以此实
 * 例作为Thread类的target来创建Thread对象，该Thread对象才是真正的线程对象。
 * 	C.需要在main方法中启动线程
 * 	D.Thread类本身也是实现了Runnable接口，而run()方法最先是在Runnable接口中定义的方法,
 * 当执行到Thread类中的run()方法时，会首先判断target是否存在，存在则执行target中的
 * run()方法，也就是实现了Runnable接口并重写了run()方法的类中的run()方法
 *  F.主线程名为main，子线程名为Thread-0，Thread-1...
 * */

/*
 * Thread类有关方法
 * 	static Thread currentThread() : 返回对当前正在执行的线程对象的引用
 *  String	getName() : 返回该线程的名称
 *  void setPriority(int newPriority) : 更改线程的优先级(1-10),
 *  								static int	MAX_PRIORITY  --> 10
 *  								static int	NORM_PRIORITY --> 5
 *  								static int	MIN_PRIORITY  --> 1
 *  int	getPriority() : 返回线程的优先级
 *  static void	sleep(long millis) : 在指定的毫秒数内让当前正在执行的线程休眠
 *  void join() : 等待该线程终止
 *  static void	yield() : 暂停当前正在执行的线程对象，并执行其他线程
 *  void  setDaemon(boolean on) : 将该线程标记为守护线程或用户线程
 *  void interrupt() : 中断线程
 * 
 * */
/*
class MyThread extends Thread{

	//重写线程执行体
	public void run() {
		for(int x=0;x<3000;x++) {
			System.out.println(Thread.currentThread().getName()+" "+x);
		}
	}
}

class MyRunable implements Runnable{
	public void run() {
		for(int x=0;x<3000;x++) {
			System.out.println(Thread.currentThread().getName()+" "+x);
		}
	}
	
}
*/
public class JavaThread {
		
		
		
		public static void main(String[] args) {
			
			MyThread t1=new MyThread();//创建线程
			MyThread t2=new MyThread();
			System.out.println(Thread.currentThread().getName());
			t1.start();//线程进入就绪状态
			t2.start();
			
			
			
			MyRunable myRunable=new MyRunable();//创建一个Runnable实现类的对象
			Thread t1=new Thread(myRunable);//将myRunnable作为Thread target创建新的线程
			Thread t2=new Thread(myRunable);
			System.out.println(Thread.currentThread().getName());
			t1.start();//线程进入就绪状态
			t2.start();
			
			
			
		}

}



//-------------------------------------多线程调度---------------------------------------------//

/*
 * 多线程调度
 * 	A.线程的优先级有继承关系，比如A线程中创建了B线程，那么B将和A具有相同的优先级。
 * */

class MyThread extends Thread{
	
	public void run() {
			for(int x=0;x<3000;x++) {
				System.out.println(Thread.currentThread().getName()+"的优先度:"+Thread.currentThread().getPriority());
		    }
	}
}


public class JavaThreadA {
		public static void main(String[] args) throws Exception {
				
				MyThread t1=new MyThread();
				MyThread t2=new MyThread();
				System.out.println(Thread.currentThread().getName()+"的优先度:"+Thread.currentThread().getPriority());
				t1.setPriority(8);
				t2.setPriority(4);
				t1.start();
				t2.start();
				 
		}
}


//------------------------------------------线程操作---------------------------------------------------//

/*
 * 线程操作
 *  A.join:线程加入
 *  B.sleep:线程睡眠
 *  C.yield:线程让步
 *  D.setDaemon:后台进程
 * */

class MyThread extends Thread{
	public void run() {
		for(int x=0;x<3000;x++) {
			System.out.println(Thread.currentThread().getName());
			if(Thread.currentThread().getName().equals("Thread-1")) {
					
					try {
						//Thread.sleep(500); //让Thread-1睡眠
						Thread.yield(); //让其他线程完成后在执行本线程
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
			}
	    }
}
}

public class JavaThreadB {
		public static void main(String[] args) throws Exception {
			MyThread t1=new MyThread();
			MyThread t2=new MyThread();
			MyThread t3=new MyThread();
			t1.start();
			t2.setDaemon(true);//必须在启动前调用
			t2.start();
		   	//t2.join();//让main线程执行完t2后，在执行t3
			t3.start();
			
		}
}

//-----------------------------------多线程安全--------------------------------------------------//

/*
 * 多线程安全
 * 
 * 1.判断依据
 *  a.是否为多线程
 *  b.是否有共享数据
 *  c.是否有多条语句操作共享数据
 *  
 * 2.线程同步
 *  a.同步代码块：synchronized(Object){需要同步的代码块},其锁对象为当前方法的操作共享资源者
 *  b.同步方法:把synchronized修饰方法，可以简单理解成对此方法进行
 *了加锁，其锁对象为当前方法的调用者
 *  c.静态同步方法:把synchronized修饰静态方法,他的锁对象为本类，一旦一个静态同步方法获
 * 取锁后，其他的静态同步方法都必须等待该方法释放锁后才能获取锁，而不管是同一个实例对象
 * 的静态同步方法之间，还是不同的实例对象的静态同步方法之间，只要它们同一个类的实例对象！
 *  d.synchronized关键字是不能继承的，也就是说，基类的方法synchronized f(){} 
 * 在继承类中变成了f(){}。继承类需要你显式的指定它的某个方法为synchronized方法
 * */


//共享类
class Ticket{
	public int num; //共享数据
	public Ticket(int num) {
		this.num=num;
	}
	
}


class MyThread extends Thread{
	public Ticket t=null;
	public int tnum; //需要多少票
	public MyThread(Ticket t,int tnum) {
		super();
		this.t=t;
		this.tnum=tnum;
	}
/*
//同步方法
public synchronized void run() {
		if(t.num>=tnum) {
			System.out.println(Thread.currentThread().getName()+"成功取出"+tnum+"还剩下"+(t.num-=tnum));
		}else {
			System.out.println(Thread.currentThread().getName()+"取出失败"+"还剩下"+t.num);
		}
	}
	
}
*/
	
/*
//同步代码块
public  void run() {
	
	synchronized (t) {
		if(t.num>=tnum) {
			System.out.println(Thread.currentThread().getName()+"成功取出"+tnum+"还剩下"+(t.num-=tnum));
		}else {
			System.out.println(Thread.currentThread().getName()+"取出失败"+"还剩下"+t.num);
		}
	}
	
	}	
*/
	
	
	public  void run() {
			
			if(t.num>=tnum) {
				System.out.println(Thread.currentThread().getName()+"成功取出"+tnum+"还剩下"+(t.num-=tnum));
			}else {
				System.out.println(Thread.currentThread().getName()+"取出失败"+"还剩下"+t.num);
			}
		}	
}

public class JavaThreadC {
		public static void main(String[] args) {
			Ticket t=new Ticket(1000);
			MyThread t1=new MyThread(t, 300);
			MyThread t2=new	MyThread(t,400);
			MyThread t3=new MyThread(t, 500);
			t1.start();
			t2.start();
			t3.start();
			
			/*
			  没有同步措施
			  Thread-0成功取出300还剩下700
			  Thread-1成功取出400还剩下300
			  Thread-2成功取出500还剩下-200
			 */
			
			/*
			使用同步措施
			Thread-0成功取出300还剩下300
			Thread-1成功取出400还剩下600
			Thread-2取出失败还剩下300
			*/
			
		}
}


//--------------------------------------静态同步方法-----------------------------------------------//

//共享类
class Ticket{
	public int num; //共享数据
	public Ticket(int num) {
		this.num=num;
	}
	
}


class MyThread extends Thread{
	public Ticket t=null;
	public int tnum; //需要多少票
	public MyThread(Ticket t,int tnum) {
		super();
		this.t=t;
		this.tnum=tnum;
	}
	//静态同步方法
	public synchronized static void operator(Ticket t,int tnum) {
		if(t.num>=tnum) {
			System.out.println(Thread.currentThread().getName()+"成功取出"+tnum+"还剩下"+(t.num-=tnum));
		}else {
			System.out.println(Thread.currentThread().getName()+"取出失败"+"还剩下"+t.num);
		}
	}
	
	public  void run() {
			operator(t,tnum);
			
	}	
}

public class JavaThreadC {
		public static void main(String[] args) {
			Ticket t=new Ticket(1000);
			MyThread t1=new MyThread(t,300);
			MyThread t2=new	MyThread(t,400);
			MyThread t3=new MyThread(t,500);
			t1.start();
			t2.start();
			t3.start();
			
			/*
			使用同步措施
			Thread-0成功取出300还剩下300
			Thread-1成功取出400还剩下600
			Thread-2取出失败还剩下300
			*/
			
		}
}

//----------------------------------------Lock锁--------------------------------------------------//

/*
 * Lock锁
 *   a.针对线程的锁定操作和释放操作
 *   b.void lock() 获取锁
 *   c.void unlock() 释放锁
 *   d.Boolean tryLock()方法是有返回值的，它表示用来尝试获取锁，如果获取成功，则返
 * 回true，如果获取失败（即锁已被其他线程获取），则返回false，也就说这个方法无论如何
 * 都会立即返回。在拿不到锁时不会一直在那等待。
 * 	
 * */
//共享类
class Ticket{
	public int num; //共享数据
	public Ticket(int num) {
		this.num=num;
	}
	
}

class SellTicket extends Thread{
	
	public Ticket t;
	public Lock lock;
	public int num;
	public SellTicket(Ticket t,int num,Lock lock) {
		this.num=num;
		this.t=t;
		this.lock=lock;
	}
	public void run() {
		
			try {
				lock.lock();	//获取锁
				if(num<=t.num) {
					System.out.println(Thread.currentThread().getName()+"成功取出"+num+"还剩下"+(t.num-=num));
				}else {
					System.out.println(Thread.currentThread().getName()+"取出失败"+"还剩下"+t.num);
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally {
			   lock.unlock();//释放锁
		}
	}
	
}
public class JavaThreadD {
		
		public static void main(String[] args) {
			Ticket t=new Ticket(1000);
			Lock l=new ReentrantLock();//实例化Lock对象
			SellTicket s1=new SellTicket(t,300,l);
			SellTicket s2=new SellTicket(t,400,l);
			SellTicket s3=new SellTicket(t,500,l);
			s1.start();
			s2.start();
			s3.start();
		}
}

//----------------------------------线程间通信-----------------------------------------------//

/*
 * 进程间通信
 * 	Object类方法：
 *  wait()：导致当前线程等待并使其进入到等待阻塞状态
 *	notify()：唤醒在此同步锁对象上等待的单个线程
 *	notifyAll()：唤醒在此同步锁对象上等待的所有线程
 * */

//共享资源
class Student{
	public String name;
	public int age;
	public boolean flag; //标记
}

class GetStu extends Thread{
	
	public Student s;
	public GetStu(Student s) {
		this.s=s;
	}
	
	public void run() {
		synchronized (s) {
			if(!s.flag) {
				try {
					System.out.println(Thread.currentThread().getName()+"即将阻塞...");
					s.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(s.name+"===>"+s.age);
			s.flag=false;
			s.notify();
		}
	}
}

class SetStu extends Thread{
	public Student s;
	public int x;
	public SetStu(Student s,int x) {
		this.s=s;
		this.x=x;
	}
	

	public void run() {
		synchronized (s) {
			if(s.flag) {
				try {
					System.out.println(Thread.currentThread().getName()+"即将阻塞...");
					s.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if(x%2==0) {
				s.name="zhangsan";
				s.age=11;
			}else {
				s.name="lisi";
				s.age=14;
			}
			s.flag=true;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			s.notify();
		}
	}
	
	
}

public class JavaThread {
	
		public static void main(String[] args) {
			Student s11=new Student();
			Student s22=new Student();
			GetStu g1=new GetStu(s11);
			GetStu g2=new GetStu(s22);
			SetStu s1=new SetStu(s11,1);
			SetStu s2=new SetStu(s22,2);
			System.out.println("g1==>"+g1.getName());
			System.out.println("g2==>"+g2.getName());
			System.out.println("s1==>"+s1.getName());
			System.out.println("s2==>"+s2.getName());
			g1.start();
			g2.start();
			s1.start();
			s2.start();
			
			/*
			 * g1==>Thread-0
			 * g2==>Thread-1
			 * s1==>Thread-2
			 * s2==>Thread-3
			 * Thread-0即将阻塞...
			 * Thread-1即将阻塞...
			 * lisi===>14
			 * zhangsan===>11
			 * 
			 * */
			
		}
}


//------------------------------------------线程组--------------------------------------------//

/*
 * 线程组
 * 	a.Java中使用ThreadGroup来表示线程组，它可以对一批线程进行分类管理。
 * 	b.默认线程组（即main线程组）
 * 	c.只有在创建线程时才能指定其所在的线程组，线程运行中途不能改变它所属的线程组，也就是
 * 说线程一旦指定所在的线程组，就直到该线程结束。 	
 *
 * 线程组操作
 * 	ThreadGroup类
 * 		a.ThreadGroup(String name)：以指定线程组名字来创建新线程组
 * 		b.ThreadGroup(ThreadGroup parent,String name)：以指定的名字、指定的父线程组来创建
 * 一个新线程组。
 * 	
 * 	Thread类
 * 		a.Thread(ThreadGroup group,Runnable target)：group属于的线程组，target为新线程
 * 		b.Thread(ThreadGroup group,Runnable target,String name)：group属于的线程组，
 * target为新线程，name：线程名
 * 		c.Thread(ThreadGroup group,String name)：新线程名为name，属于group线程组
 * 		d.ThreadGroup	getThreadGroup() : 返回该线程所属的线程组。
 * 	
 * 线程组错误
 * 		hreadGroup类实现了Thread.UncaughtExceptionHandler接口，所以每个线程所属的线程组将
 * 会作为默认的异常处理器。当一个线程抛出未处理异常时，JVM会首先查找该异常对应的异常处理器处理该
 * 异常；否则，JVM将会调用该线程所属的线程组对象的uncaughtException()方法来处理该异常。 
 * 
 * */

//自定义异常处理器
class MyException implements Thread.UncaughtExceptionHandler{

	public void uncaughtException(Thread t, Throwable e) {
		  System.out.println(t.getName() + " 线程出现了异常：" + e.getMessage());
	}
}


class MyThread extends Thread{
	
	public MyThread(ThreadGroup tg,String name) {
		super(tg,name);
	}
	
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println(this.getName()+"属于："+this.getThreadGroup().getName());
		}
	}
}



public class JavaThreadA {
		public static void main(String[] args) {
			System.out.println(Thread.currentThread().getName()+"属于："+Thread.currentThread().getThreadGroup().getName());
			ThreadGroup tg=new ThreadGroup("wu");//创建一个新进程组
			MyThread t1=new MyThread(tg,"T1");
			t1.setUncaughtExceptionHandler(new MyException());
			MyThread t2=new MyThread(tg,"T2");
			MyThread t3=new MyThread(tg,"T3");
			t1.start();
			t2.start();
			t3.start();
		}
}

