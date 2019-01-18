package simpleLogin.view;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import simpleLogin.controller.UserController;

@SuppressWarnings("serial")
public class UserView extends JFrame {
	
	private DefaultTableModel dtmUser;

	public UserView() {
		super("유저 목록");
		
		String[] columnNames = { "아이디", "비밀번호", "연락처", "이메일", "주민번호", "주소", "질문타입", "질문 답" };
		dtmUser = new DefaultTableModel(columnNames, 3) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		JTable jt = new JTable(dtmUser);
		JScrollPane jsp = new JScrollPane(jt);
		
		add(jsp);
		
		UserController uc = new UserController(this);
		addWindowListener(uc);
		
		setBounds(400, 300, 900, 400);
		setResizable(false);
		setVisible(true);
	}

	public DefaultTableModel getDtmUser() {
		return dtmUser;
	}
}
