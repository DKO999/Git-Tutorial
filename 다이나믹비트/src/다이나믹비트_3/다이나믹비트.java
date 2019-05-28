package ���̳��ͺ�Ʈ_3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ���̳��ͺ�Ʈ extends JFrame{ //JFrame�׷��ȱ�� ���̺귯�� 
	
	private Image screenImage;//������۸��� ���ؼ� ��üȭ�鿡 ���� �̹����� ��� 
	private Graphics screenGraphic;//������۸��� ���ؼ� ��üȭ�鿡 ���� �̹����� ��� 
	
	private Image introBackground; //�����Դ� �̹��� intrBackground.jpg�� ���� �� �ִ� ��ü
		
	public ���̳��ͺ�Ʈ() {
		setTitle("���̳��� ��Ʈ");//������ �̸�
		setSize(Main.SCTEEN_WIDTH, Main.SCTEEN_HEIGHT);//��ü ����â�� ����
		setResizable(false);//�ѹ� ������� ����â�� ����ڰ� ���������� ������ �� ����
		setLocationRelativeTo(null);//���������� ����� ȭ���� ���߾ӿ� �߰���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����â�� ���������� ���� ��ü�� ����
		setVisible(true);//����â�� ����� ȭ�鿡 ���������� ��µ�
		
		introBackground = new ImageIcon(Main.class.getResource("../images/intrBackground.jpg")).getImage();
		//����Ŭ������ ��ġ�� ������� �ؼ�  intrBackground.jpg��� �̹��� ������ ���� �ڿ� �װͿ� �̹��� �ν��Ͻ��� 
		//introBackground��� Image �������ٰ� introBackground�̷��� �ʱ�ȭ�� ����
		//ó���� ������ ���µ� ../../�̷��� �����ϴ� �� �ȴ� �ֱ׷���??
		
		Music DDD = new Music("DDD.MP3", true);
		DDD.start();
	}
	
	public void paint(Graphics g) {//paint�� �ϳ��� ��ӵ� �޼ҵ�
		screenImage = createImage(Main.SCTEEN_WIDTH, Main.SCTEEN_HEIGHT);//��ü�ʺ�,���� ��ŭ�� �̹����� ������� �� screenImage�� �־���
		screenGraphic = screenImage.getGraphics();//screenImage�� �̿��ؼ� �׷��� ��ü�� ���´�
		screenDraw(screenGraphic);//screenDraw���� screenGraphic�� ��� �׸��� �׷���
		g.drawImage(screenImage, 0, 0, null);//��ũ�� �̹����� 0,0 ��ġ�� �׷��ش� �� ����â�� screenImage�� �׷���
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);//introBackground�� ��ü�̹��� �� screenImage�� �׷��� �� �ֵ��� ��
		this.repaint();//��üȭ�� �̹����� �� �������� ���α׷��� ����Ǵ� �������� ��� �ݺ��Ǹ� �׷���
	}

}
