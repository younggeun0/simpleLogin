package simpleLogin.view;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserView extends JFrame {
	
	private DefaultTableModel dtmUser;

	public UserView() {
		super("유저 목록");
		
		String[] columnNames = { "이름", "연락처", "이메일", "주민번호", "주소", "질문타입", "질문 답" };
		dtmUser = new DefaultTableModel(columnNames, 3);
		JTable jt = new JTable(dtmUser);
		
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
