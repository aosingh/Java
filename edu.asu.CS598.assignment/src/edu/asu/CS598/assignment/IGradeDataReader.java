/**
 * 
 */
package edu.asu.CS598.assignment;

import java.io.File;

import edu.asu.CS598.assignment.applicationobjects.GradeBook;

/**
 * @author abhi
 *
 */
public interface IGradeDataReader {
	
	
	/**
	 * This API reads the GradeBook from the file passed in input and returns the GradeBook Object.
	 * As of now, two types of input file types are supported
	 * <ul>
	 * <li>JSON</li>
	 * <li>XML</li>
	 * <ul>
	 * @param f
	 * @return
	 */
	public GradeBook readGradesfromFile(File file);

}
