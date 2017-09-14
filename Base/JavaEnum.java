package Base;


/*
 * 枚举
 * 		枚举的本质是类，枚举屏蔽了枚举值的类型信息，不像在用public static final定义变量必须指定类型。
 * 		枚举是用来构建常量数据结构的模板，枚举的使用增强了程序的健壮性，比如在引用一个不存在的枚举值的时候，编译器会报错
 * */
public class JavaEnum {
	
		/*
		 * name():返回枚举名称
		 * ordinal():枚举下标，从0开始
		 * valueOf(String name):将字符串转换为枚举对象
		 * values():获取所有枚举对象数组
		 * */
	
	//枚举对象 => 枚举名称，枚举下标
	Color c1=Color.RED;
	String name1=c1.name();
	int id1=c1.ordinal();
	
	//枚举名称 => 枚举对象，枚举下标
	String name2="GREEN";
	Color c2=Color.valueOf("GREEN");
	int id2=c2.ordinal();
	
	//枚举下标 => 枚举对象，枚举名称
	int id3=2;
	Color c3=Color.values()[id3];
	String name3=c3.name();
	
	
		
}

//普通枚举类
enum Color{
		RED,GREEN,BLACK;
}

//枚举类的本质
enum ColorT{
	
	RED("红色",1),GREEN("绿色",2),BLACK("黑色",3);
    
	private String name ;
    private int index ;
     
    private ColorT( String name , int index ){
        this.name = name ;
        this.index = index ;
    }
     
    public String getName() {
        return name;
    }
   
    public int getIndex() {
        return index;
    }
    
}