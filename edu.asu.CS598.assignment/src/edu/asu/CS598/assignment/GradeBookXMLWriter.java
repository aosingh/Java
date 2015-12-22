package edu.asu.CS598.assignment;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import edu.asu.CS598.assignment.applicationobjects.GradeBook;

public class GradeBookXMLWriter implements IGradeBookWriter {

	@Override
	public File writeGradeBook(GradeBook gradebook, String fileName) {
		// TODO Auto-generated method stub
		JAXBContext context;
		File f = new File(fileName+".xml");
		try 
		{
			if(gradebook.getGradingSchema() != null)
			{
				gradebook.setGradingSchema(null);
			}
			context = JAXBContext.newInstance(GradeBook.class);
			Marshaller marshal = context.createMarshaller();
			marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
					new Boolean(true));
			marshal.marshal(gradebook, f);
			
		}
		catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return f;

	}

}
