package edu.asu.CS598.assignment;

import edu.asu.CS598.assignment.GradeBookConstants.ClassType;



public class GradeDataReaderFactory {

	public static IGradeDataReader gradeDataReaderFactoryMethod(ClassType classtype)
	{
		IGradeDataReader dataReader = null;
		switch(classtype){
		case UG:
			dataReader = new GradeDataJSONReader();
			break;
		case G:
			dataReader = new GradeDataXMLReader();
			break;
		}
		return dataReader;

	}

}
