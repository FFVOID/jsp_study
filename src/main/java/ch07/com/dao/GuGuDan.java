package ch07.com.dao;

public class GuGuDan {
	private int num1 = 5;
	private int num2;
	
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
	public int process(int num2) {
		int result = 0;
		return result = num1 * num2;
	}
}
