package edu.asu.CS598.assignment;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import edu.asu.CS598.assignment.GradeBookConstants.ClassType;
import edu.asu.CS598.assignment.GradeBookConstants.GradeBookFileType;
import edu.asu.CS598.assignment.applicationobjects.GradeBook;

public class GradeBookTester {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while(true)
		{
			System.out.println("Enter the class for which you want to generate the GradeBook");
			System.out.println("Type'UG' for Under Graduate");
			System.out.println("Type 'G' for Graduate");
			String userInput = scanner.next();
			IGradeDataReader reader = null;
			IGradeBookWriter writer = null;
			if(!(userInput.equals(ClassType.UG.toString()) || userInput.equals(ClassType.G.toString())))
			{
				System.out.println("Please Enter a valid input");
				System.out.println();
				continue;
			}
			else if(userInput.equals(ClassType.UG.toString()))
			{
				reader = GradeDataReaderFactory.gradeDataReaderFactoryMethod(ClassType.UG);
			}
			else
			{
				reader = GradeDataReaderFactory.gradeDataReaderFactoryMethod(ClassType.G);
			}
			System.out.println("Kindly specify the file format in which you would like the GradeBook");
			System.out.println("Type'HTML' for HTML format");
			System.out.println("Type 'CSV' for CSV format");
			System.out.println("Type 'XML' for XML format");
			String fileTypeInput = scanner.next();
			if(!(fileTypeInput.equals(GradeBookFileType.CSV.toString()) || fileTypeInput.equals(GradeBookFileType.XML.toString())|| fileTypeInput.equals(GradeBookFileType.HTML.toString())))
			{
				System.out.println("Please Specify a valid output file Type");
				continue;
				
			}
			else if(fileTypeInput.equals(GradeBookFileType.CSV.toString()))
			{
				writer = GradeDataWriterFactory.gradeDataWriterFactory(GradeBookFileType.CSV);
			}
			else if(fileTypeInput.equals(GradeBookFileType.XML.toString()))
			{
				writer = GradeDataWriterFactory.gradeDataWriterFactory(GradeBookFileType.XML);
			}
			else
			{
				writer = GradeDataWriterFactory.gradeDataWriterFactory(GradeBookFileType.HTML);
			}
			
			System.out.println("Please provide the complete file path from which to read the grades");
			String filePath = scanner.next();

			GradeBook gradeBook = reader.readGradesfromFile(new File(filePath));
			GradeFileDataValidator gradeDataValidator = GradeFileDataValidator.getInstance();
			if(!(gradeDataValidator.isGoodFile(gradeBook)))
			{
				System.out.println("The file data is incorrect");
				System.out.println();
				System.out.println("Do you want to continue ? Press 'Y' for yes or 'N' for no");
				String response = scanner.next();
				if(response.equalsIgnoreCase("Y"))
				{
					continue;
				}
				else
				{
					scanner.close();
					break;
				}
			}
			else
			{
				IFinalLetterGradeCalculator finalGradeCalculator = FinalGradeCalculatorForClass.getInstance();
				LetterGradesMapForClass gradeMap = finalGradeCalculator.createGradeMapperForClass();
				gradeBook = finalGradeCalculator.convertLetterGradeToNumericGrade(gradeBook, gradeMap);
				gradeBook = finalGradeCalculator.calculateFinalGradeFromNumericGrades(gradeBook, gradeMap);
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss", Locale.US);
				File outputFile = writer.writeGradeBook(gradeBook, gradeBook.getClazz()+"_"+dateFormat.format(new Date()));
				System.out.println("Awesome, GradeBook successfully generated at : "+outputFile.getAbsolutePath());

			}
			System.out.println("Do you want to continue ? Press 'Y' for yes or 'N' for no");
			String response = scanner.next();
			scanner.close();
			if(response.equalsIgnoreCase("N"))
			{
				break;
			}
		}
	}

}
