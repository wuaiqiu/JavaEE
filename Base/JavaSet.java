package Base;

/*
 * 集合
 * 	  (1)集合与数组：
 * 		a.长度区别：数组固定；集合可变。
 *   		b.内容区别：数组可以是基本数据类型，也可以是引用类型；集合只能是引用类型。
 *   		c.元素区别：数组只能存储同一类型；集合可以存储不同类型
 * */

public class JavaSet {


//-----------------------------------------------Iterator-----------------------------------------------------//

		/*
		 * 迭代器（Iterator）迭代器是一种设计模式,它可以遍历并选择序列中的对象。
		 * 
		 *  (1) 使用iterator()要求容器返回一个Iterator。注意：iterator()方法是java.lang.Iterable
		 * 接口,被Collection继承。
		 *  (2) 使用Object next()获得当前位置的元素在指向下一个元素。
		 *  (3) 使用Boolean hasNext()检查当前序列中是否还有元素。
		 * 
		 * */



//--------------------------------------------------Collection---------------------------------------------------//
	
		/*
		 * List : Collection的子接口
		 * 		有序，可重复
		 * 		ArrayList  底层结构为线性表，查询快，增删慢，线程不安全
		 * 		LinkedList 底层结构为双向循环链表，查询慢，增删快，线程不安全
		 * 		Vector 	   底层结构为线性表，查询快，增删慢，线程安全
		 * 
		 * Set : Collection的子接口
		 * 		无序，唯一
		 * 		HashSet    底层结构是哈希表，继承HashMap的key，value为固定值，哈希表底层依赖两个方法hashCode()和equals()
		 * 		TreeSet	   底层结构是红黑树，继承TreeMap的key，value为固定值，红黑树底层利用Comparator进行定位
		 **/
	


	/*
	 * ArrayList
	 *  a.如果在初始化ArrayList的时候没有指定初始化长度的话，默认的长度为10.
	 *  b.ArrayList在增加新元素的时候如果超过了原始的容量的话，ArrayList扩容ensureCapacity的方案为“原始容量*3/2+1"
	 *  c.ArrayList是线程不安全的，在多线程的情况下不要使用   
	 * */
	@Test
	public void arrayList() {
		
	     //实现ArrayList遍历
	     ArrayList<String> list=new ArrayList<String>();
	     list.add("a");
	     list.add("b");
	     list.add("c");
	     
	    //第一种:foreach
	     for(String i:list) {
	    	 System.out.println(i);
	     }
	     
	     //第二种:Iterator
	     Iterator<String> it=list.iterator();
	     while(it.hasNext()) {
	    	 System.out.println(it.next());
	     }
	}
	
	

	
	/*
	 * LinkedList
	 * 
	 * */
	@Test
	public void linkedList() {
		//LinkedList遍历
		LinkedList<String> link=new LinkedList<String>();
		link.add("a");
		link.add("b");
		link.add("c");
		
		//第一种:foreach
		for(String p:link) {
			System.out.println(p);
		}
		
		//第二种:Iterator
		Iterator<String> it=link.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}


	/*
	 * HashSet
	 * 	a.HashSet中存储元素的位置是固定的;由于HashSet底层是基于Hash算法实现的，使用
	 * 了hashcode，所以HashSet中相应的元素的位置是固定的。
	 * 
	 * */
		@Test
		public void hashSet() {
			
			//hashSet遍历
			HashSet<String> hs=new HashSet<String>();
			hs.add("a");
			hs.add("b");
			hs.add("c");
			
			//第一种:foreach
			for(String p:hs) {
				System.out.println(p);
			}
			
			//第二种:Iterator
			Iterator<String> it=hs.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		}
		



