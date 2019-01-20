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
	
	private JTextField jtfId, /*jtfTel, jtfTel2, jtfTel3,*/
	jtfEmail1, jtfEmail2, jtfSsn1, jtfSsn2, jtfZipcode, jtfAddress1,
	jtfAddress2, jtfAnswer;
	private JTextField[] jtfTel;
	private JPasswordField jpfPass1, jpfPass2;
	private JButton jbSignUp, jbCancel, jbSearchAddress;
	private JComboBox<String> jcbEmail, jcbQuestion;

	public SignUpView(LoginView lv) {
		super(lv, "회원가입", true);
		
		JLabel jlSignUp = new JLabel("회원가입");
		jlSignUp.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		JLabel jlId = new JLabel("아이디");
		JLabel jlPass1 = new JLabel("비밀번호");
		JLabel jlPass2 = new JLabel("비밀번호 확인");
		JLabel jlTel = new JLabel("연락처");
		JLabel jlEmail = new JLabel("이메일");
		JLabel jlSsn = new JLabel("주민등록번호");
		JLabel jlAddress = new JLabel("주소");
		JLabel jlDetailAddress = new JLabel("상세주소");
		JLabel jlQuestion = new JLabel("인증질문");
		JLabel jlAnswer = new JLabel("질문 답");
		
		jtfTel = new JTextField[3];
		jtfId = new JTextField();
		jtfTel[0] = new JTextField();
		jtfTel[1] = new JTextField();
		jtfTel[2] = new JTextField();
		jtfEmail1 = new JTextField();
		jtfEmail2 = new JTextField();
		jtfSsn1 = new JTextField();
		jtfSsn2 = new JTextField();
		jtfZipcode = new JTextField();
		jtfZipcode.setEditable(false);
		jtfAddress1 = new JTextField();
		jtfAddress1.setEditable(false);
		jtfAddress2 = new JTextField();
		jtfAnswer = new JTextField();
		
		jpfPass1 = new JPasswordField();
		jpfPass2 = new JPasswordField();
		
		jbSignUp = new JButton("회원가입");
		jbCancel = new JButton("취소");
		jbSearchAddress = new JButton("주소 검색");
		
		String[] emailItems = { "직접입력", "NAVER", "GOOGLE", "DAUM" };
		jcbEmail = new JComboBox(emailItems);
		jcbEmail.setSelectedIndex(0);
		
		String[] questionItems = { "어릴 적 가장 친했던 친구의 이름은?", "출신 초등학교는?" };
		jcbQuestion = new JComboBox(questionItems);
		jcbQuestion.setSelectedIndex(0);
		
		setLayout(null);
		
		jlSignUp.setBounds(250, 10, 150, 35);

		jlId.setBounds(80, 70, 100, 25);
		jtfId.setBounds(200, 70, 270, 25);
		jlPass1.setBounds(80, 110, 100, 25);
		jpfPass1.setBounds(200, 110, 270, 25);
		jlPass2.setBounds(80, 150, 100, 25);
		jpfPass2.setBounds(200, 150, 270, 25);
		jlTel.setBounds(80, 190, 100, 25);
		jtfTel[0].setBounds(200, 190, 75, 25);
		jtfTel[1].setBounds(290, 190, 80, 25);
		jtfTel[2].setBounds(390, 190, 80, 25);		
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
		add(jtfTel[2]);
		add(jtfTel[1]);
		add(jtfTel[0]);
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
		

		SignUpController suc = new SignUpController(this);
		jcbEmail.addActionListener(suc);
		jcbQuestion.addActionListener(suc);
		jbSearchAddress.addActionListener(suc);
		jbSignUp.addActionListener(suc);
		jbCancel.addActionListener(suc);
		addWindowListener(suc);
		
		setBounds(500, 100, 600, 640);
		setVisible(true);
	}

	public JTextField getJtfId() {
		return jtfId;
	}

	
	public JTextField[] getJtfTel() {
		return jtfTel;
	}

	public JTextField getJtfEmail1() {
		return jtfEmail1;
	}

	public JTextField getJtfEmail2() {
		return jtfEmail2;
	}

	public JTextField getJtfSsn1() {
		return jtfSsn1;
	}

	public JTextField getJtfSsn2() {
		return jtfSsn2;
	}

	public JTextField getJtfZipcode() {
		return jtfZipcode;
	}

	public JTextField getJtfAddress1() {
		return jtfAddress1;
	}

	public JTextField getJtfAddress2() {
		return jtfAddress2;
	}

	public JTextField getJtfAnswer() {
		return jtfAnswer;
	}

	public JPasswordField getJpfPass1() {
		return jpfPass1;
	}

	public JPasswordField getJpfPass2() {
		return jpfPass2;
	}

	public JButton getJbSignUp() {
		return jbSignUp;
	}

	public JButton getJbCancel() {
		return jbCancel;
	}

	public JButton getJbSearchAddress() {
		return jbSearchAddress;
	}

	public JComboBox<String> getJcbEmail() {
		return jcbEmail;
	}

	public JComboBox<String> getJcbQuestion() {
		return jcbQuestion;
	}
	
}
