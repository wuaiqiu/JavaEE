package day7;

import java.util.ArrayList;
import java.util.List;

/*
 *组合模式
 *		用于把一组相似的对象当作一个单一的对象。组合模式依据树形结构来组合对象，用来表示部分以及整体
 *层次
 *		
 *优点
 *		1、高层模块调用简单。 
 *		2、节点自由增加。
 * */

class Employee{
	private String name;
	private int salary;
	List<Employee> list;
	
	public Employee(String name,int salary) {
		list=new ArrayList<Employee>();
		this.name=name;
		this.salary=salary;
	}
	
	public void add(Employee e) {
		list.add(e);
	}
	
	public void remove(Employee e) {
		list.remove(e);
	}
	
	public List<Employee> get(){
		return list;
	}
	
	@Override
	public String toString() {
		
		return "Employee[ name:"+this.name+"  salary:"+this.salary+" ]";
	}
}


public class CompositePattern {
			public static void main(String[] args) {
				Employee CEO=new Employee("zhangsan", 10000);
				Employee managerA=new Employee("lisi",5000);
				Employee managerB=new Employee("wangwu", 5000);
				Employee workA=new Employee("eason",1000);
				Employee workB=new Employee("jay",1000);
				Employee workC=new Employee("leehom",1000);
				Employee workD=new Employee("john",1000);
				CEO.add(managerA);
				CEO.add(managerB);
				managerA.add(workA);
				managerA.add(workB);
				managerB.add(workC);
				managerB.add(workD);
				System.out.println(CEO);
				for(Employee e:CEO.get()) {
					System.out.println(e);
					for(Employee f:e.get()) {
						System.out.println(f);
					}
				}
			}
}
