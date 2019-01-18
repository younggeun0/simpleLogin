package simpleLogin.vo;

public class UserInfoVO {
	
	private String id, password, tel, email, ssn, address, question, answer;

	public UserInfoVO(String id, String password, String tel, String email, String ssn, String address, String question,
			String answer) {
		this.id = id;
		this.password = password;
		this.tel = tel;
		this.email = email;
		this.ssn = ssn;
		this.address = address;
		this.question = question;
		this.answer = answer;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getTel() {
		return tel;
	}

	public String getEmail() {
		return email;
	}

	public String getSsn() {
		return ssn;
	}

	public String getAddress() {
		return address;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}

	@Override
	public String toString() {
		return "UserInfoVO [id=" + id + ", password=" + password + ", tel=" + tel + ", email=" + email + ", ssn=" + ssn
				+ ", address=" + address + ", question=" + question + ", answer=" + answer + "]";
	}
}
