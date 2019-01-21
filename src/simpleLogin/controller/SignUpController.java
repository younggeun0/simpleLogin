package simpleLogin.controller;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import simpleLogin.dao.LoginDAO;
import simpleLogin.view.SearchAddressView;
import simpleLogin.view.SignUpView;
import simpleLogin.vo.UserInfoVO;

public class SignUpController extends WindowAdapter implements ActionListener {

	private SignUpView suv;
	
	public SignUpController(SignUpView suv) {
		this.suv = suv;
	}
	
	@Override
	public void windowClosing(WindowEvent e) {
		suv.dispose();
	}
	
	public boolean validatePass(String pass1, String pass2) {
		boolean flag = false;
		
		if(pass1.equals(pass2)) { // ����� ���ٸ�
			flag = true;
		}
		
		return flag;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == suv.getJbSearchAddress()) {
			new SearchAddressView(suv);
		}
		
		if (e.getSource() == suv.getJbSignUp()) {
			try {
				String id = suv.getJtfId().getText().trim();
				if (id.equals("")) {
					JOptionPane.showMessageDialog(suv, "���̵�� �ʼ� �Է��׸��Դϴ�.");
					suv.getJtfId().requestFocus();
					return;
				}
				
				if(LoginDAO.getInstance().selectId(id)) { // �ߺ� ���̵� ����
					JOptionPane.showMessageDialog(suv, "�ߺ��� ���̵� �����մϴ�.");
					suv.getJtfId().setText("");
					suv.getJtfId().requestFocus();
					return;
				}
				
				String pass1 = new String(suv.getJpfPass1().getPassword());
				String pass2 = new String(suv.getJpfPass2().getPassword());
				
				
				if (pass1.equals("") || pass2.equals("")) { // ��й�ȣ ���� ����
					JOptionPane.showMessageDialog(suv, "��й�ȣ�� �ʼ� �Է��׸��Դϴ�.");
					suv.getJpfPass1().requestFocus();
					return;
				}

				
				if(!validatePass(pass1, pass2)) { // ��й�ȣ ����
					JOptionPane.showMessageDialog(suv, "�Է��Ͻ� �� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
					suv.getJpfPass1().setText("");
					suv.getJpfPass2().setText("");
					suv.getJpfPass1().requestFocus();
					return;
				}
				
				
				String[] arrTel = new String[3]; // ����ó ����
				try {
					for(int i=0; i<3; i++) {
						arrTel[i] = suv.getJtfTel()[i].getText().trim();
						if(arrTel[i].equals("")) {							
							JOptionPane.showMessageDialog(suv, "����ó�� �ʼ��Է� �׸��Դϴ�.");
							suv.getJtfTel()[i].requestFocus();
							return;
						}
						Integer.parseInt(arrTel[i]);
					}
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(suv, "����ó�� ���ڸ� �Է°����մϴ�.");
					for(int i=0; i<3; i++) {
						suv.getJtfTel()[i].setText("");
					}
					suv.getJtfTel()[0].requestFocus();
					return;
				}
				
				StringBuilder tel = new StringBuilder();
				tel
				.append(arrTel[0]).append("-")
				.append(arrTel[1]).append("-")
				.append(arrTel[2]);

				String email1 = suv.getJtfEmail1().getText().trim();
				String email2 = suv.getJtfEmail2().getText().trim();
				if (email1.equals("") || email2.equals("")) {
					JOptionPane.showMessageDialog(suv, "�̸����� �ʼ��Է� �׸��Դϴ�.");
					suv.getJtfEmail1().setText("");
					suv.getJtfEmail2().setText("");
					suv.getJtfEmail1().requestFocus();
					return;
				}
				
				if(!validateEmail2(email2)) {
					JOptionPane.showMessageDialog(suv, "�ùٸ� �̸��������� �ƴմϴ�.");
					suv.getJtfEmail2().setText("");
					suv.getJtfEmail2().requestFocus();
					return;
				};

				StringBuilder email = new StringBuilder();
				email.append(email1).append("@").append(email2);
				
				String ssn1 = suv.getJtfSsn1().getText().trim();
				String ssn2 = suv.getJtfSsn2().getText().trim();
				
				if (ssn1.equals("") || ssn2.equals("")) { // �ֹι�ȣ ���� ����
					showMessageDialog(suv, "�ֹι�ȣ�� �ʼ� �Է��׸��Դϴ�.");
					suv.getJtfSsn1().requestFocus();
					return;
				}
				
				try {	// �ֹι�ȣ �������� ����
					Integer.parseInt(ssn1);
					Integer.parseInt(ssn2);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(suv, "�ֹε�Ϲ�ȣ�� ���ڸ� �Է°����մϴ�.");
					suv.getJtfSsn1().setText("");
					suv.getJtfSsn2().setText("");
					suv.getJtfSsn1().requestFocus();
					return;
				}
				
				if (!validateSsn(ssn1, ssn2)) {
					JOptionPane.showMessageDialog(suv, "�߸��� �ֹι�ȣ�Դϴ�.");
					suv.getJtfSsn1().setText("");
					suv.getJtfSsn2().setText("");
					suv.getJtfSsn1().requestFocus();
					return;
				}
				
				StringBuilder ssn = new StringBuilder();
				ssn.append(ssn1).append("-").append(ssn2);
				
				String zipcode= suv.getJtfZipcode().getText().trim();
				String address1 = suv.getJtfAddress1().getText().trim();
				String address2 = suv.getJtfAddress2().getText().trim();
				
				if (zipcode.equals("") || address1.equals("")) {
					showMessageDialog(suv, "�ּ� �˻��� �������ּ���.");
					return;
				}
				
				StringBuilder address = new StringBuilder();
				
				address.append(address1).append(" ").append(address2)
				.append("(").append(zipcode).append(")");
				
				String question = String.valueOf(suv.getJcbQuestion().getSelectedIndex());
				String answer = suv.getJtfAnswer().getText().trim();

				if (answer.equals("")) {
					showMessageDialog(suv, "���� ���� �ʼ� �׸��Դϴ�.");
					suv.getJtfAnswer().requestFocus();
					return;
				}
				
				UserInfoVO uivo = new UserInfoVO(id, pass1, 
						tel.toString(), email.toString(), 
						ssn.toString(), address.toString(), 
						question, answer);
				
				signUp(uivo);
				
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(suv, "DB����, ���̵� �����õ��� �����߽��ϴ�.");
				se.printStackTrace();
			}
			
		}
		
		if (e.getSource() == suv.getJcbEmail()) { // �̸��� �޺��ڽ� ���� ��
			int email = suv.getJcbEmail().getSelectedIndex();
			if (email == 1) { // naver ���� ��
				suv.getJtfEmail2().setText("naver.com");
			}
			if (email == 2) { // google ���� �� 
				suv.getJtfEmail2().setText("google.com");
			}
			if (email == 3) { // daum ���� ��
				suv.getJtfEmail2().setText("hanmail.net");
			}
		}
		
		if (e.getSource() == suv.getJbCancel()) {
			suv.dispose();
		}
	}

