package simpleLogin.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import simpleLogin.controller.FindPasswordController;

public class FindPasswordView extends JDialog {

	private JTextField jtfId, jtfAnswer;
	private JComboBox<String> jcbQuestion;
	private JButton jbValidate, jbClose;
	
	public FindPasswordView(LoginView lv) {
		super(lv, "��й�ȣ ã��", true);
		
		JLabel jlFindPw = new JLabel("��й�ȣ ã��");
		jlFindPw.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		JLabel jlId = new JLabel("���̵�");
		JLabel jlQuestion = new JLabel("��������");
		JLabel jlAnswer = new JLabel("���� ��");
		
		jtfId = new JTextField();
		jtfAnswer = new JTextField();
		
		String[] questions = { "��� ���� ģ�ߴ� ģ���� �̸���?", "��� �ʵ��б���?" };
		jcbQuestion = new JComboBox<>(questions);
		
		jbValidate = new JButton("����� ����");
		jbClose = new JButton("�ݱ�");
	
		setLayout(null);
		
		jlFindPw.setBounds(130, 10, 200, 30);
		add(jlFindPw);
		
		jlId.setBounds(40, 50, 100, 25);
		add(jlId);
		
		jtfId.setBounds(130, 50, 230, 25);
		add(jtfId);
		
		jlQuestion.setBounds(40, 90, 100, 25);
		add(jlQuestion);
		
		jcbQuestion.setBounds(130, 90, 230, 25);
		add(jcbQuestion);

		jlAnswer.setBounds(40, 130, 100, 25);
		add(jlAnswer);
		
		jtfAnswer.setBounds(130, 130, 230, 25);
		add(jtfAnswer);
		
		jbValidate.setBounds(80, 180, 110, 30);
		add(jbValidate);
		
		jbClose.setBounds(200, 180, 110, 30);
		add(jbClose);
		
		FindPasswordController fpc = new FindPasswordController(this, lv);
		jtfId.addActionListener(fpc);
		jtfAnswer.addActionListener(fpc);
		jbValidate.addActionListener(fpc);
		jbClose.addActionListener(fpc);
		addWindowListener(fpc);
		
		setBounds(450, 200, 400, 300);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FindPasswordView(null);
	}

	public JTextField getJtfId() {
		return jtfId;
	}

	public JTextField getJtfAnswer() {
		return jtfAnswer;
	}

	public JComboBox<String> getJcbQuestion() {
		return jcbQuestion;
	}

	public JButton getJbValidate() {
		return jbValidate;
	}

	public JButton getJbClose() {
		return jbClose;
	}
	
	
}
