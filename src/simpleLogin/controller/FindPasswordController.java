package simpleLogin.controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import simpleLogin.dao.LoginDAO;
import simpleLogin.view.FindPasswordView;
import simpleLogin.view.LoginView;
import simpleLogin.view.SetPasswordView;

public class FindPasswordController extends WindowAdapter implements ActionListener{

	private FindPasswordView fpv;
	private LoginView lv;
	
	public FindPasswordController(FindPasswordView fpv, LoginView lv) {
		this.fpv = fpv;
		this.lv = lv;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == fpv.getJbValidate() ||
				e.getSource() == fpv.getJtfId() ||
				e.getSource() == fpv.getJtfAnswer()) {
			
			String id = fpv.getJtfId().getText().trim();
			String answer = fpv.getJtfAnswer().getText().trim();
			
			if (id.equals("")) {
				JOptionPane.showMessageDialog(fpv, "아이디를 입력해주세요.");
				fpv.getJtfId().requestFocus();
				return;
			}
			
			if (answer.equals("")) {
				JOptionPane.showMessageDialog(fpv, "질문 답을 입력해주세요.");
				fpv.getJtfAnswer().requestFocus();
				return;
			}
			
			try {
				if(!LoginDAO.getInstance().selectId(id)) { // 중복 아이디 검증
					JOptionPane.showMessageDialog(fpv, "가입된 회원이 아닙니다.");
					fpv.dispose();
					return;
				}
			} catch (HeadlessException e1) {
				e1.printStackTrace();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			String questionType = String.valueOf(fpv.getJcbQuestion().getSelectedIndex());
			
			try {
				if(LoginDAO.getInstance().selectValidIdAndAnswer(id, questionType, answer)) {
					JOptionPane.showMessageDialog(fpv, "인증 성공!");
					fpv.dispose();
					new SetPasswordView(lv, id);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		fpv.dispose();
	}
}
