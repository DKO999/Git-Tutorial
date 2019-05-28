package 다이나믹비트_4;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	private Player player; 
	private boolean isLoop;//isLoop이란 변수는 현재 곡이 무한 반복인지 한번만 재생하고 꺼지는지 확인하는 설정
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/" +name).toURI());//music이라는 폴더안에 있는 해당이름의 파일을 실행시킴/toURI()로 해당 파일의 위치를 가져올 수 있게함
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);//해당 파일을 버퍼에 담아서 읽어올 수 있도록 함
			player = new Player(bis);//해당파일을 담을 수 있게함
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {//getTime()은 현재 실행되고 있는 그 음악이 어떤 위치에서 실행되고 있는지 알려줌
		if(player == null)
		return 0;
		return player.getPosition();
	}
	
	public void close() {//close는 음악이 언제 실행되고 있던 항상 종료할 수 있게 해주는 함수
		isLoop = false;
		player.close();
		this.interrupt();//interrupt는 해당 쓰레드를 중지 상태로 만듬/즉 실행되는 게임과 별도로 곡을 재생해주는 작은 프로그램이 따로 존재하고 그 프로그램을 종료해주는것이 interrupt
	}
	@Override
	public void run() {// run 이건 쓰레드라는 함수를 받으면 무조건 사용해야 하는 함수
		try {
			do {
				player.play();//곡을 실행시킴
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}while(isLoop);//isLoop라는 변수가 trun값이라면 무한반복
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
