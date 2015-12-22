package edu.asu.CS598.assignment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import edu.asu.CS598.assignment.applicationobjects.GradeBook;
import edu.asu.CS598.assignment.applicationobjects.GradeBook.Grades.Student;
import edu.asu.CS598.assignment.applicationobjects.GradeBook.Grades.Student.AssignedWork;
import edu.asu.CS598.assignment.applicationobjects.GradeBook.Grades.Student.AssignedWork.GradedWork;
import edu.asu.CS598.assignment.applicationobjects.GradeBook.GradingSchema;
import edu.asu.CS598.assignment.applicationobjects.GradeBook.GradingSchema.GradeItem;

public class GradeFileDataValidator {

	private static GradeFileDataValidator gradeValidatorInstance = null;
	public static GradeFileDataValidator getInstance()
	{
		if(gradeValidatorInstance == null)
		{
			gradeValidatorInstance = new GradeFileDataValidator();
		}
		return gradeValidatorInstance;
	}
	
	
	
	/**
	 * This method checks that the data in the file is good.
	 * @param gradeBook
	 * @return Boolean isGoodFile
	 * 
	 */
	public boolean isGoodFile(GradeBook gradeBook)
	{
		int countOfGradingItems = gradeBook.getGradingSchema().getGradeItem().size();
		List<Student> list_of_students = gradeBook.getGrades().getStudent();
		return isGradingSchemaPresentForClass(gradeBook)&&
				isSpellingCorrectForEveryGradingItem(list_of_students, gradeBook.getGradingSchema())&&
				isEveryStudentGradedForEveryGradingItem(list_of_students, countOfGradingItems)&&
				isGradeInRangeForEveryStudent(list_of_students);

	}


	/**
	 * 
	 * @param list_of_students
	 * @param gradeSchema
	 * @return boolean: Is Spelling correct For Every grading Item.
	 */
	private boolean isSpellingCorrectForEveryGradingItem(List<Student> list_of_students, GradingSchema gradeSchema)
	{
		List<GradeItem> gradingItem = gradeSchema.getGradeItem();
		List<String> gradingItemNames = new ArrayList<String>() ;
		for (Iterator<GradeItem> gradeitem_iterator = gradingItem.iterator(); gradeitem_iterator.hasNext();) 
		{
			GradeItem grade_item = (GradeItem) gradeitem_iterator.next();
			gradingItemNames.add(grade_item.getCategory());
		}
		for (Iterator<Student> student_iterator = list_of_students.iterator(); student_iterator.hasNext();) 
		{
			Student student = (Student) student_iterator.next();
			List<AssignedWork> assignedWorks = student.getAssignedWork();
			for (Iterator<AssignedWork> assignedwork_iterator = assignedWorks.iterator(); assignedwork_iterator.hasNext();) 
			{
				AssignedWork assignedWork = (AssignedWork) assignedwork_iterator.next();
				if(!gradingItemNames.contains(assignedWork.getCategory()))
				{
					return false;
				}

			}

		}
		return true;
	}

	/**
	 * 
	 * @param list_of_students
	 * @return boolean : is Grade In Range For every student
	 */
	private boolean isGradeInRangeForEveryStudent(List<Student> list_of_students)
	{
		for (Iterator<Student> student_iterator = list_of_students.iterator(); student_iterator.hasNext();) 
		{
			Student student = (Student) student_iterator.next();
			List<AssignedWork> assignedWorks = student.getAssignedWork();
			for (Iterator<AssignedWork> assignedwork_iterator = assignedWorks.iterator(); assignedwork_iterator.hasNext();) 
			{
				AssignedWork assignedWork = (AssignedWork) assignedwork_iterator.next();
				List<GradedWork> listgradedWork = assignedWork.getGradedWork();
				for (Iterator<GradedWork> gradedwork_iterator = listgradedWork.iterator(); gradedwork_iterator.hasNext();) 
				{
					GradedWork gradedWork = (GradedWork) gradedwork_iterator.next();
					if(gradedWork.getGrade().matches("-?\\d+(\\.\\d+)?"))
					{
						if(Double.parseDouble(gradedWork.getGrade()) > 100 || Double.parseDouble(gradedWork.getGrade()) < 0)
						{
							return false;
						}
					}

				}



			}
		}
		return true;

	}


	/**
	 * 
	 * @param list_of_students
	 * @param countOfGradingItems
	 * @return boolean is Every Student Graded for every item in the GRading Schema
	 */
	private boolean isEveryStudentGradedForEveryGradingItem(List<Student> list_of_students, int countOfGradingItems)
	{
		for (Iterator<Student> student_iterator = list_of_students.iterator(); student_iterator.hasNext();) 
		{
			//Check if every Student is Graded for Every Item.
			Student student = (Student) student_iterator.next();
			if(student.getAssignedWork().size() != countOfGradingItems)
			{
				return false;
			}

		}
		return true;

	}
	
	/**
	 * Check if the GRadebook contains the Grading Schema
	 * @param gradebook
	 * @return
	 */
	private boolean isGradingSchemaPresentForClass(GradeBook gradebook)
	{
		if (gradebook.getGradingSchema() == null)
		{
			return false;
		}
		else
			return true;
				
	}

}
