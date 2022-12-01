package school.report;

import java.util.ArrayList;

import grade.BasicEvaluation;
import grade.GradeEvaluation;
import grade.MajorEvaluation;
import grade.PassFailEvaluation;
import school.School;
import school.Score;
import school.Student;
import school.Subject;
import utils.Define;

public class GenerateGradeReport {

	School school = School.getInstance();
	
	public static final String Title = "수강생 학점 \t\t\n";
	public static final String Header = "이름 | 학번 | 필수 과목 | 점수 \n";
	public static final String Line = "----------------------------------\n";
	
	private StringBuffer buffer = new StringBuffer();
	
	public void makeHeader(Subject subject) {
		buffer.append(GenerateGradeReport.Line);
		buffer.append("\t"+subject.getSubjectName());
		buffer.append(GenerateGradeReport.Title);
		buffer.append(GenerateGradeReport.Line);
	}
	
	public void makeBody(Subject subject) {
		ArrayList<Student> studentList = subject.getStudentList();
		
		for(int i = 0; i < studentList.size(); i++) {
			Student student = studentList.get(i);
			buffer.append(student.getStudentName());
			buffer.append(" | ");
			buffer.append(student.getStudentId());
			buffer.append(" | ");
			buffer.append(student.getMajor().getSubjectName()+"\t");
			buffer.append(" | ");
			
			getScoreGrade(student, subject.getSubjectNum());
			
			buffer.append("\n");
			buffer.append(Line);
			
		}
	}
	
	private void getScoreGrade(Student student, int subjectNum) {
		ArrayList<Score> scoreList = student.getScoreList();
		Subject subject;
		int majorId = student.getMajor().getSubjectNum();
		
		
		GradeEvaluation[] gradeEvaluation = {new BasicEvaluation(), 
				new MajorEvaluation(), new PassFailEvaluation()};
	
		for(int i = 0; i < scoreList.size(); i++) {
			Score score = scoreList.get(i);
			if(score.getSubject().getSubjectNum() == subjectNum) {
				String grade;
				if (score.getSubject().getSubjectNum() == 3001) {
					grade = gradeEvaluation[Define.PF_TYPE].getGrade(score.getPoint());
				} else {
				if(score.getSubject().getSubjectNum() == majorId)
					grade = gradeEvaluation[Define.SAB_TYPE].getGrade(score.getPoint());
				else
					grade = gradeEvaluation[Define.AB_TYPE].getGrade(score.getPoint());
				}
				
				
				buffer.append(score.getPoint());
				buffer.append(" : ");
				buffer.append(grade);
				buffer.append(" | ");
					
				
			}
		}
		
	}

	public void makeFooter() {
		buffer.append("\n");
	}
	
	public String getReport() {
		ArrayList<Subject> subjectList = school.getSubjectList();
		
		for(Subject subject : subjectList) {
			makeHeader(subject);
			makeBody(subject);
			makeFooter();
			
		}
		return buffer.toString();
	}
	
	
	
	
}
