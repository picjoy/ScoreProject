package school;

import java.util.ArrayList;

public class Student {
	
	private int studentId;
	private String studentName;
	//�ʼ� ����
	private Subject major;
	
	//�ڽ��� ������ ���� ���� ����Ʈ
	private ArrayList<Score> ScoreList = new ArrayList<>();

	public Student(int studentId, String studentName, Subject major) {
		this.studentId = studentId;
		this.studentName = studentName;
		this.major = major;
	}
	
	public void addScore(Score score) {
		ScoreList.add(score);
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Subject getMajor() {
		return major;
	}

	public void setMajor(Subject major) {
		this.major = major;
	}

	public ArrayList<Score> getScoreList() {
		return ScoreList;
	}

	public void setScoreList(ArrayList<Score> scoreList) {
		ScoreList = scoreList;
	}
	
	
	
	
}
