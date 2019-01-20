package simpleLogin.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

import simpleLogin.controller.SetPasswordController;

public class SetPasswordView extends JDialog {
	
	private JPasswordField jpfPass1, jpfPass2;
	private JButton jbChangePass, jbCancel;

	public SetPasswordView(LoginView lv, String id) {
		super(lv, "비밀번호 변경", true);
		
		jpfPass1 = new JPasswordField();
		jpfPass2 = new JPasswordField();
		
		jbChangePass = new JButton("비밀번호 변경");
		jbCancel = new JButton("취소");

		JLabel jlChangePass = new JLabel("새 비밀번호 설정");
		JLabel jlPass1 = new JLabel("비밀번호");
		JLabel jlPass2 = new JLabel("비밀번호 확인");
		
		setLayout(null);
		
		jlChangePass.setBounds(120, 10, 200, 30);
		jlChangePass.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		
		jlPass1.setBounds(60, 60, 120, 25);
		jlPass2.setBounds(30, 100, 120, 25);
		jpfPass1.setBounds(130, 60, 190, 25);
		jpfPass2.setBounds(130, 100, 190, 25);
		
		jbChangePass.setBounds(70, 140, 120, 30);
		jbCancel.setBounds(200, 140, 120, 30);
		
		add(jbCancel);
		add(jbChangePass);
		add(jpfPass1);
		add(jpfPass2);
		add(jlPass2);
		add(jlPass1);
		add(jlChangePass);
		
		SetPasswordController spc = new SetPasswordController(this, id);
		jpfPass1.addActionListener(spc);
		jpfPass2.addActionListener(spc);
		jbChangePass.addActionListener(spc);
		jbCancel.addActionListener(spc);
		addWindowListener(spc);
		
		setBounds(lv.getX()+50, lv.getY()+50, 400, 300);
		setVisible(true);
	}

	public JPasswordField getJpfPass1() {
		return jpfPass1;
	}

	public JPasswordField getJpfPass2() {
		return jpfPass2;
	}

	public JButton getJbChangePass() {
		return jbChangePass;
	}

	public JButton getJbCancel() {
		return jbCancel;
	}
}
