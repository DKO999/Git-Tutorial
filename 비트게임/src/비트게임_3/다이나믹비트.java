package 비트게임_3;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import 비트게임_1.Main;

public class 다이나믹비트 extends JFrame{
	
	private Image screenImage; //더블버퍼링을 위해서  전체화면에 대한 이미지를 담는 기술
	private Graphics screenGraphic; //더블버퍼링을 위해서  전체화면에 대한 이미지를 담는
	
	private Image introBackground;//추가한 이미지를 담을 수 있는 객체
	
	public 다이나믹비트() {
		setTitle("다이나믹 비트"); //게임의 이름
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //전체게임의 창을 설정
		setResizable(false); //만들어진 게임의 창은 사용자가 인위적으로 조절할 수 없음
		setLocationRelativeTo(null);//실행했을떄 게임의 창이 사용자 컴퓨터 정 중앙에 나옴
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//게임창을 종료했을떄 게임 전체가 종료함
		setVisible(true);//게임창이 정상적으로 출력되게 해줌
		
		introBackground = new ImageIcon(Main.class.getResource("../images/intrBackground.jpg")).getImage(); //이미지 파일을 introBackground라는 이미지 변수에다가 초기화 해주겠다
		
		Music RRT = new Music("../music/RRT.mp3﻿", true); // 시작화면에서 음악이 무한정 반복되서 재생되게 함
		RRT.start();// 정상적으로 게임이 실행됨가 동시에 시작화면에 introMusic이 실행됨	
		
	}
	
	public void paint(Graphics g) { //약속된 매서드
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);//화면크기를 만들고 screenImage에 넣어주겠다
		screenGraphic = screenImage.getGraphics();// screenImage를 이용해서 그래픽 객체를 얻어옴
		screenDraw(screenGraphic);//screenDraw를 이용해서 screenGraphic에 어떠한 그래픽을 그려줌
		g.drawImage(screenImage, 0, 0, null);// 스크린 이미지를 0,0에 위치에 그려준다/ 화면즉 게임창에 screenImage가 그려짐
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null); // introBackground 전체이미지 즉 screenImage에 그려줄 수 있도록 함/introBackground를 0,0에 그려줌
		this.repaint(); // 전체화면 이미지를 매 순간마다 프로그램이 종료될떄까지 반복되면서 왔다갔다 하면서 그려주는것
	}

}
