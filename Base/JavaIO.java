package day18;

//-----------------------------------------------------I/O流-------------------------------------------//
/*
 * I/O流
 * 	1.字节流
 * 		输入流：InputStream（基类，抽象类）
 * 		a.FileInputStream
 * 			FileInputStream(File file) : 创建文件输入流
 * 			int	read() ： 从此输入流中读取一个数据字节，返回ascii码，如果已到达文件末尾，则返回 -1
 * 			int	read(byte[] b)：从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中，返回读取到的字节数
 * 			int	read(byte[] b, int off, int len)： 从此输入流中将最多 len 个字节的数据读入一个 byte 数组中,返回读取到的字节数
 * 			void close()：关闭输入流 
 *  		b.BufferedInputStream,能够减少访问磁盘的次数，提高文件读取性能
 *  			BufferedInputStream(InputStream in) : 默认缓冲区大小
 *  			BufferedInputStream(InputStream in, int size) ：指定缓冲区大小
 *  			int	read()
 *  			int	read(byte[] b)
 *  			void close()
 *  		c.DataInputStream,数据输入流，操作java基本数据类型
 *  			DataInputStream(InputStream in)：创建数据输入流
 *  			boolean	readBoolean()
 *  			byte readByte()
 *  			...   
 * 		输出流：OutputStream（基类，抽象类）
 * 			a.FileOutputStream
 *				FileOutputStream(File file)：创建文件输出流
 * 				FileOutputStream(File file, boolean append) ：创建文件输出流（append为true，则追加）
 * 				void write(byte[] b)： 将 b.length 个字节从指定 byte 数组写入此文件输出流中
 * 				void write(byte[] b, int off, int len)：将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流
 * 				void write(int b)：将单个字节（ascii码）写入此文件输出流
 * 				void close()：关闭输出流  
 * 			b.BufferedOutputStream,能够减少访问磁盘的次数，提高文件读取性能
 * 				BufferedOutputStream(OutputStream out) : 默认缓冲区大小
 * 				BufferedOutputStream(OutputStream out, int size) : 指定缓冲区大小
 * 				void write(byte[] b)
 * 				void write(int b)
 * 			　　 void close()
 * 			c.DataOutputStream,数据输出流，操作java基本数据类型
 * 				DataOutputStream(OutputStream out):创建数据输出流
 * 				void writeBoolean(boolean v)
 * 				void writeByte(int v) 
 * 				...
 * 			d.PrintStream,向字节输出流打印对象的格式化表示形式
 * 				PrintStream(File file) ：创建打印流，不具有自动行刷新
 * 				PrintStream(File file, String csn) ：指定字符集，不具有自动行刷新
 * 				PrintStream(OutputStream out) 
 * 				PrintStream(OutputStream out, boolean autoFlush)：在调用 println、printf 
 *  			或 format 的其中一个方法时才可能完成此操作
 * 				PrintStream	append(CharSequence csq) ：将指定的字符序列添加到此 writer ,String 继承于CharSequence，也就是说String也是CharSequence类型。
 *  				void print(String s)： 打印字符串
 *  				void println(String s): 打印 String，然后换行
 *  		 		PrintStream	format(String format, Object... args) :格式化输出
 *  				PrintStream	printf(String format, Object... args) ：格式化输出 
 * 				 
 * 				
 * 
 *  2.字符流（字节转换流）
 *  	输入流：Reader（基类，抽象类）
 *  		a.InputStreamReader
 *  			InputStreamReader(InputStream in) : 默认编码
 *  			InputStreamReader(InputStream in, Charset cs) : 指定编码
 *  			int	read()：读取单个字符,如果已到达流的末尾，则返回 -1
 *  			int	read(char[] cbuf, int offset, int length) : 将字符读入数组中的某一部分,返回字符长度
 *  			void close() : 关闭输入流 
 *  		b.BufferedReader,能够减少访问磁盘的次数，提高文件读取性能
 *  			BufferedReader(Reader in) : 默认缓冲区大小
 *  			BufferedReader(Reader in, int sz) ： 指定缓冲区大小
 *  			int	read()
 *  			int	read(char[] cbuf)
 *  			String	readLine() : 读取一个文本行
 *  			void close()
 *  		c.FileReader，用来读取字符文件的便捷类，默认编码，默认字符
 *  			FileReader(File file) 
 *  				  
 *  	输出流：Write（基类，抽象类）
 *  		a.OutputStreamWriter
 *  			OutputStreamWriter(OutputStream out) : 默认编码
 *  			OutputStreamWriter(OutputStream out, Charset cs) : 指定编码
 *  			void write(char[] cbuf, int off, int len)　:  写入字符数组的某一部分
 *  			void write(int c) :  写入单个字符
 *  			void write(String str, int off, int len) : 写入字符串的某一部分
 *  			void close() : 关闭此流 
 *  	  	b.BufferedWriter,能够减少访问磁盘的次数，提高文件读取性能
 *  			BufferedWriter(Writer out) : 默认缓冲区大小
 *  			BufferedWriter(Writer out, int sz) : 指定缓冲区大小
 *  			void write(char[] cbuf)
 *  			void write(int c)
 *  			void write(String str)
 *  			void close()
 *  		c.FileWriter,用来写入字符文件的便捷类,默认编码，默认字符
 *  			FileWriter(File file) 
 *  			FileWriter(File file, boolean append) 
 *  		d.PrintWriter，向文本输出流打印对象的格式化表示形式
 *  			PrintWriter(File file) ：创建打印流，不具有自动行刷新
 *  			PrintWriter(File file, String csn) ：指定字符集，不具有自动行刷新
 *  			PrintWriter(OutputStream out)
 *  			PrintWriter(OutputStream out, boolean autoFlush) :在调用 println、printf 
 *  			或 format 的其中一个方法时才可能完成此操作
 *  			PrintWriter	append(CharSequence csq)：将指定的字符序列添加到此 writer ,String 继承于CharSequence，也就是说String也是CharSequence类型。
 *  			void print(String s)： 打印字符串
 *  			void println(String s): 打印 String，然后换行
 *  		 	PrintWriter	format(String format, Object... args) :格式化输出
 *  			PrintWriter	printf(String format, Object... args) ：格式化输出 
 *  			 
 * */

