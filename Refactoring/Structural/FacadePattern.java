package day7;

/*
 * 外观模式
 * 		隐藏系统的复杂性，并向客户端提供了一个客户端可以访问系统的接口。
 * 
 * 优点
 * 		 1、减少系统相互依赖。 
 * 		 2、提高灵活性。 
 * 		 3、提高了安全性。
 * 
 * 缺点
 * 		不符合开闭原则，如果要改东西很麻烦，继承重写都不合适。
 * */

interface Person{
	void run();
}

class Student implements Person{
	@Override
	public void run() {
		System.out.println("This is Student");
	}
}

class Teacher implements Person{
	@Override
	public void run() {
		System.out.println("This is Teacher");
	}
}

//外观类
class FacadePerson{
	private Person stu;
	private Person tea;
	public FacadePerson() {
		stu=new Student();
		tea=new Teacher();
	}
	
	public void StuRun() {
		stu.run();
	}
	
	public void TeaRun() {
		tea.run();
	}
}


public class FacadePattern {
		public static void main(String[] args) {
			FacadePerson fp=new FacadePerson();
			fp.StuRun();
			fp.TeaRun();
			
		}
}
