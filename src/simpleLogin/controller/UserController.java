package simpleLogin.controller;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import simpleLogin.dao.LoginDAO;
import simpleLogin.view.UserView;
import simpleLogin.vo.UserInfoVO;

public class UserController extends WindowAdapter implements Runnable {

	private UserView uv;
	private Thread userLoadThread;
	
	public UserController(UserView uv) {
		this.uv = uv;
		userLoadThread = new Thread(this);
		userLoadThread.start();
	}
	
	@Override
	public void run() {
		while(true) {
			loadUser();
		}
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		uv.dispose();
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0);
	}
	
	private void loadUser() {
		DefaultTableModel dtm = uv.getDtmUser();
		
		try {
			List<UserInfoVO> list = LoginDAO.getInstance().selectAllUser();

			if (!list.isEmpty() ) {
				dtm.setRowCount(0);
			}
			
			UserInfoVO uivo = null;
			Object[] rowData = null;
			for(int i=0; i<list.size(); i++) {
				uivo = list.get(i);
				
				rowData = new Object[8];
				rowData[0] = uivo.getId();
				rowData[1] = uivo.getPassword();
				rowData[2] = uivo.getTel();
				rowData[3] = uivo.getEmail();
				rowData[4] = uivo.getSsn();
				rowData[5] = uivo.getAddress();
				rowData[6] = uivo.getQuestion();
				rowData[7] = uivo.getAnswer();
				
				dtm.addRow(rowData);
			}
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(uv, "DB에 문제 발생");
			e.printStackTrace();
		}
	}
}
