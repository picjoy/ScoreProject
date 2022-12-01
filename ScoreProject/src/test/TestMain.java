package test;

import school.School;
import school.Score;
import school.Student;
import school.Subject;
import school.report.GenerateGradeReport;
import utils.Define;

public class TestMain {

	School goodSchool = School.getInstance();
	Subject Korean;
	Subject Math;
	Subject Dance;
	
	GenerateGradeReport gradeReport = new GenerateGradeReport();
	
	private void createSubject() {
		Korean = new Subject("국어", Define.Korean);
		Math = new Subject("수학", Define.Math);
		Dance = new Subject("방송 댄스", Define.Dance);
		
		Dance.setGradeType(Define.PF_TYPE);
		
		goodSchool.addSubject(Korean);
		goodSchool.addSubject(Math);
		goodSchool.addSubject(Dance);
		
	}
	
	public static void main(String[] args) {
		TestMain test = new TestMain();
		
		test.createSubject();
		test.createStudent();
		
		String report= test.gradeReport.getReport();
		System.out.println(report);
				
	}

	private void createStudent() {
		Student std1 = new Student(170219, "김정우", Korean);
		Student std2 = new Student(180802, "이민형", Math);
		Student std3 = new Student(190423, "이제노", Math);
		Student std4 = new Student(190323, "황런쥔", Korean);
		Student std5 = new Student(201122, "쫑천러", Math);
		Student std6 = new Student(210205, "박지성", Korean);
		
		goodSchool.addStudent(std1);
		goodSchool.addStudent(std2);
		goodSchool.addStudent(std3);
		goodSchool.addStudent(std4);
		goodSchool.addStudent(std5);
		goodSchool.addStudent(std6);
		
		Korean.register(std1);
		Korean.register(std2);
		Korean.register(std3);
		Korean.register(std4);
		Korean.register(std5);
		Korean.register(std6);
		
		Math.register(std1);
		Math.register(std2);
		Math.register(std3);
		Math.register(std4);
		Math.register(std5);
		Math.register(std6);
		
		Dance.register(std1);
		Dance.register(std2);
		Dance.register(std3);
		Dance.register(std6);
		
		addScoreForStudent(std1, Korean, 85);
		addScoreForStudent(std1, Math, 80);
		addScoreForStudent(std1, Dance, 95);
		
		addScoreForStudent(std2, Korean, 70);
		addScoreForStudent(std2, Math, 95);
		addScoreForStudent(std2, Dance, 95);
		
		addScoreForStudent(std3, Korean, 95);
		addScoreForStudent(std3, Math, 97);
		addScoreForStudent(std3, Dance, 94);
		
		addScoreForStudent(std4, Korean, 97);
		addScoreForStudent(std4, Math, 75);
		
		addScoreForStudent(std5, Korean, 90);
		addScoreForStudent(std5, Math, 85);
		
		addScoreForStudent(std6, Korean, 75);
		addScoreForStudent(std6, Math, 45);
		addScoreForStudent(std6, Dance, 99);
		
		
		
	}

	private void addScoreForStudent(Student student, Subject subject, int point) {
		Score score = new Score(student.getStudentId(), subject, point);
		student.addScore(score);
		
	}


	
}
