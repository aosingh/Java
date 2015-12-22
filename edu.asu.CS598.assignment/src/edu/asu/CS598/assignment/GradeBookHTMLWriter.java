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

public class GradeBookHTMLWriter implements IGradeBookWriter {

	@Override
	/**
	 * This method will write the grade book in HTML format and return the file type
	 */
	public File writeGradeBook(GradeBook gradebook, String fileName)
	{

		File f = new File(fileName+".html");
		BufferedWriter out;
		try
		{
			FileWriter fstream;
			fstream = new FileWriter(f);
			out = new BufferedWriter(fstream);
			out.write("<html>");
			out.write("<head>");
			out.append("<style>" +
					"td { padding: 6px; border: 1px solid #ccc; text-align: left; }" + 
					"th { background: #333; color: white; font-weight: bold; padding: 6px; border: 1px solid #ccc; text-align: left;}" +
					"</style>");
			out.write("</head>");
			out.write("<table>");
			out.write("<th> Name </th>");
			out.write("<th> ID </th>");
			List<Student> list_student = gradebook.getGrades().getStudent();
			List<AssignedWork> list_AssignedWork = list_student.get(0).getAssignedWork();
			for (Iterator<AssignedWork> iterator = list_AssignedWork.iterator(); iterator.hasNext();) 
			{

				AssignedWork assignedWork = (AssignedWork) iterator.next();
				List<GradedWork> list_gradeWork = assignedWork.getGradedWork();
				for (Iterator<GradedWork> iterator2 = list_gradeWork.iterator(); iterator2.hasNext();)
				{
					GradedWork gradedWork = (GradedWork) iterator2.next();
					out.write("<th>" +gradedWork.getName()+ "</th>");

				}
			}
			out.write("<th> Grade </th>");

			for(Iterator<Student> student_iterator = list_student.iterator(); student_iterator.hasNext();)
			{
				Student student = student_iterator.next();
				list_AssignedWork = student.getAssignedWork();
				out.write("<tr>");
				out.write("<td>"+student.getName()+"</td>");
				out.write("<td>"+student.getID()+"</td>");
				for (Iterator<AssignedWork> iterator = list_AssignedWork.iterator(); iterator.hasNext();) 
				{

					AssignedWork assignedWork = (AssignedWork) iterator.next();
					List<GradedWork> list_gradeWork = assignedWork.getGradedWork();
					for (Iterator<GradedWork> iterator2 = list_gradeWork.iterator(); iterator2.hasNext();)
					{
						GradedWork gradedWork = (GradedWork) iterator2.next();

						out.write("<td>" +gradedWork.getGrade()+ "</td>");
					}
				}
				out.write("<td>"+student.getLetterGrade()+"</td>");
				out.write("</tr>");
			}
			out.write("</table>");
			out.write("</body>");
			out.write("</html>");
			out.flush();
			out.close();
		fstream.close();

		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return f;
	}

}