/*
 * File类构造方法
 * 	File(String path)
 * 	File(String parent, String child) 
 * 	File(File parent, String child) 
 * */

/*
 * System静态字段
 * 		static PrintStream err ：“标准”错误输出流
 * 		static InputStream	in ：“标准”输入流
 * 		static PrintStream	out ：“标准”输出流
 * */


/*
 * Scanner
 * 	Scanner是Java5的新特征，主要功能是简化文本扫描。这个类最实用的地方表现在获取控制台输入
 * 		Scanner(File source):默认字符集
 * 		Scanner(File source, String charsetName)：指定字符集
 * 		Scanner(InputStream source) 
 * 		Scanner(InputStream source, String charsetName) 
 * 		boolean	hasNext()
 * 		String next()
 * 		boolean	hasNextLine() 
 * 		String nextLine()
 * 		Scanner	useDelimiter(String pattern)：设置分隔符，默认为空格与换行符
 * 		void close() 
 * */
public class JavaIO {
	
		//写入文件
		@Test
		public void wFile() throws Exception {
			FileOutputStream out=new FileOutputStream(new File("welcome.txt"));
			String s="this is welcome";
			byte[] b=s.getBytes();
			//in.write((int)'a');
			out.write(b);
			out.close();
		}
		
		
		//读入文件
		@Test
		public void rFile() throws Exception {
				FileInputStream in=new FileInputStream(new File("welcome.txt"));
			/*
				int a=0;
				while((a=in.read())!=-1) {
					System.out.print((char)a);
				}
			*/
				byte[] by=new byte[1024];
				int len=0;
				while((len=in.read(by))!=-1) {
					System.out.println(new String(by,0,len));
				}
				in.close();
		}
		
		
		//写入缓冲字节
		@Test
		public void wBufferFile() throws Exception {
				BufferedOutputStream bout=new BufferedOutputStream(new FileOutputStream(new File("bwelcome.txt")));
				String str="hello world";
				byte[] by=str.getBytes();
				bout.write(by);
				bout.close();
		}
		
		
		//读入缓冲字节
		@Test
		public void rBufferFile() throws Exception {
			BufferedInputStream bin=new BufferedInputStream(new FileInputStream(new File("bwelcome.txt")));
			int b=0;
			while((b=bin.read())!=-1) {
				System.out.print((char)b);
			}
			bin.close();
		}
		
		
		//写入字符
		@Test
		public void wChar() throws Exception {
			OutputStreamWriter out=new OutputStreamWriter(new FileOutputStream(new File("hello.txt")));
			String str="这是hel文件";
		/*
			char[] ch=str.toCharArray();
			out.write(ch);
		*/
			out.write(str);
			out.close();
		}
		
		
		//读入字符
		@Test
		public void rChar() throws Exception {
			InputStreamReader in=new InputStreamReader(new FileInputStream(new File("hello.txt")));
			/*
			int b=0;
			while((b=in.read())!=-1) {
				System.out.print((char)b);
			}
			*/
			char[] ch=new char[1024];
			int len=0;
			while((len=in.read(ch))!=-1) {
				System.out.println(new String(ch,0,len));
			}
			in.close();
			
		}
		

