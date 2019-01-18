package simpleLogin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import simpleLogin.view.LoginView;

public class LoginController extends WindowAdapter implements ActionListener, MouseListener {

	private LoginView lv;
	
	public LoginController(LoginView lv) {
		this.lv = lv;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == lv.getJbLogin() || ae.getSource() == lv.getJtfId()
				|| ae.getSource() == lv.getJpfPass()) {
			
		}
		if (ae.getSource() == lv.getJbSignUp()) {
			
		}
	}
	
	@Override
	public void windowClosing(WindowEvent we) {
		lv.dispose();
	}

	@Override
	public void mouseClicked(MouseEvent me) {
		if (me.getSource() == lv.getJlForgotPass()) {
			
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
