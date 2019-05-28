package 다이나믹비트_2;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class 다이나믹비트 extends JFrame{ //JFrame그래픽기반 라이브러리 
	
	private Image screenImage;//더블버퍼링을 위해서 전체화면에 대한 이미지를 담는 
	private Graphics screenGraphic;//더블버퍼링을 위해서 전체화면에 대한 이미지를 담는 
	
	private Image introBackground; //가져왔던 이미지 intrBackground.jpg를 담을 수 있는 객체
		
	public 다이나믹비트() {
		setTitle("다이나믹비트");//게임의 이름
		setSize(Main.SCTEEN_WIDTH, Main.SCTEEN_HEIGHT);//전체 게임창을 설정
		setResizable(false);//한번 만들어진 게임창은 사용자가 인위적으로 조절할 수 없다
		setLocationRelativeTo(null);//실행했을떄 사용자 화면의 정중앙에 뜨게함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//게임창을 종료했을떄 게임 전체가 종료
		setVisible(true);//게임창이 사용자 화면에 정삭적으로 출력됨
		
		introBackground = new ImageIcon(Main.class.getResource("../images/intrBackground.jpg")).getImage();
		//메인클래스의 위치를 기반으로 해서  intrBackground.jpg라는 이미지 파일을 얻어온 뒤에 그것에 이미지 인스턴스를 
		//introBackground라는 Image 변수에다가 introBackground이렇게 초기화를 해줌
		//처음엔 오류가 났는데 ../../이렇게 수정하니 잘 된다 왜그럴까??
	}
	
	public void paint(Graphics g) {//paint란 하나에 약속된 메소드
		screenImage = createImage(Main.SCTEEN_WIDTH, Main.SCTEEN_HEIGHT);//전체너비,높이 만큼의 이미지를 만들어준 뒤 screenImage에 넣어줌
		screenGraphic = screenImage.getGraphics();//screenImage를 이용해서 그래픽 객체를 얻어온다
		screenDraw(screenGraphic);//screenDraw에서 screenGraphic에 어떠한 그림을 그려줌
		g.drawImage(screenImage, 0, 0, null);//스크린 이미지를 0,0 위치에 그려준다 즉 게임창에 screenImage가 그려짐
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);//introBackground를 전체이미지 즉 screenImage에 그려줄 수 있도록 함
		this.repaint();//전체화면 이미지를 매 순간마다 프로그램이 종료되는 순간까지 계속 반복되며 그려짐
	}

}