		//写入缓冲字符
		@Test
		public void wBufferChar() throws Exception {
			BufferedWriter bout=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("bhello.txt"))));
			String str="这是hello文件";
			bout.write(str);
			bout.close();
		}
		

		//读入缓冲字符
		@Test
		public void rBufferChar() throws Exception {
			BufferedReader bin=new BufferedReader(new InputStreamReader(new FileInputStream(new File("bhello.txt"))));
			char[] ch=new char[1024];
			int len=0;
			while((len=bin.read(ch))!=-1) {
				System.out.println(new String(ch,0,len));
			}
			bin.close();
		}
		
		
		//数据输出流
		@Test
		public void wData() throws Exception {
			DataOutputStream dout=new DataOutputStream(new FileOutputStream(new File("data.txt")));
			dout.writeChars("世界");
			dout.writeUTF("世界");
			dout.close();
		}
		

		//数据输入流,注意顺序
		@Test
		public void rData() throws Exception {
			DataInputStream din=new DataInputStream(new FileInputStream(new File("data.txt")));
			
			
			//首先读入4字节的char
			char[] c=new char[2];
			c[0]=din.readChar();
			c[1]=din.readChar();
			System.out.println("char:"+new String(c));
			
			//在读入6字节的utf-8
			System.out.println("utf:"+din.readUTF());	
			
			din.close();
		}
		

		//打印字节流
		@Test
		public void pBStream() throws Exception {
			PrintStream pw=new PrintStream(new FileOutputStream(new File("printb.txt")),true);
			pw.write("hello".getBytes());
			pw.append("我是");
			pw.println("java");
			pw.print("ee");
			pw.printf("\nhello world%d",3);
			pw.close();
		}
	

		//打印字符流
		@Test
		public void pStream() throws Exception {
			PrintWriter pw=new PrintWriter(new FileOutputStream(new File("print.txt")),true);
			pw.write("hello");
			pw.append("我是");
			pw.println("java");
			pw.print("ee");
			pw.printf("\nhello world%d",3);
			pw.close();
		
		}
		

		//Scanner读取文件
		@Test
		public void scanner() throws Exception {
			Scanner s=new Scanner(new FileInputStream(new File("print.txt")));
			s.useDelimiter("\n");
			while(s.hasNext()) {
				System.out.println(s.next()); 
			}
			s.close();
		}
		

		//Scanner读取输入台
		@Test
		public void scanner2() {
			Scanner s=new Scanner(System.in);
			while(true) {
				String line=s.next();
				if(line.equals("exit"))break;
				System.out.println(">>"+line);
			}
		}
		
}
