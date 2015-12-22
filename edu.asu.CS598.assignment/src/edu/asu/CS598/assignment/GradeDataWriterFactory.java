package edu.asu.CS598.assignment;

import edu.asu.CS598.assignment.GradeBookConstants.GradeBookFileType;

public class GradeDataWriterFactory {


	public static IGradeBookWriter gradeDataWriterFactory(GradeBookFileType gradeBookFileType)
	{
		IGradeBookWriter gradeBookWriter = null;
		switch (gradeBookFileType)
		{
		case CSV:
			gradeBookWriter = new GradeBookCSVWriter();
			break;
		case HTML:
			gradeBookWriter = new GradeBookHTMLWriter();
			break;
		case XML:
			gradeBookWriter = new GradeBookXMLWriter();
			break;
		}
		return gradeBookWriter;
	}

}
