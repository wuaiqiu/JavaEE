/*
 * 对象复制
 * 		
 * 	浅克隆：只需要克隆的类实现cloneable接口，并重写clone方法，若里面有引用对象，不会实现克隆
 * 		
 *  深克隆：不仅实现cloneable接口，重写clone方法，里面的引用对象同样实现clone;基本数据类型与String能自动实现深度clone
 * 
 * */

//浅克隆
class Face{}

//深克隆
class Head implements Cloneable{
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Person implements Cloneable{
		private Face face;
		private Head head;
		public Person(Face face,Head head) {
			this.face=face;
			this.head=head;
		}
		
		public Face getFace() {
			return face;
		}
		public Head getHead() {
			return head;
		}
		@Override
		protected Object clone() throws CloneNotSupportedException {
				Person p=(Person)super.clone();
				p.head=(Head) head.clone();
				return p;	
		}		
}

public class JavaClone {
		
	
		@Test
		public void cloneTest() throws Exception {
			Person p=new Person(new Face(),new Head());
			Person p1=(Person)p.clone();
			System.out.println(p==p1);
			System.out.println(p.getFace()==p1.getFace());//浅克隆，直接赋值引用地址
			System.out.println(p.getHead()==p1.getHead());//深克隆，分配一个与原对象相同的内存空间
		
			/*
			 * false
			 * true
			 * false
			 * */
			
		}
}