		/*
		 * TreeSet
		 * */
		@Test
		public void treeSet() {
			//TreeSet遍历
			TreeSet<String> ts=new TreeSet<String>();
			ts.add("a");
			ts.add("c");
			ts.add("d");
			
			//第一种:foreach
			for(String p:ts) {
				System.out.println(p);
			}
			
			//第二种:Iterator
			Iterator<String> it=ts.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		}




//--------------------------------------Map----------------------------------------------//
	
/*
 * Map
 * 	a.Map接口实现的是一组Key-Value的键值对的组合
 * 	b.在Map接口的集合中也不能有重复的key出现
 * 
 * HashMap:Map的实现类
 * 	a.基于hash数组实现，若key的hash值相同则使用链表方式进行保存。
 * 	b.新建一个HashMap时,默认的话会初始化一个大小为16(最大容量)，负载因子为0.75的空的HashMap
 * 	   实际容量 = 最大容量  * 负载因子，如果最大容量不变的情况下增大负载因子，当然可
 * 	   以增加实际容量，如果负载因子大了会增加哈希冲突发生的概率
 * 
 * TreeMap:Map的实现类
 * 	a.基于红黑树实现
 * 	
 * */

		
		//HashMap
		@Test
		public void hashMap() {
			//HashMap遍历
			
			HashMap<String,String> hm=new HashMap<String,String>();
			hm.put("a", "A");
			hm.put("b", "B");
			hm.put("c", "C");
			
			//第一种:foreach entrySet(),效率高,返回此映射所包含的映射关系的 Set 视图。
			for(Entry<String,String> entry:hm.entrySet()) {
				System.out.println(entry.getKey()+"==>"+entry.getValue());
			}
			
			//第二种:foreach keySet(),返回此映射中所包含的键的 Set 视图。
			for(String key:hm.keySet()) {
				System.out.println(key+"==>"+hm.get(key));
			}
			
			//第三种：Iterator entrySet(),效率高
			Iterator<HashMap.Entry<String,String>> it=hm.entrySet().iterator();
			while(it.hasNext()) {
				HashMap.Entry<String,String> entry=it.next();
				System.out.println(entry.getKey()+"==>"+entry.getValue());
			}
			
			//第四种：Iterator keySet()
			Iterator<String> it1=hm.keySet().iterator();
			while(it1.hasNext()) {
				String key=it1.next();
				System.out.println(key+"==>"+hm.get(key));
			}
		}



		
		//TreeMap
		@Test
		public void treeMap() {
			//TreeMap遍历
			TreeMap<String,String> tm=new TreeMap<String,String>();
			tm.put("a", "A");
			tm.put("b", "B");
			tm.put("c","C");
			
			//第一种:foreach entrySet(),效率高,返回此映射所包含的映射关系的 Set 视图
			for(Entry<String,String> entry:tm.entrySet()) {
				System.out.println(entry.getKey()+"==>"+entry.getValue());
			}
			
			//第二种:foreach keySet()
			for(String key:tm.keySet()) {
				System.out.println(key+"==>"+tm.get(key));
			}
			
			//第三种：Iterator entrySet(),效率高,返回此映射中所包含的键的 Set 视图。
			Iterator<HashMap.Entry<String,String>> it=tm.entrySet().iterator();
			while(it.hasNext()) {
				HashMap.Entry<String,String> entry=it.next();
				System.out.println(entry.getKey()+"==>"+entry.getValue());
			}
			
			//第四种：Iterator keySet()
			Iterator<String> it1=tm.keySet().iterator();
			while(it1.hasNext()) {
				String key=it1.next();
				System.out.println(key+"==>"+tm.get(key));
			}
		}
		


//---------------------------------------HashMap的内部实现-----------------------------------------//

/*
 * HashMap的内部实现
 * 	a.执行顺序：首先比较哈希值是否相同，相同继续执行equals()方法，返回true，元素重复
 * 不添加，返回false添加到集合
 * 	b.hashCode()方法被用来获取给定对象的唯一整数。默认的，Object类的hashCode()方法返
 * 回这个对象存储的内存地址的编号。
 * */


class Person{
	public int id;
	public String name;
	public Person(int id,String name) {
		this.id=id;
		this.name=name;
	}
	
	//覆盖hashCode()函数
	public int hashCode() {
		final int p=31;
		return p*(this.id)+p;
	}
	
	//覆盖equals函数
	public boolean equals(Object obj) {
		 if(obj == null||getClass()!=obj.getClass()){
	           return false;
	     }
	      if (obj == this){
	           return true;
	      }
	
	      Person e = (Person) obj;
	     return (this.id == e.id);
		
	}
}

public class JavaHash {

	public static void main(String[] args) {
			Person p1=new Person(1,"zhangsan");
			Person p2=new Person(1,"zhangsan");
			HashSet<Person> hs=new HashSet<Person>();
			hs.add(p1);
			hs.add(p2);
			System.out.println(hs);
	}

	//before==>[Person@d3ae4123,Person@k3d122sk]
	//after==>[Person@3e]
}



//----------------------------------TreeMap的内部实现---------------------------------//

/*
 * TreeMap的内部实现
 * 	a.自然排序，让元素所属类实现comparable接口
 * 	b.比较器排序，让集合构造方法接收comparator接口的实现类对象
 *	c.如果该对象小于、等于或大于指定对象，则分别返回负整数、零或正整数。
 * */


//1.自然排序
class Person implements Comparable{
	public int id;
	public String name;
	public Person(int id,String name) {
		this.id=id;
		this.name=name;
	}
	
	//覆盖compareTo方法
	public int compareTo(Object o) {
		Person p=(Person)o;
		if(p.id>this.id) {
			return -1;
		}else if(p.id==this.id) {
			return this.name.compareTo(p.name);
		}else {
			return 1;
		}
	}
	
}

public class JavaTree {
		public static void main(String[] args) {
			Person p1=new Person(1,"zhangsan");
			Person p2=new Person(1,"lisi");
			TreeSet<Person> ts=new TreeSet<Person>();
			ts.add(p1);
			ts.add(p2);
			System.out.println(ts);
		}
}

//before==>报错
//after==>[Person@15db9742, Person@6d06d69c]




//2.比较器比较，采用匿名内部类

class Person{
	public int id;
	public String name;
	public Person(int id,String name) {
		this.id=id;
		this.name=name;
	}

	
}

public class JavaTree {
		public static void main(String[] args) {
			Person p1=new Person(1,"zhangsan");
			Person p2=new Person(1,"lisi");
			TreeSet<Person> ts=new TreeSet<Person>(new Comparator<Person>() {
				public int compare(Person o1, Person o2) {
					if(o1.id>o2.id) {
						return 1;
					}else if(o1.id==o2.id) {
						return o1.name.compareTo(o2.name);
					}else {
						return -1;
					}
				}
				
			});
			ts.add(p1);
			ts.add(p2);
			System.out.println(ts);
		}
}

//before==>报错
//after==>[Person@15db9742, Person@6d06d69c]



}