	public void signUp(UserInfoVO uivo) {
		try {
			LoginDAO.getInstance().insertUser(uivo);
			showMessageDialog(suv, "ȸ�������� �Ϸ�Ǿ����ϴ�.\n�����մϴ�.");
			suv.dispose();
		} catch (SQLException e) {
			showMessageDialog(suv, "DB�� ������ �߰��ϴµ� �����߽��ϴ�.");
			e.printStackTrace();
		}
	}

	public boolean validateSsn(String ssn1, String ssn2) {
		boolean flag = false;
		
		StringBuilder ssn = new StringBuilder();
		ssn.append(ssn1).append(ssn2);
		
		int[] validVal = new int[12];
		int sumOfValidVal = 0;
		int j = 2;
		
		
		for(int i=0; i<12; i++) {
			
			if(j>9) {
				j = 2;
			}
			
			validVal[i] = Character.getNumericValue(ssn.charAt(i))*j;
			j++;
			
			sumOfValidVal += validVal[i];
		}
		
		if ((11 - (sumOfValidVal%11))%10 == Character.getNumericValue(ssn.charAt(12))) {
			flag = true;
		}
		/*-- '880101-1234567'
		-- �� �ڸ��� ������ ���� ����
		--  234567 892345
		-- ������ �ֹι�ȣ ���ڸ��� ���� ��
		-- �� �ڸ��� ����� �� ���� �� 11�� ���� �������� ����
		-- �� ����� 11���� ����
		-- �� ����� 10���� ���� �������� ����
		-- ���� ������� �ֹι�ȣ �������ڸ��� ������ ��ȿ
		-- ���� ������ ��ȿ*/
		return flag;
	}

	public boolean validateEmail2(String email) {
		boolean flag = false;

		if (email.contains(".")) {
			flag = true;
		}
		
		return flag;
	}
}
