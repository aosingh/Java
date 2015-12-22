package edu.asu.CS598.assignment;


import edu.asu.CS598.assignment.applicationobjects.GradeBook;


public interface IFinalLetterGradeCalculator {
	
	//A method which takes a student and replaces every grade with a numeric grade, if not.
	
	/**
	 * This API can be used to create to fix the grade ranges for a class.
	 * It returns a graded mapper and the mapper will provide various functionalities like 
	 * <ul>
	 * <li>Create a grade map. Example  A is between 100 and 98, B is between 80 and 95...so on.</li>
	 * <li>LookUp a letter grade for a numeric grade.</li>
	 * <li>Return the median of the Spread if the input grade is Letter grade</li>
	 * @return LetterGradesMapForClass
	 */
	public LetterGradesMapForClass createGradeMapperForClass();
	
	/**
	 * This API will be used to convert the Letter Grades to Numeric Grades if any. 
	 * This is useful to derive the final letter grade.
	 * @param gradebook
	 * @param gradeMap
	 * @return GradeBook
	 */
	public GradeBook convertLetterGradeToNumericGrade(GradeBook gradebook, LetterGradesMapForClass gradeMap);
	
	
	
	/**
	 * calculateFinalGradeFromNumericGrades API will calulate the Final numeric grades, 
	 * given a gradebook and a gradeMAP in input.
	 * @param gradebook
	 * @param gradeMap
	 * @return
	 */
	public GradeBook calculateFinalGradeFromNumericGrades(GradeBook gradebook, LetterGradesMapForClass gradeMap);

}
