package 다이나믹비트_1;

import javax.swing.JFrame;

public class 다이나믹비트 extends JFrame{ //JFrame그래픽기반 라이브러리 
	
	public 다이나믹비트() {
		setTitle("다이나믹비트");//게임의 이름
		setSize(Main.SCTEEN_WIDTH, Main.SCTEEN_HEIGHT);//전체 게임창을 설정
		setResizable(false);//한번 만들어진 게임창은 사용자가 인위적으로 조절할 수 없다
		setLocationRelativeTo(null);//실행했을떄 사용자 화면의 정중앙에 뜨게함
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//게임창을 종료했을떄 게임 전체가 종료
		setVisible(true);//게임창이 사용자 화면에 정삭적으로 출력됨
	}

}
