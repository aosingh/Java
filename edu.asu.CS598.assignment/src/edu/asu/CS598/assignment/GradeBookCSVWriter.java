package edu.asu.CS598.assignment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

import edu.asu.CS598.assignment.applicationobjects.GradeBook;
import edu.asu.CS598.assignment.applicationobjects.GradeBook.Grades.Student;
import edu.asu.CS598.assignment.applicationobjects.GradeBook.Grades.Student.AssignedWork;
import edu.asu.CS598.assignment.applicationobjects.GradeBook.Grades.Student.AssignedWork.GradedWork;

public class GradeBookCSVWriter implements IGradeBookWriter {

	@Override
	public File writeGradeBook(GradeBook gradebook, String fileName) {
		
		File f = new File(fileName+".csv");
		BufferedWriter out;
		try
		{
			FileWriter fstream;
			fstream = new FileWriter(f);
			out = new BufferedWriter(fstream);
			out.append("Name");
			out.append(",");
			out.write("ID");
			out.append(",");
			List<Student> list_student = gradebook.getGrades().getStudent();
			List<AssignedWork> list_AssignedWork = list_student.get(0).getAssignedWork();
			for (Iterator<AssignedWork> iterator = list_AssignedWork.iterator(); iterator.hasNext();) 
			{

				AssignedWork assignedWork = (AssignedWork) iterator.next();
				List<GradedWork> list_gradeWork = assignedWork.getGradedWork();
				for (Iterator<GradedWork> iterator2 = list_gradeWork.iterator(); iterator2.hasNext();)
				{
					GradedWork gradedWork = (GradedWork) iterator2.next();
					out.append(gradedWork.getName());
					out.append(",");

				}
			}
			out.append("Grade");
			out.append("\n");
			

			for(Iterator<Student> student_iterator = list_student.iterator(); student_iterator.hasNext();)
			{
				Student student = student_iterator.next();
				list_AssignedWork = student.getAssignedWork();
				out.append(student.getName());
				out.append(",");
				out.append(student.getID());
				out.append(",");
				for (Iterator<AssignedWork> iterator = list_AssignedWork.iterator(); iterator.hasNext();) 
				{

					AssignedWork assignedWork = (AssignedWork) iterator.next();
					List<GradedWork> list_gradeWork = assignedWork.getGradedWork();
					for (Iterator<GradedWork> iterator2 = list_gradeWork.iterator(); iterator2.hasNext();)
					{
						GradedWork gradedWork = (GradedWork) iterator2.next();

						out.append(gradedWork.getGrade());
						out.append(",");
					}
				}
				out.append(student.getLetterGrade());
				out.append("\n");
			}
			out.flush();
			out.close();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			

			e.printStackTrace();
		}
		return f;

			}

}
