package day9;

/*
 * 迭代器模式
 * 		用于顺序访问聚合类的元素，不需要知道聚合类的底层表示。
 * 
 * 优点
 * 		1、它支持以不同的方式遍历一个聚合类。 
 * 		2、迭代器简化了聚合类。 
 * 		3、在同一个聚合上可以有多个遍历。 
 * 		4、在迭代器模式中，增加新的聚合类和迭代器类都很方便，无须修改原有代码。
 * 
 * 缺点
 * 		由于迭代器模式将存储数据和遍历数据的职责分离，增加新的聚合类需要对应增加新的迭代器类，
 * 类的个数成对增加，这在一定程度上增加了系统的复杂性。
 * */

//迭代器类接口
interface Iterator{
	boolean hasNext();
	Object next();
}

//聚合类接口
interface Container{
	Iterator getIterator();
}


//聚合类实现类
class ObjectSet implements Container{
	private String names[] = {"Robert" , "John" ,"Julie" , "Lora"};//聚合对象
	
	@Override
	public Iterator getIterator() {
		return new ObjectIterator();
	}
	
	//迭代器内部实现类
	private class ObjectIterator implements Iterator{
		int index=0;
		@Override
		public boolean hasNext() {
			if(index<names.length) {
				return true;
			}
			return false;
		}

		@Override
		public Object next() {
			if(this.hasNext()) {
				return names[index++];
			}
			return null;
		}
	}
}


public class IteratorPattern {
		public static void main(String[] args) {
			Container set=new ObjectSet();
			Iterator it=set.getIterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		}
}
