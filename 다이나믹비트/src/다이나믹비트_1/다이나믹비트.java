package ���̳��ͺ�Ʈ_1;

import javax.swing.JFrame;

public class ���̳��ͺ�Ʈ extends JFrame{ //JFrame�׷��ȱ�� ���̺귯�� 
	
	public ���̳��ͺ�Ʈ() {
		setTitle("���̳��ͺ�Ʈ");//������ �̸�
		setSize(Main.SCTEEN_WIDTH, Main.SCTEEN_HEIGHT);//��ü ����â�� ����
		setResizable(false);//�ѹ� ������� ����â�� ����ڰ� ���������� ������ �� ����
		setLocationRelativeTo(null);//���������� ����� ȭ���� ���߾ӿ� �߰���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����â�� ���������� ���� ��ü�� ����
		setVisible(true);//����â�� ����� ȭ�鿡 ���������� ��µ�
	}

}
