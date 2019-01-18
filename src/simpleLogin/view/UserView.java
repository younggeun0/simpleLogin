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
		super("���� ���");
		
		String[] columnNames = { "���̵�", "��й�ȣ", "����ó", "�̸���", "�ֹι�ȣ", "�ּ�", "����Ÿ��", "���� ��" };
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
