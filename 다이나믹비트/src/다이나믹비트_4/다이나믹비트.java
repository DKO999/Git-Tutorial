package 다이나믹비트_4;

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

public class 다이나믹비트 extends JFrame{ //JFrame그래픽기반 라이브러리 
	
	private Image screenImage;//더블버퍼링을 위해서 전체화면에 대한 이미지를 담는 
	private Graphics screenGraphic;//더블버퍼링을 위해서 전체화면에 대한 이미지를 담는 
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	
	private Image introBackground = new ImageIcon(Main.class.getResource("../images/intrBackground.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png"))); //메뉴바라는 객체 안에 해당 이미지가 들어간 형태로 자리잡게됨
	
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	
	private int mouseX, mouseY;//프로그램 안에서 마우스의 x와 y 좌표 그 자체를 의미
	
	public 다이나믹비트() {
		setUndecorated(true);//실행했을떄 기본적으로 존재하는 메뉴바가 보이지 않게됨
		setTitle("다이나믹 비트");//게임의 이름
		setSize(Main.SCTEEN_WIDTH, Main.SCTEEN_HEIGHT);//전체 게임창을 설정
		setResizable(false);//한번 만들어진 게임창은 사용자가 인위적으로 조절할 수 없다
		setLocationRelativeTo(null);//실행했을떄 사용자 화면의 정중앙에 뜨게함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//게임창을 종료했을떄 게임 전체가 종료
		setVisible(true);//게임창이 사용자 화면에 정삭적으로 출력됨
		setBackground(new Color(0, 0, 0, 0));//paintComponents(g)를 했을떄 배경이 회색이 아니라 흰색으로 바뀌게 됨
		setLayout(null);
		
		exitButton.setBounds(1245, 0, 30, 30);//메뉴바에 가장 오른쪽에 위치하게 됨
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {// 마우스가 해당 버튼 위에 올라왔을떄 이벤트
				exitButton.setIcon(exitButtonEnteredImage);//그림을 바꿔줌
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR ));//해당 버튼위에 마우스가 올라갔을떄는 손가락 모양으로 바뀜
				Music buttonEnteredMusic = new Music("bbb.mp3", false);//한번만 음악이 실행되게 함
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {//해당 버튼에서 마우스가 나왔을떄 이벤트
				exitButton.setIcon(exitButtonBasicImage);	
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR ));//해당버튼에서 마우스가 나왔을떄는 원래 상태로 돌아옴
			}
			@Override
			public void mousePressed(MouseEvent e) {//버튼을 클릭했을떄 이벤트
				Music buttonEnteredMusic = new Music("ttt.mp3", false);//한번만 음악이 실행되게 함
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);//소리가 나온 뒤 1초정도 있다가 프로그램이 종료되기 떄문에 정상적으로 소리를 
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);//클릭했을 떄는 해당프로그램이 종료
			}
		});		
		add(exitButton);
		
		menuBar.setBounds(0, 0, 1280, 30);//위치랑 크기를 정해줌
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {// 마우스를 해당 버튼을 눌렀을떄 나오는 이벤트처리
				mouseX = e.getX();//위에 이벤트가 발생했을떄 x좌표를 얻어 온다
				mouseY = e.getY();//위에 이벤트가 발생했을떄 y좌표를 얻어 온다
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {//드래그 이벤트가 발생했을떄 내용
				int x = e.getXOnScreen();//스크린에 x좌표를 가져옴
				int y = e.getYOnScreen();//스크린에 y좌표를 가져옴
				setLocation(x - mouseX, y-mouseY);//드래그 할떄 그 순간마다 x좌표와 y좌표를 얻어와서 자동으로 현재 제이프레임 즉 게임창의 위치를 바꿔줌/한바디로 누군가 메뉴바를 드래그 했을떄 자동으로 이벤트 처리를 해줌
				
			}
		});
		add(menuBar);//JFrame에 메뉴바가 추가됨(paintComponents(g)를 통해서 그려짐)		
		
		Music DDD = new Music("DDD.MP3", true);
		DDD.start();
	}
	
	public void paint(Graphics g) {//paint란 하나에 약속된 메소드
		screenImage = createImage(Main.SCTEEN_WIDTH, Main.SCTEEN_HEIGHT);//전체너비,높이 만큼의 이미지를 만들어준 뒤 screenImage에 넣어줌
		screenGraphic = screenImage.getGraphics();//screenImage를 이용해서 그래픽 객체를 얻어온다
		screenDraw(screenGraphic);//screenDraw에서 screenGraphic에 어떠한 그림을 그려줌
		g.drawImage(screenImage, 0, 0, null);//스크린 이미지를 0,0 위치에 그려준다 즉 게임창에 screenImage가 그려짐
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);//introBackground를 전체이미지 즉 screenImage에 그려줄 수 있도록 함
		paintComponents(g);//간단하게 고정된 이미지 즉 메뉴바 같은것들은 paintComponents(g);로 구현할것임
		this.repaint();//전체화면 이미지를 매 순간마다 프로그램이 종료되는 순간까지 계속 반복되며 그려짐
	}

}
