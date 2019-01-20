package simpleLogin.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import simpleLogin.controller.LoginController;

@SuppressWarnings("serial")
public class LoginView extends JFrame {

	private JTextField jtfId;
	private JPasswordField jpfPass;
	private JButton jbLogin, jbSignUp;
	private JLabel jlForgotPass;
	
	public LoginView() {
		super("Login");

		JLabel jlLogin = new JLabel("Simple Login");
		jlLogin.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		JLabel jlId = new JLabel("아이디");
		JLabel jlPw = new JLabel("비밀번호");
		
		jtfId = new JTextField();
		jpfPass = new JPasswordField();
		
		jbLogin = new JButton("로그인");
		jbSignUp = new JButton("회원가입");
		jlForgotPass = new JLabel("비밀번호 찾기");
		
		setLayout(null);
		
		jlLogin.setBounds(140, 20, 150, 25);
		jlId.setBounds(60, 60, 80, 25);
		jlPw.setBounds(60, 95, 120, 25);
		jtfId.setBounds(120, 60, 220, 25);
		jpfPass.setBounds(120, 95, 220, 25);
		jbLogin.setBounds(60, 135, 280, 25);
		jbSignUp.setBounds(60, 170, 280, 25);
		jlForgotPass.setBounds(160, 200, 150, 25);
		jlForgotPass.setForeground(Color.BLUE);
		
		add(jlLogin);
		add(jlId);
		add(jlPw);
		add(jtfId);
		add(jpfPass);
		add(jbLogin);
		add(jbSignUp);
		add(jlForgotPass);
		
		LoginController lc = new LoginController(this);
		jtfId.addActionListener(lc);
		jpfPass.addActionListener(lc);
		jbLogin.addActionListener(lc);
		jbSignUp.addActionListener(lc);
		jlForgotPass.addMouseListener(lc);
		addWindowListener(lc);
		
		setBounds(400, 300, 400, 280);
		setResizable(false);
		setVisible(true);
	}

	public JTextField getJtfId() {
		return jtfId;
	}
	public JPasswordField getJpfPass() {
		return jpfPass;
	}
	public JButton getJbLogin() {
		return jbLogin;
	}
	public JButton getJbSignUp() {
		return jbSignUp;
	}
	public JLabel getJlForgotPass() {
		return jlForgotPass;
	}
}
