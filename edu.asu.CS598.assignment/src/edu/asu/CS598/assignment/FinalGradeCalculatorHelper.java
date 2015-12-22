package edu.asu.CS598.assignment;

import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import edu.asu.CS598.assignment.applicationobjects.GradeBook.Grades.Student;
import edu.asu.CS598.assignment.applicationobjects.GradeBook.Grades.Student.AssignedWork;
import edu.asu.CS598.assignment.applicationobjects.GradeBook.Grades.Student.AssignedWork.GradedWork;
import edu.asu.CS598.assignment.applicationobjects.GradeBook.GradingSchema;
import edu.asu.CS598.assignment.applicationobjects.GradeBook.GradingSchema.GradeItem;

public class FinalGradeCalculatorHelper {



	private static FinalGradeCalculatorHelper finalGradeCalculatorHelper = null;
	public static FinalGradeCalculatorHelper getInstance()
	{
		if(finalGradeCalculatorHelper == null)
		{
			finalGradeCalculatorHelper = new FinalGradeCalculatorHelper();
		}
		return finalGradeCalculatorHelper;
	}


	/** 
	 * This method will simply create a HASHMAP for the gradingSchema.
	 * This helps is fast retrieval and lookUp, every time for a student.
	 * @param gradingSchema
	 * @return
	 */
	public HashMap<String, Double> createMapForGradingSchema(GradingSchema gradingSchema)
	{
		List<GradeItem> gradeItemList = gradingSchema.getGradeItem();
		HashMap<String, Double> gradeSchemaHashMap = new HashMap<String, Double>();
		for (Iterator<GradeItem> gradeItem_iterator = gradeItemList.iterator(); gradeItem_iterator.hasNext();) 
		{
			GradeItem gradeItem = (GradeItem) gradeItem_iterator.next();
			gradeSchemaHashMap.put(gradeItem.getCategory(), gradeItem.getPercentage());

		}		
		return gradeSchemaHashMap;
	}

	
	/**
	 * This method will aggregate marks of the students as per each category.
	 * The final output of this method can be imagined to be like this
	 * <ul>
	 * <li>Assignments  80/200</li>
	 * <li>Programming Assignments 100/100</li>
	 * <li>Exams 50/100</li>
	 * </ul>
	 * @param student
	 * @param gradeSchemaHashMap
	 * @return
	 */
	private HashMap<String, Double[]> aggregateAssignedWorkGradeForEachStudent(Student student, HashMap<String, Double> gradeSchemaHashMap)
	{
		List<AssignedWork> list_asssignedWork = student.getAssignedWork();
		HashMap<String, Double[]> assignedWorkAggregator = new HashMap<String, Double[]>();
		for (Iterator<AssignedWork> assignedwork_iterator = list_asssignedWork.iterator(); assignedwork_iterator.hasNext();) 
		{
			AssignedWork assignedWork = (AssignedWork) assignedwork_iterator.next();
			List<GradedWork> list_gradedWork = assignedWork.getGradedWork();
			for (Iterator<GradedWork> gradeWork_iterator = list_gradedWork.iterator(); gradeWork_iterator.hasNext();) 
			{
				GradedWork gradedWork = (GradedWork) gradeWork_iterator.next();
				if(assignedWorkAggregator.containsKey(assignedWork.getCategory()))
				{
					Double[] array = new Double[2];
					array[0] = assignedWorkAggregator.get(assignedWork.getCategory())[0]+ Double.valueOf(gradedWork.getGrade());
					array[1] = assignedWorkAggregator.get(assignedWork.getCategory())[1]+100.00;
					assignedWorkAggregator.put(assignedWork.getCategory(),array);
				}
				else
				{
					Double[] array = new Double[2];
					array[0] = Double.valueOf(gradedWork.getGrade());
					array[1] = 100.00;
					assignedWorkAggregator.put(assignedWork.getCategory(), array);
				}	
			}
		}
		return assignedWorkAggregator;
	}


	/**
	 * The getFinalGrade Helper method calculates the final letter for a student. 
	 * The Letter grade is calculated using the gradingSchema provided in the GradeBook, the student object
	 * @param student
	 * @param gradingSchemaMap
	 * @param gradeMap
	 * @return
	 */
	public String getFinalGrade(Student student, HashMap<String, Double> gradingSchemaMap, LetterGradesMapForClass gradeMap)
	{
		Double finalNumericGrade = 0.0;
		HashMap<String, Double[]> aggregateAssignedWorkForStudent = aggregateAssignedWorkGradeForEachStudent(student, gradingSchemaMap);
		Iterator<Entry<String, Double[]>> aggregateAssignedWorkIterator = aggregateAssignedWorkForStudent.entrySet().iterator();
		while(aggregateAssignedWorkIterator.hasNext())
		{
			Map.Entry<String, Double[]> pair = aggregateAssignedWorkIterator.next();
			Double catmarks = (Double)(gradingSchemaMap.get(pair.getKey())*pair.getValue()[0])/pair.getValue()[1];
			finalNumericGrade = finalNumericGrade + catmarks;
			
		}
		return (String) gradeMap.getValueFor(finalNumericGrade);
	}

}
