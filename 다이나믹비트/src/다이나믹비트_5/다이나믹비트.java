package ���̳��ͺ�Ʈ_5;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ���̳��ͺ�Ʈ extends JFrame{ //JFrame�׷��ȱ�� ���̺귯�� 
	
	private Image screenImage;//������۸��� ���ؼ� ��üȭ�鿡 ���� �̹����� ��� 
	private Graphics screenGraphic;//������۸��� ���ؼ� ��üȭ�鿡 ���� �̹����� ��� 
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/intrBackground.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png"))); //�޴��ٶ�� ��ü �ȿ� �ش� �̹����� �� ���·� �ڸ���Ե�
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	
	private int mouseX, mouseY;//���α׷� �ȿ��� ���콺�� x�� y ��ǥ �� ��ü�� �ǹ�
	
	public ���̳��ͺ�Ʈ() {
		setUndecorated(true);//���������� �⺻������ �����ϴ� �޴��ٰ� ������ �ʰԵ�
		setTitle("���̳��� ��Ʈ");//������ �̸�
		setSize(Main.SCTEEN_WIDTH, Main.SCTEEN_HEIGHT);//��ü ����â�� ����
		setResizable(false);//�ѹ� ������� ����â�� ����ڰ� ���������� ������ �� ����
		setLocationRelativeTo(null);//���������� ����� ȭ���� ���߾ӿ� �߰���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����â�� ���������� ���� ��ü�� ����
		setVisible(true);//����â�� ����� ȭ�鿡 ���������� ��µ�
		setBackground(new Color(0, 0, 0, 0));//paintComponents(g)�� ������ ����� ȸ���� �ƴ϶� ������� �ٲ�� ��
		setLayout(null);
		
		exitButton.setBounds(1245, 0, 30, 30);//�޴��ٿ� ���� �����ʿ� ��ġ�ϰ� ��
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {// ���콺�� �ش� ��ư ���� �ö������ �̺�Ʈ
				exitButton.setIcon(exitButtonEnteredImage);//�׸��� �ٲ���
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR ));//�ش� ��ư���� ���콺�� �ö������� �հ��� ������� �ٲ�
				Music buttonEnteredMusic = new Music("bbb.mp3", false);//�ѹ��� ������ ����ǰ� ��
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {//�ش� ��ư���� ���콺�� �������� �̺�Ʈ
				exitButton.setIcon(exitButtonBasicImage);	
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR ));//�ش��ư���� ���콺�� ���������� ���� ���·� ���ƿ�
			}
			@Override
			public void mousePressed(MouseEvent e) {//��ư�� Ŭ�������� �̺�Ʈ
				Music buttonEnteredMusic = new Music("ttt.mp3", false);//�ѹ��� ������ ����ǰ� ��
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);//�Ҹ��� ���� �� 1������ �ִٰ� ���α׷��� ����Ǳ� ������ ���������� �Ҹ��� 
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);//Ŭ������ ���� �ش����α׷��� ����
			}
		});		
		add(exitButton);
		
		startButton.setBounds(40, 200, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {// ���콺�� �ش� ��ư ���� �ö������ �̺�Ʈ
				startButton.setIcon(startButtonEnteredImage);//�׸��� �ٲ���
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR ));//�ش� ��ư���� ���콺�� �ö������� �հ��� ������� �ٲ�
				Music buttonEnteredMusic = new Music("bbb.mp3", false);//�ѹ��� ������ ����ǰ� ��
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {//�ش� ��ư���� ���콺�� �������� �̺�Ʈ
				startButton.setIcon(startButtonBasicImage);	
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR ));//�ش��ư���� ���콺�� ���������� ���� ���·� ���ƿ�
			}
			@Override
			public void mousePressed(MouseEvent e) {//��ư�� Ŭ�������� �̺�Ʈ
				Music buttonEnteredMusic = new Music("ttt.mp3", false);//�ѹ��� ������ ����ǰ� ��
				buttonEnteredMusic.start();
				//���ӽ��� �̺�Ʈ
			}
		});		
		add(startButton);
		
		quitButton.setBounds(40, 330, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {// ���콺�� �ش� ��ư ���� �ö������ �̺�Ʈ
				quitButton.setIcon(quitButtonEnteredImage);//�׸��� �ٲ���
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR ));//�ش� ��ư���� ���콺�� �ö������� �հ��� ������� �ٲ�
				Music buttonEnteredMusic = new Music("bbb.mp3", false);//�ѹ��� ������ ����ǰ� ��
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {//�ش� ��ư���� ���콺�� �������� �̺�Ʈ
				quitButton.setIcon(quitButtonBasicImage);	
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR ));//�ش��ư���� ���콺�� ���������� ���� ���·� ���ƿ�
			}
			@Override
			public void mousePressed(MouseEvent e) {//��ư�� Ŭ�������� �̺�Ʈ
				Music buttonEnteredMusic = new Music("ttt.mp3", false);//�ѹ��� ������ ����ǰ� ��
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);//�Ҹ��� ���� �� 1������ �ִٰ� ���α׷��� ����Ǳ� ������ ���������� �Ҹ��� 
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);//Ŭ������ ���� �ش����α׷��� ����
			}
		});		
		add(startButton);
		
		menuBar.setBounds(0, 0, 1280, 30);//��ġ�� ũ�⸦ ������
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {// ���콺�� �ش� ��ư�� �������� ������ �̺�Ʈó��
				mouseX = e.getX();//���� �̺�Ʈ�� �߻������� x��ǥ�� ��� �´�
				mouseY = e.getY();//���� �̺�Ʈ�� �߻������� y��ǥ�� ��� �´�
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {//�巡�� �̺�Ʈ�� �߻������� ����
				int x = e.getXOnScreen();//��ũ���� x��ǥ�� ������
				int y = e.getYOnScreen();//��ũ���� y��ǥ�� ������
				setLocation(x - mouseX, y-mouseY);//�巡�� �ҋ� �� �������� x��ǥ�� y��ǥ�� ���ͼ� �ڵ����� ���� ���������� �� ����â�� ��ġ�� �ٲ���/�ѹٵ�� ������ �޴��ٸ� �巡�� ������ �ڵ����� �̺�Ʈ ó���� ����
				
			}
		});
		add(menuBar);//JFrame�� �޴��ٰ� �߰���(paintComponents(g)�� ���ؼ� �׷���)		
		
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
		paintComponents(g);//�����ϰ� ������ �̹��� �� �޴��� �����͵��� paintComponents(g);�� �����Ұ���
		this.repaint();//��üȭ�� �̹����� �� �������� ���α׷��� ����Ǵ� �������� ��� �ݺ��Ǹ� �׷���
	}

}
