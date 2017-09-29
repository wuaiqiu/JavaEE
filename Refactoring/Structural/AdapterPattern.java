package day3;

/*
 *适配器模式
 *	作为两个不兼容的接口之间的桥梁
 *
 * 优点：
 * 		1、可以让任何两个没有关联的类一起运行。 
 * 		2、提高了类的复用。 
 * 		3、增加了类的透明度。 
 * 		4、灵活性好。
 * 
 * 缺点：
 * 		1、过多地使用适配器，会让系统非常零乱，不易整体进行把握。
 * */

//高级媒体播放器接口
interface AdvanceMedia{
	void playVlc(String fileName);
	void playMp4(String fileName);
}

//AdvanceMedia实现类Vlc
class Vlc implements AdvanceMedia{
	@Override
	public void playVlc(String fileName) {
		System.out.println("Vlc开始播放"+fileName);
	}

	@Override
	public void playMp4(String fileName) {}
}

//AdvanceMedia实现类Mp4
class Mp4 implements AdvanceMedia{
	@Override
	public void playVlc(String fileName) {}

	@Override
	public void playMp4(String fileName) {
		System.out.println("Mp4开始播放"+fileName);
	}
}

//媒体播放器接口
interface MediaPlayer{
	void play(String type,String fileName);
}

//媒体播放器的适配器Adapter
class MediaPlayerAdapter implements MediaPlayer{
	AdvanceMedia am;
	public MediaPlayerAdapter(String type) {
		if(type.equalsIgnoreCase("vlc")) {
			am=new Vlc();
		}else if(type.equalsIgnoreCase("mp4")) {
			am=new Mp4();
		}else {
			am=null;
		}
	}

	@Override
	public void play(String type, String fileName) {
		if(type.equalsIgnoreCase("vlc")) {
			am.playVlc(fileName);
		}else if(type.equalsIgnoreCase("mp4")) {
			am.playMp4(fileName);
		}else {
			System.out.println("无法识别"+type);
		}
	}
}

//媒体播放器实现类
class MiMedia implements MediaPlayer{
	@Override
	public void play(String type, String fileName) {
		if(type.equalsIgnoreCase("mp3")) {
			System.out.println("正在播放"+fileName);
		}else {
			new MediaPlayerAdapter(type).play(type, fileName);
		}	
	}
}



public class AdapterPattern {
		public static void main(String[] args) {
			MiMedia m=new MiMedia();
			m.play("mp3", "无条件");
			m.play("vlc", "你的名字");
			m.play("mp4", "声之形");
		}
}
