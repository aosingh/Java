/**
 * 
 */
package edu.asu.CS598.assignment;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import edu.asu.CS598.assignment.applicationobjects.GradeBook;

/**
 * @author abhi
 *
 */
public class GradeDataXMLReader implements IGradeDataReader {
	

	@Override
	public GradeBook readGradesfromFile(File f) {
		JAXBContext context;
		GradeBook gradeBook = null;
		try
		{
			context = JAXBContext.newInstance(GradeBook.class);
			Unmarshaller um = context.createUnmarshaller();
			gradeBook = (GradeBook) um.unmarshal(f);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return gradeBook;
		
		
	}

	
}
