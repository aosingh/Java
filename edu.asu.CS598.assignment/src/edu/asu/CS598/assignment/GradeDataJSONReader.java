/**
 * 
 */
package edu.asu.CS598.assignment;

import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.exc.UnrecognizedPropertyException;

import edu.asu.CS598.assignment.applicationobjects.GradeBook;

/**
 * @author abhi
 *
 */
public class GradeDataJSONReader implements IGradeDataReader{

	@Override
	public GradeBook readGradesfromFile(File f) {
		GradeBook gradeBook = null;
		try
		{

			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationConfig.Feature.UNWRAP_ROOT_VALUE , true);
			mapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
			gradeBook = mapper.readValue(f, GradeBook.class);
		} 
		catch(NoSuchFileException exception)
		{
			System.out.println("The file provided in Input does not exists"+exception);
		}
		catch(UnrecognizedPropertyException exception)
		{
			System.out.println("The property in the JSON file is not recognized."+exception);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return gradeBook;
	}
}
