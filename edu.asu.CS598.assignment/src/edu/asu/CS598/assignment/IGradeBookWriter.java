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
public interface IGradeBookWriter {
	
	
	/**
	 * This API will write the GradeBook in desired Format.
	 * The available output file formats are
	 * <ul>
	 * <li>HTML</li>
	 * <li>XML</li>
	 * <li>CSV</li>
	 * <ul>
	 * @param gradebook
	 * @param filename
	 * @return
	 */
	public File writeGradeBook(GradeBook gradebook, String filename);

}
