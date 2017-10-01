package day4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

/*
 * Date
 * 		Date():实例化Date对象
 * 		boolean after(Date date):如果调用Date对象包含或晚于指定的日期则返回true，否则，返回false。
 * 		boolean before(Date date):如果调用Date对象包含或早于日期指定的日期返回true，否则，返回false。
 * 		int compareTo(Date date):比较日期的调用对象的值。如果这两个值相等返回0。如果调用对象是早于日期返
 * 		回一个负值。如果调用对象最迟日期返回正值。
 * 		boolean equals(Object date):如果调用Date对象包含相同的时间及日期指定日期则返回true，否则，返回false。
 * 
 * 
 * SimpleDateFormat:日期格式化；DateFormat的实现类类
 * 		SimpleDateFormat(String pattern)：用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat。
 *	  			y-->年	M-->月	d-->日	E-->星期
 *				H-->小时	m-->分钟	s-->秒数
 *		Date parse(String text):解析字符串的文本，生成 Date
 *		String format(Date date)：格式化日期
 * 	
 * 
 * DateFormat:抽象类
 * 		static DateFormat getDateTimeInstance(int dateStyle, int timeStyle): 获取日期/时间格式器
 * 		static DateFormat getTimeInstance(int style):获取时间格式器
 * 		static DateFormat getDateInstance(int style):获取日期格式器
 * 			DateFormat.SHORT-->17-10-1(上午8:27)
 * 			DateFormat.MEDIUM-->2017-10-1(8:28:39)
 * 			DateFormat.LONG-->2017年10月1日(上午08时29分30秒)
 * 			DateFormat.FULL-->2017年10月1日 星期日(上午08时30分28秒 CST)
 * 		String format(Date date):将一个 Date 格式化为日期/时间字符串。	
 * 
 * 
 * System:用于测量时间
 * 		static long	currentTimeMillis():返回以毫秒为单位的当前时间。
 * 
 * GregorianCalendar:Calendar的实现类
 * 		GregorianCalendar():构造使用【当前时间】的默认时区与默认语言环境。
 * 		GregorianCalendar(int year, int month, int date):用【给定的日期】的默认时区设置默认的语言环境。
 * 		GregorianCalendar(int year, int month, int date, int hour, int minute, int second):用【给定的日期和时间设置】为与默认语言环境的默认时区。
 * 		int get(int field)：获取给定时间域的值.(0-11)
 * 			Calendar.YEAR-->年	Calendar.MONTH-->月(0-11)	Claendar.DAY_OF_MONTH-->日	
 * 			Calendar.DAY_OF_WEEK-->星期 	
 * 			Calendar.HOUR-->时	Calendar.MINUTE-->分	Calendar.SECOND-->秒 	
 * 		void set(int field, int value)：设置时间字段与给定值.
 * 		
 * Calendar：
 * 	 	static Calendar	getInstance():使用默认时区和语言环境获得一个日历。
 * 		int	get(int field):返回给定日历字段的值
 * 		
 * */

public class JavaDate {
		
		@Test
		public void simpleDateFormat() throws Exception {
			Date d=new Date();
			DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String s=df.format(d);
			System.out.println(s);
			Date date=df.parse(s);
			System.out.println(date);
		}
	
		@Test
		public void dateFormat() {
			Date d=new Date();
			DateFormat df=DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL);
			System.out.println(df.format(d));
		}
		
		@Test
		public void gregorianCalendar() {
			Calendar c=new GregorianCalendar();
			System.out.println(c.get(Calendar.YEAR)+"-"+c.get(Calendar.MONTH)+"-"+c.get(Calendar.DAY_OF_MONTH)+" "+c.get(Calendar.WEEK_OF_MONTH));
			System.out.println(c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND));
		}
			
}
