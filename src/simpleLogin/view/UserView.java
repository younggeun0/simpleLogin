package simpleLogin.view;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserView extends JFrame {
	
	private DefaultTableModel dtmUser;

	public UserView() {
		super("���� ���");
		
		String[] columnNames = { "�̸�", "����ó", "�̸���", "�ֹι�ȣ", "�ּ�", "����Ÿ��", "���� ��" };
		dtmUser = new DefaultTableModel(columnNames, 3);
		JTable jt = new JTable(dtmUser);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
