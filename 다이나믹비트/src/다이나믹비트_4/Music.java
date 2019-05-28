package ���̳��ͺ�Ʈ_4;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	private Player player; 
	private boolean isLoop;//isLoop�̶� ������ ���� ���� ���� �ݺ����� �ѹ��� ����ϰ� �������� Ȯ���ϴ� ����
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/" +name).toURI());//music�̶�� �����ȿ� �ִ� �ش��̸��� ������ �����Ŵ/toURI()�� �ش� ������ ��ġ�� ������ �� �ְ���
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);//�ش� ������ ���ۿ� ��Ƽ� �о�� �� �ֵ��� ��
			player = new Player(bis);//�ش������� ���� �� �ְ���
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {//getTime()�� ���� ����ǰ� �ִ� �� ������ � ��ġ���� ����ǰ� �ִ��� �˷���
		if(player == null)
		return 0;
		return player.getPosition();
	}
	
	public void close() {//close�� ������ ���� ����ǰ� �ִ� �׻� ������ �� �ְ� ���ִ� �Լ�
		isLoop = false;
		player.close();
		this.interrupt();//interrupt�� �ش� �����带 ���� ���·� ����/�� ����Ǵ� ���Ӱ� ������ ���� ������ִ� ���� ���α׷��� ���� �����ϰ� �� ���α׷��� �������ִ°��� interrupt
	}
	@Override
	public void run() {// run �̰� �������� �Լ��� ������ ������ ����ؾ� �ϴ� �Լ�
		try {
			do {
				player.play();//���� �����Ŵ
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			}while(isLoop);//isLoop��� ������ trun���̶�� ���ѹݺ�
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
