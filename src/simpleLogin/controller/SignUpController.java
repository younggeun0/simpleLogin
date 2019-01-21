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
		
		if(pass1.equals(pass2)) { // 비번이 같다면
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
					JOptionPane.showMessageDialog(suv, "아이디는 필수 입력항목입니다.");
					suv.getJtfId().requestFocus();
					return;
				}
				
				if(LoginDAO.getInstance().selectId(id)) { // 중복 아이디 검증
					JOptionPane.showMessageDialog(suv, "중복된 아이디가 존재합니다.");
					suv.getJtfId().setText("");
					suv.getJtfId().requestFocus();
					return;
				}
				
				String pass1 = new String(suv.getJpfPass1().getPassword());
				String pass2 = new String(suv.getJpfPass2().getPassword());
				
				
				if (pass1.equals("") || pass2.equals("")) { // 비밀번호 공백 검증
					JOptionPane.showMessageDialog(suv, "비밀번호는 필수 입력항목입니다.");
					suv.getJpfPass1().requestFocus();
					return;
				}

				
				if(!validatePass(pass1, pass2)) { // 비밀번호 검증
					JOptionPane.showMessageDialog(suv, "입력하신 두 비밀번호가 일치하지 않습니다.");
					suv.getJpfPass1().setText("");
					suv.getJpfPass2().setText("");
					suv.getJpfPass1().requestFocus();
					return;
				}
				
				
				String[] arrTel = new String[3]; // 연락처 검증
				try {
					for(int i=0; i<3; i++) {
						arrTel[i] = suv.getJtfTel()[i].getText().trim();
						if(arrTel[i].equals("")) {							
							JOptionPane.showMessageDialog(suv, "연락처는 필수입력 항목입니다.");
							suv.getJtfTel()[i].requestFocus();
							return;
						}
						Integer.parseInt(arrTel[i]);
					}
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(suv, "연락처는 숫자만 입력가능합니다.");
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
					JOptionPane.showMessageDialog(suv, "이메일은 필수입력 항목입니다.");
					suv.getJtfEmail1().setText("");
					suv.getJtfEmail2().setText("");
					suv.getJtfEmail1().requestFocus();
					return;
				}
				
				if(!validateEmail2(email2)) {
					JOptionPane.showMessageDialog(suv, "올바른 이메일형식이 아닙니다.");
					suv.getJtfEmail2().setText("");
					suv.getJtfEmail2().requestFocus();
					return;
				};

				StringBuilder email = new StringBuilder();
				email.append(email1).append("@").append(email2);
				
				String ssn1 = suv.getJtfSsn1().getText().trim();
				String ssn2 = suv.getJtfSsn2().getText().trim();
				
				if (ssn1.equals("") || ssn2.equals("")) { // 주민번호 공백 검증
					showMessageDialog(suv, "주민번호는 필수 입력항목입니다.");
					suv.getJtfSsn1().requestFocus();
					return;
				}
				
				try {	// 주민번호 숫자형식 검증
					Integer.parseInt(ssn1);
					Integer.parseInt(ssn2);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(suv, "주민등록번호는 숫자만 입력가능합니다.");
					suv.getJtfSsn1().setText("");
					suv.getJtfSsn2().setText("");
					suv.getJtfSsn1().requestFocus();
					return;
				}
				
				if (!validateSsn(ssn1, ssn2)) {
					JOptionPane.showMessageDialog(suv, "잘못된 주민번호입니다.");
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
					showMessageDialog(suv, "주소 검색을 수행해주세요.");
					return;
				}
				
				StringBuilder address = new StringBuilder();
				
				address.append(address1).append(" ").append(address2)
				.append("(").append(zipcode).append(")");
				
				String question = String.valueOf(suv.getJcbQuestion().getSelectedIndex());
				String answer = suv.getJtfAnswer().getText().trim();

				if (answer.equals("")) {
					showMessageDialog(suv, "인증 답은 필수 항목입니다.");
					suv.getJtfAnswer().requestFocus();
					return;
				}
				
				UserInfoVO uivo = new UserInfoVO(id, pass1, 
						tel.toString(), email.toString(), 
						ssn.toString(), address.toString(), 
						question, answer);
				
				signUp(uivo);
				
			} catch (SQLException se) {
				JOptionPane.showMessageDialog(suv, "DB문제, 아이디 검증시도에 실패했습니다.");
				se.printStackTrace();
			}
			
		}
		
		if (e.getSource() == suv.getJcbEmail()) { // 이메일 콤보박스 선택 시
			int email = suv.getJcbEmail().getSelectedIndex();
			if (email == 1) { // naver 선택 시
				suv.getJtfEmail2().setText("naver.com");
			}
			if (email == 2) { // google 선택 시 
				suv.getJtfEmail2().setText("google.com");
			}
			if (email == 3) { // daum 선택 시
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
			showMessageDialog(suv, "회원가입이 완료되었습니다.\n감사합니다.");
			suv.dispose();
		} catch (SQLException e) {
			showMessageDialog(suv, "DB에 유저를 추가하는데 실패했습니다.");
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
		-- 각 자리에 지정한 수를 곱함
		--  234567 892345
		-- 마지막 주민번호 한자리가 검증 값
		-- 각 자리별 결과를 다 더한 후 11로 나눈 나머지를 구함
		-- 그 결과를 11에서 뺀다
		-- 그 결과를 10으로 나눈 나머지를 구함
		-- 최종 결과값이 주민번호 최종끝자리와 같으면 유효
		-- 같지 않으면 무효*/
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
