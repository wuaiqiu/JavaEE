package day1;

import java.util.ArrayList;
import java.util.List;

/*
 *过滤器模式
 *	 使用不同的标准来过滤一组对象，通过逻辑运算以解耦的方式把它们连接起来
 * */

//需要过滤的类
class Person{
	private String name;
	private int age;
	private String country;
	
	public Person(String name,int age,String country) {
		this.name=name;
		this.age=age;
		this.country=country;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getCountry() {
		return country;
	}
}

//过滤接口
interface Filter{
	List<Person> filter(List<Person> persons);
}

//过滤接口实现类CountryFilter(国籍过滤-->CN)
class CountryFilter implements Filter{
	public List<Person> filter(List<Person> persons) {
		List<Person> p = new ArrayList<Person>(); 
	      for (Person person : persons) {
	         if(person.getCountry().equalsIgnoreCase("CN")){
	            p.add(person);
	         }
	      }
	      return p;
	}
}

//过滤接口实现类AgeFilter(年龄过滤-->20)
class AgeFilter implements Filter{
	public List<Person> filter(List<Person> persons) {
		List<Person> p = new ArrayList<Person>(); 
	      for (Person person : persons) {
	         if(person.getAge()>20){
	            p.add(person);
	         }
	      }
	      return p;
	}
}

//过滤组合AndFilter
class AndFilter implements Filter{
	private Filter AFilter;
	private Filter BFilter;
	public AndFilter(Filter AFilter,Filter BFilter) {
		this.AFilter=AFilter;
		this.BFilter=BFilter;
	}
	
	@Override
	public List<Person> filter(List<Person> persons) {
		List<Person> A = AFilter.filter(persons);        
	    return BFilter.filter(A);
	}
}


public class FilterPattern {
			public static void main(String[] args) {
				List<Person> persons=new ArrayList<Person>();
				persons.add(new Person("zhangsan",19,"CN"));
				persons.add(new Person("lisi",20,"EN"));
				persons.add(new Person("wangwu",30,"CN"));
				persons.add(new Person("eason",25,"XG"));
				persons.add(new Person("jay",19,"TW"));
				persons.add(new Person("leehom",20,"CN"));
				Filter F1=new CountryFilter();
				F1.filter(persons);
				Filter F2=new AgeFilter();
				F2.filter(persons);
				Filter F3=new AndFilter(F1,F2);
				F3.filter(persons);	
			}
}
