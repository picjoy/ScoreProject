package grade;

public class MajorEvaluation implements GradeEvaluation{

	@Override
	public String getGrade(int point) {
		String grade;
		if(point >= 95  && point <= 100)
			grade = "S";
		else if(point >= 90)
			grade = new String("A");
		else if(point >= 80)
			grade = new String("B");
		else if(point >= 70)
			grade = new String("C");
		else if(point >= 60)
			grade = new String("D");
		else
			grade = new String("F");
		
		return grade;
		
		
	}

	
}
