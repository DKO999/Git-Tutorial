package ��Ʈ����_3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	
	private Player player; // java mp3 ���̺귯��
	private boolean isLoop; // isLoop �̺����� ���� ���ѹݺ����� �ѹ� ����� �������� ���ϴ� ����
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) { // ������ ����� ���� ����� �ش� ���� ���ѹݺ����� �� ���θ� �Է¹޴´�
		try { 
			this.isLoop = isLoop;//�ʱ�ȭ
			file = new File(Main.class.getResource("../music" + name).toURI()); // ������ �����ü� �ֵ��� �Ѵ�/music�̶�� ���� �ȿ��ִ� �ش� �̸��� ������ �����Ŵ toURI()�� �ش� ������ ��ġ�� ������
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);// �ش� ������ ���ۿ� ��Ƽ� �о�� �� �ֵ��� ��
			player = new Player(bis);// Player�� �ش� ������ ���� �� �ְ� ��			
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public int getTime() {// ���� ����ǰ� �ִ� �� ������ ���� � ��ġ�� ����ǰ� �ִ��� �˷���
		if(player == null)
			return 0;
		return player.getPosition();
	}
	
	public void close() {//close�� �Լ��� ������ ���� ����ǰ� �ִ� �׻� ����� �� �ֵ��� ��
		isLoop = false;
		player.close();
		this.interrupt();//�ش� �����带 �������·� ����
		
	}
	
	@Override
	public void run() {//�����带 ��� ������ ������ ����ϴ� �Լ�
		try { 
			do {
				player.play(); // ���� �����Ŵ
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis); 
			}while(isLoop);	// isLoop�� true��� ���ѹݺ�		
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
