package dto;



public class MemberDTO {
	 private int studno;// NUMBER(6) PRIMARY KEY, 
	 private String studname;// VARCHAR2(20), 
	 private int korean;// number(3), 
	 private int english;// number(3), 
	 private int math;// number(3), 
	 private int history;// number(3),  
	 
	public int getStudno() {
		return studno;
	}
	public void setStudno(int studno) {
		this.studno = studno;
	}
	public String getStudname() {
		return studname;
	}
	public void setStudname(String studname) {
		this.studname = studname;
	}
	public int getKorean() {
		return korean;
	}
	public void setKorean(int korean) {
		this.korean = korean;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getHistory() {
		return history;
	}
	public void setHistory(int history) {
		this.history = history;
	}
	
	 
	 
	
	 
	 
	
}
