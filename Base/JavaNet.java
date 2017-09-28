/*
 *网络编程
 *
 *	1.InetAddress:表示ip对象,有效端口(两个字节)：0~65535，其中0~1024系统使用或保留端口
 *		 static InetAddress getByName(String host): 在给定主机名的情况下,返回其IP地址对象.
 *		 static InetAddress	getLocalHost():返回本地主机。
 *		 String	getHostName():获取此 IP 地址的主机名。
 *		 String	getHostAddress():返回 IP 地址字符串（以文本表现形式）
 *	
 *	2.TCP编程
 *		a.Socket类代表客户端连接套接字
 *			Socket(InetAddress address, int port): 创建一个流套接字并将其连接到指定 IP 地址的指定端口号。
 *			Socket(String host, int port) :创建一个流套接字并将其连接到指定主机上的指定端口号
 *		 	InputStream	getInputStream(): 返回此套接字的输入流。
 *			OutputStream getOutputStream() :返回此套接字的输出流。
 *			void close():关闭此套接字
 * 
 *		b.ServerSocket类代表服务器端连接套接字
 *		    ServerSocket(int port):创建绑定到特定端口的服务器套接字
 *			Socket accept():侦听并接受到此套接字的连接。一个阻塞方法，其作用是接收数据。
 *			void close():关闭此套接字 
 *
 * 3.UDP编程
 * 		a.DatagramSocket:表示用来发送和接收数据报包的套接字
 * 			DatagramSocket()：构造数据报套接字并将其绑定到本地主机上任何可用的端口。
 * 			DatagramSocket(int port)：创建数据报套接字并将其绑定到本地主机上的指定端口
 * 			void send(DatagramPacket p): 从此套接字发送数据报包。 
 * 			void receive(DatagramPacket p): 从此套接字接收数据报包.一个阻塞方法，其作用是接收数据。
 * 			byte[]	getData():返回数据缓冲区
 * 			int	getLength():返回将要发送或接收到的数据的长度。
 * 			InetAddress	getAddress():返回某台机器的 IP 地址
 * 			int	getPort(): 返回某台远程主机的端口号
 * 			void close():关闭此数据报套接字
 * 		b.DatagramPacket:表示UDP数据报包
 * 			DatagramPacket(byte[] buf, int length, InetAddress address, int port): 构造数据报包，用来将长度为 length 的包发送到指定主机上的指定端口号
 * 			DatagramPacket(byte[] buf, int length) ：构造 DatagramPacket，用来接收长度为 length 的数据包
 * 			 
 * */
public class JavaSocket {

		//InetAddress对象
		@Test
		public void inetAddress() throws Exception {
			
			InetAddress in1=InetAddress.getByName("www.baidu.com");
			System.out.println(in1);
		
			InetAddress in2=InetAddress.getLocalHost();
			System.out.println(in2);
			
			InetAddress in3=InetAddress.getByName("127.0.0.1");
			System.out.println(in3);
			
			System.out.println(in1.getHostName()+"==>"+in1.getHostAddress());
			System.out.println(in2.getHostName()+"==>"+in2.getHostAddress());
			
			/*
			www.baidu.com/61.135.169.121
			ArchLinux/171.34.186.164
			/127.0.0.1
			www.baidu.com==>61.135.169.121
			ArchLinux==>171.34.186.164
			 */
		}
		
		//Socket
		@Test
		public void socket() throws Exception, IOException {
			Socket s=new Socket("127.0.0.1",10000);
			OutputStream out=s.getOutputStream();
			out.write("Hello,I am socket".getBytes());
			InputStream in=s.getInputStream();
			byte[] b=new byte[1024];
			int len=in.read(b);
			System.out.println("服务端："+new String(b,0,len));
			in.close();
			out.close();
			s.close();
			
			/*
			客户端：Hello,I am socket
			 */
		}
		
		//ServerSocket
		@Test
		public void serverSocket() throws Exception {
			ServerSocket s=new ServerSocket(10000);
			Socket ss=s.accept();
			InputStream in=ss.getInputStream();
			byte[] b=new byte[1024];
			int len=in.read(b);
			System.out.println("客户端："+new String(b,0,len));
			OutputStream out=ss.getOutputStream();
			out.write("Hi,I am ServerSocket".getBytes());
			out.close();
			in.close();
			ss.close();
			s.close();
			/*
			 服务端：Hi,I am ServerSocket
			 */
		}
		
		
		//多线程ServerSocket
		@Test
		public void serverSockets() {
			ServerSocket s=null;
			try {
				s = new ServerSocket(10000);
				while(true) {
					Socket ss=s.accept();
					new MyThread(ss).start();
			 }
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}
		
		//UDP客户端
		@Test
		public void UDP1() throws Exception {
			DatagramSocket ds=new DatagramSocket(); 	//初始化UDP套接字（随机）
			String s="Hello,我是客户端"+new Date();		 //发送的数据
			DatagramPacket dp1=new DatagramPacket(s.getBytes(), s.getBytes().length,InetAddress.getLocalHost(),10000);//构建UDP数据包（数据与接受方的信息）
			ds.send(dp1);//发送数据包
			byte[] b=new byte[1024];//接受的字节缓存
			DatagramPacket dp2=new DatagramPacket(b, b.length);//初始化接受的UDP数据包
			ds.receive(dp2);//接受UDP数据包
			System.out.println(new String(dp2.getData(),0,dp2.getLength()));//读取数据
			ds.close();//关闭套接字
		}
		
		//UDP服务端
		@Test
		public void UDP2() throws Exception {
			DatagramSocket ds=new DatagramSocket(10000); 	//初始化UDP套接字（指定监听端口）
			byte[] b=new byte[1024];//接受的字节缓存
			DatagramPacket dp1=new DatagramPacket(b, b.length);//初始化接受的UDP数据包
			ds.receive(dp1);//接受UDP数据包
			System.out.println(new String(dp1.getData(),0,dp1.getLength()));//读取数据
			String s="Hello,我是服务端"+new Date();		 //发送的数据
			DatagramPacket dp2=new DatagramPacket(s.getBytes(), s.getBytes().length,dp1.getAddress(),dp1.getPort());//构建UDP数据包（数据与接受方的信息）
			ds.send(dp2);//发送数据包
			ds.close();//关闭套接字
		}
		
		
}


/*
 * 服务器支持多线程链接
 * */
//线程方法
class MyThread extends Thread{
	public Socket s;	
	public MyThread(Socket s) {
		this.s=s;
	}
	
	
	public void run() {
		try{
				InputStream in=s.getInputStream();
				byte[] b=new byte[1024];
				int len=in.read(b);
				System.out.println("客户端："+new String(b,0,len));
				OutputStream out=s.getOutputStream();
				String ss=Thread.currentThread().getName()+"：Hello ,I am Server";
				out.write(ss.getBytes());
				out.close();
				in.close();
				s.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}	
