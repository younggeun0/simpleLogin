package simpleLogin.controller;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import simpleLogin.dao.LoginDAO;
import simpleLogin.view.FindPasswordView;
import simpleLogin.view.LoginView;
import simpleLogin.view.SignUpView;
import simpleLogin.view.UserView;
import simpleLogin.vo.LoginVO;

public class LoginController extends WindowAdapter implements ActionListener, MouseListener {

	private LoginView lv;
	
	public LoginController(LoginView lv) {
		this.lv = lv;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == lv.getJbLogin() || ae.getSource() == lv.getJtfId()
				|| ae.getSource() == lv.getJpfPass()) {
			
			if (lv.getJtfId().getText().trim().equals("")) {
				showMessageDialog(lv, "아이디 입력은 필수입니다.");
				lv.getJtfId().setText("");
				lv.getJtfId().requestFocus();
				return;
			}
			
			if (new String(lv.getJpfPass().getPassword()).equals("")) {
				showMessageDialog(lv, "비밀번호 입력은 필수입니다.");
				lv.getJpfPass().setText("");
				lv.getJpfPass().requestFocus();
				return;
			}
			
			String id = lv.getJtfId().getText().trim();
			String pass = new String(lv.getJpfPass().getPassword());
			
			try {
				if(LoginDAO.getInstance().login(new LoginVO(id, pass))) {
					new UserView();
				} else {
					showMessageDialog(lv, "입력정보가 틀립니다. 다시 입력해주세요.");
					lv.getJtfId().setText("");
					lv.getJpfPass().setText("");
					lv.getJtfId().requestFocus();
				}
			} catch (SQLException se) {
				showMessageDialog(lv, "DB에서 문제 발생");
				se.printStackTrace();
			}
		}
		if (ae.getSource() == lv.getJbSignUp()) {
			new SignUpView(lv);
		}
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		lv.dispose();
	}
	
	@Override
	public void windowClosed(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		if (me.getSource() == lv.getJlForgotPass()) {
			new FindPasswordView(lv);
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
}
