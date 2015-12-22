package pack.eligibleproducts.develop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.Enumeration;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.example.eligibleproductinfo.EligibleProductListType;
import org.example.eligibleproductinfo.MutuallyExclusiveProductType;


public class MutualExclusiveProductPopulate {



	public static final String ELIGIBLE_PRODUCT_XML = "F:\\work\\pack.eligibleproducts.develop\\src\\pack\\eligibleproducts\\develop\\EligibleProductInfo.xml";

	public static void main(String[] args) {

		JAXBContext context;
		try {
			context = JAXBContext.newInstance(EligibleProductListType.class);
			EligibleProductListType eligibleProductList = new EligibleProductListType();
			Unmarshaller um = context.createUnmarshaller();
			eligibleProductList = (EligibleProductListType)um.unmarshal(new FileReader(ELIGIBLE_PRODUCT_XML));
			System.out.println("List Size "+eligibleProductList.getEligibleProduct().size());

			for(int i=0; i<eligibleProductList.getEligibleProduct().size(); i++ )
			{
				int productID = eligibleProductList.getEligibleProduct().get(i).getProductId();
				String strProductId = Integer.toString(productID);
				System.out.println(productID+" is mutually exclusive with productid "+ getMutuallyExclusiveProduct(strProductId));

				if(getMutuallyExclusiveProduct(strProductId)!= null)
				{
					eligibleProductList.getEligibleProduct().get(i).setIsMutuallyExclusive(true);
					MutuallyExclusiveProductType mutuallyExclusiveProduct = new MutuallyExclusiveProductType();
					mutuallyExclusiveProduct.setProductId(Integer.parseInt(getMutuallyExclusiveProduct(strProductId)));
					mutuallyExclusiveProduct.setProductDescription("Temp_description");
					eligibleProductList.getEligibleProduct().get(i).setMutuallyExclusiveProduct(mutuallyExclusiveProduct);
				}

			}
			
			Marshaller marshal = context.createMarshaller();
			marshal.marshal(eligibleProductList, new File(ELIGIBLE_PRODUCT_XML));



		}
		catch ( Exception e) {
			e.printStackTrace();
		}


	}


	public static String getMutuallyExclusiveProduct(String ProductID)
	{
		File file = new File("F:\\work\\pack.eligibleproducts.develop\\src\\pack\\eligibleproducts\\develop\\MutuallyExclusiveProducts.xml");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		Properties properties = new Properties();
		try {
			properties.loadFromXML(fileInput);
		} catch (InvalidPropertiesFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fileInput.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Enumeration<Object> enuKeys = properties.keys();
		//while (enuKeys.hasMoreElements()) {
		//String key = (String) enuKeys.nextElement();
		return properties.getProperty(ProductID);
		//System.out.println(key + ": " + value);

	}
}
