package simpleLogin.view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import simpleLogin.controller.SignUpController;

public class SignUpView extends JDialog {
	
	private JTextField jtfId, jtfTel1, jtfTel2, jtfTel3,
	jtfEmail1, jtfEmail2, jtfSsn1, jtfSsn2, jtfZipcode, jtfAddress1,
	jtfAddress2, jtfAnswer;
	private JPasswordField jpfPass1, jpfPass2;
	private JButton jbSignUp, jbCancel, jbSearchAddress;
	private JComboBox<String> jcbEmail, jcbQuestion;

	public SignUpView() {
		
		JLabel jlSignUp = new JLabel("ȸ������");
		jlSignUp.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		JLabel jlId = new JLabel("���̵�");
		JLabel jlPass1 = new JLabel("��й�ȣ");
		JLabel jlPass2 = new JLabel("��й�ȣ Ȯ��");
		JLabel jlTel = new JLabel("����ó");
		JLabel jlEmail = new JLabel("�̸���");
		JLabel jlSsn = new JLabel("�ֹε�Ϲ�ȣ");
		JLabel jlAddress = new JLabel("�ּ�");
		JLabel jlDetailAddress = new JLabel("���ּ�");
		JLabel jlQuestion = new JLabel("��������");
		JLabel jlAnswer = new JLabel("���� ��");
		
		jtfId = new JTextField();
		jtfTel1 = new JTextField();
		jtfTel2 = new JTextField();
		jtfTel3 = new JTextField();
		jtfEmail1 = new JTextField();
		jtfEmail2 = new JTextField();
		jtfSsn1 = new JTextField();
		jtfSsn2 = new JTextField();
		jtfZipcode = new JTextField();
		jtfAddress1 = new JTextField();
		jtfAddress2 = new JTextField();
		jtfAnswer = new JTextField();
		
		jpfPass1 = new JPasswordField();
		jpfPass2 = new JPasswordField();
		
		jbSignUp = new JButton("ȸ������");
		jbCancel = new JButton("���");
		jbSearchAddress = new JButton("�ּ� �˻�");
		
		String[] emailItems = { "NAVER", "DAUM", "GOOGLE", "���� �Է�" };
		jcbEmail = new JComboBox(emailItems);
		
		String[] questionItems = { "� �� ���� ģ�ߴ� ģ���� �̸���?", "��� �ʵ��б���?" };
		jcbQuestion = new JComboBox(questionItems);
		
		setLayout(null);
		
		jlSignUp.setBounds(250, 10, 150, 35);

		jlId.setBounds(80, 70, 100, 25);
		jtfId.setBounds(200, 70, 270, 25);
		jlPass1.setBounds(80, 110, 100, 25);
		jpfPass1.setBounds(200, 110, 270, 25);
		jlPass2.setBounds(80, 150, 100, 25);
		jpfPass2.setBounds(200, 150, 270, 25);
		jlTel.setBounds(80, 190, 100, 25);
		jtfTel1.setBounds(200, 190, 75, 25);
		jtfTel2.setBounds(290, 190, 80, 25);
		jtfTel3.setBounds(390, 190, 80, 25);		
		jlEmail.setBounds(80, 230, 100, 25);
		jtfEmail1.setBounds(200, 230, 70, 25);
		jtfEmail2.setBounds(290, 230, 70, 25);
		jcbEmail.setBounds(380, 230, 90, 25);
		jlSsn.setBounds(80, 270, 100, 25);
		jtfSsn1.setBounds(200, 270, 120, 25);
		jtfSsn2.setBounds(340, 270, 130, 25);
		jlAddress.setBounds(80, 310, 100, 25);
		jtfAddress1.setBounds(200, 350, 270, 25);
		jtfAddress2.setBounds(200, 390, 270, 25);
		jtfZipcode.setBounds(200, 310, 120, 25);
		jbSearchAddress.setBounds(340, 310, 130, 25);
		jlDetailAddress.setBounds(80, 390, 100, 25);
		jlQuestion.setBounds(80, 430, 100, 25);
		jcbQuestion.setBounds(200, 430, 270, 25);
		jlAnswer.setBounds(80, 470, 100, 25);
		jtfAnswer.setBounds(200, 470, 270, 25);
		jbSignUp.setBounds(180, 530, 100, 25);
		jbCancel.setBounds(300, 530, 100, 25);
		
		add(jbCancel);
		add(jbSignUp);
		add(jtfAnswer);
		add(jcbQuestion);
		add(jtfAddress1);
		add(jtfAddress2);
		add(jbSearchAddress);
		add(jtfZipcode);
		add(jtfSsn1);
		add(jtfSsn2);
		add(jcbEmail);
		add(jtfEmail2);
		add(jtfEmail1);
		add(jtfTel3);
		add(jtfTel2);
		add(jtfTel1);
		add(jlSignUp);
		add(jlId);
		add(jtfId);
		add(jlPass1);
		add(jpfPass1);
		add(jlPass2);
		add(jpfPass2);
		add(jlTel);
		add(jlEmail);
		add(jlSsn);
		add(jlAddress);
		add(jlDetailAddress);
		add(jlQuestion);
		add(jlAnswer);
		

		/////////////////////////////////////////////////////////
		////��ġ ��, ȸ������ �̺�Ʈ ó�� �������� 2019-01-18
		/////////////////////////////////////////////////////////
		
		SignUpController suc = new SignUpController(this);
		addWindowListener(suc);
		
		setBounds(500, 100, 600, 640);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SignUpView();
	}
}
