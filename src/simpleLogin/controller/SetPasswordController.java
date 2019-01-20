package simpleLogin.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import simpleLogin.dao.LoginDAO;
import simpleLogin.view.SetPasswordView;

public class SetPasswordController extends WindowAdapter implements ActionListener {

	private SetPasswordView spv;
	private String id;
	
	public SetPasswordController(SetPasswordView spv, String id) {
		this.spv= spv;
		this.id = id;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == spv.getJpfPass1() || 
				e.getSource() == spv.getJpfPass2() ||
				e.getSource() == spv.getJbChangePass()) {
			
			String pass1 = new String(spv.getJpfPass1().getPassword());
			String pass2 = new String(spv.getJpfPass2().getPassword());
			
			if (pass1.equals("")) {
				JOptionPane.showMessageDialog(spv, "�����Ͻ� ��й�ȣ�� �Է����ּ���.");
				spv.getJpfPass1().requestFocus();
				return;
			}
			if (pass2.equals("")) {
				JOptionPane.showMessageDialog(spv, "�����Ͻ� ��й�ȣ�� �Է����ּ���.");
				spv.getJpfPass2().requestFocus();
				return;
			}
			
			if (!pass1.equals(pass2)) {
				JOptionPane.showMessageDialog(spv, "�Է��Ͻ� �� ��й�ȣ�� ���� �ʽ��ϴ�.");
				spv.getJpfPass1().setText("");
				spv.getJpfPass2().setText("");
				return;
			}
			
			changePass(pass1);
		}
		
		if (e.getSource() == spv.getJbCancel()) {
			spv.dispose();
		}
		
	}
	
	public void changePass(String newPass) {
		try {
			if(LoginDAO.getInstance().updatePass(id, newPass)) {
				JOptionPane.showMessageDialog(spv, "��й�ȣ ���� ����");
				spv.dispose();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(spv, "DB������ �н����� ���� ����");
			e.printStackTrace();
		}
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		super.windowClosing(e);
	}
}
