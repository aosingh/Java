package edu.asu.CS598.assignment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import edu.asu.CS598.assignment.applicationobjects.GradeBook;
import edu.asu.CS598.assignment.applicationobjects.GradeBook.Grades.Student;
import edu.asu.CS598.assignment.applicationobjects.GradeBook.Grades.Student.AssignedWork;
import edu.asu.CS598.assignment.applicationobjects.GradeBook.Grades.Student.AssignedWork.GradedWork;


public class FinalGradeCalculatorForClass implements IFinalLetterGradeCalculator {
	
	
	
	private static IFinalLetterGradeCalculator finalletterGradeCalculatorInstance;
	
	public static IFinalLetterGradeCalculator getInstance()
	{
		if(finalletterGradeCalculatorInstance == null)
		{
			finalletterGradeCalculatorInstance = new FinalGradeCalculatorForClass();
		}
		return finalletterGradeCalculatorInstance;
	}



	@Override
	public LetterGradesMapForClass createGradeMapperForClass() {
		LetterGradesMapForClass gradesMapper = LetterGradesMapForClass.getInstance();
		gradesMapper.clearGradeMap();
		gradesMapper.putGrade(90, 100, "A");
		gradesMapper.putGrade(80, 89, "B");
		gradesMapper.putGrade(70, 79, "C");
		gradesMapper.putGrade(60, 69, "D");	
		gradesMapper.putGrade(0, 59, "E");
		return gradesMapper;
	}	


	/* 
	 * (non-Javadoc)
	 * @see edu.asu.CS598.assignment.IFinalLetterGradeCalculator#calculateFinalGradeFromNumericGrades(edu.asu.CS598.assignment.applicationobjects.GradeBook, edu.asu.CS598.assignment.LetterGradesMapForClass)
	 */
	public GradeBook  calculateFinalGradeFromNumericGrades(GradeBook gradebook, LetterGradesMapForClass gradeMap) 
	{
		FinalGradeCalculatorHelper finalGradeCalculatorHelper = FinalGradeCalculatorHelper.getInstance();
		List<Student> list_student = gradebook.getGrades().getStudent();
		HashMap<String, Double> gradeSchemaMap = finalGradeCalculatorHelper.createMapForGradingSchema(gradebook.getGradingSchema());
		for (Iterator<Student> student_iterator = list_student.iterator(); student_iterator.hasNext();) 
		{
			Student student = (Student) student_iterator.next();
			String finalGrade = finalGradeCalculatorHelper.getFinalGrade(student, gradeSchemaMap, gradeMap);
			student.setLetterGrade(finalGrade);
			
		}
		return gradebook;

	}


	public GradeBook convertLetterGradeToNumericGrade(GradeBook gradebook, LetterGradesMapForClass gradeMap) {
		List<Student> list_student = gradebook.getGrades().getStudent();
		for (Iterator<Student> student_iterator = list_student.iterator(); student_iterator.hasNext();) 
		{
			Student student = (Student) student_iterator.next();
			List<AssignedWork> List_assignedWork = student.getAssignedWork();
			for (Iterator<AssignedWork> iterator = List_assignedWork.iterator(); iterator.hasNext();) 
			{
				AssignedWork assignedWork = (AssignedWork) iterator.next();
				List<GradedWork> list_gradedWork = assignedWork.getGradedWork();
				for (Iterator<GradedWork> gradedwork_iterator = list_gradedWork.iterator(); gradedwork_iterator.hasNext();) 
				{
					GradedWork gradedWork = (GradedWork) gradedwork_iterator.next();
					if(!gradedWork.getGrade().matches("-?\\d+(\\.\\d+)?"))
					{
						double median  = gradeMap.getMedianOfTheRange(gradedWork.getGrade());
						gradedWork.setGrade(String.valueOf(median));
					}

				}

			}
		}
		return gradebook;
	}


}
