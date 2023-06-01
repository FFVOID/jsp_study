package ch07.com.dao;

public class Member {
	public static final String pattern1 = "\\w+@\\w+\\.\\w+(\\.\\w+)?"; //
	public static final String pattern2 = "(02|010)-\\d{3,4}-\\d{4}";

	private static String email;
	private static String tel;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String process() {
		
		if (email.matches(pattern1) && tel.matches(pattern2)) {

			return "환영합니다";
		}
		return "유효성 검사에 통과되지 못했습니다";

	}
}
