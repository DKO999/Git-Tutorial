package 비트게임_3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	
	private Player player; // java mp3 라이브러리
	private boolean isLoop; // isLoop 이변수는 곡이 무한반복인지 한번 재생후 꺼지는지 정하는 설정
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) { // 생성자 만들고 곡의 제목과 해당 곡이 무한반복인지 그 여부를 입력받는다
		try { 
			this.isLoop = isLoop;//초기화
			file = new File(Main.class.getResource("../music" + name).toURI()); // 파일을 가져올수 있도록 한다/music이라는 폴더 안에있는 해당 이름의 파일을 실행시킴 toURI()로 해당 파일의 위치를 가져옴
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);// 해당 파일을 버퍼에 담아서 읽어올 수 있도록 함
			player = new Player(bis);// Player는 해당 파일을 담을 수 있게 함			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {// 현재 실행되고 있는 그 음악이 현재 어떤 위치에 실행되고 있는지 알려줌
		if(player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close() {//close란 함수는 음악이 언제 실행되고 있던 항상 종료될 수 있도록 함
		isLoop = false;
		player.close();
		this.interrupt();//해당 쓰레드를 중지상태로 만듬
		
	}
	
	@Override
	public void run() {//쓰레드를 상속 받으면 무조건 써야하는 함수
		try { 
			do {
				player.play(); // 곡을 실행시킴
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis); 
			}while(isLoop);	// isLoop가 true라면 무한반복		
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
