package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DataFromConfig;
import utils.DataProperties;
import utils.ExtractDataFromPDFMethods;
import utils.FetchData;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DataTest5 extends BaseTest {

	String loc = "file:///C:/Users/shreyasaxena/eclipse-workspace/DataValidationOnPDF/src/test/resources/File/Sample Invoice.pdf";

	@Test
	public void Test1() throws IOException {

		String pdfFileInText = ExtractDataFromPDFMethods.readPdfContent(loc);
		String[] lines = pdfFileInText.split("\\n");

		DataProperties CustomerInfoData = null, InvoiceInfoData = null;
		
		Map<String, String> c_properties = new HashMap<>();
		Map<String, String> i_properties = new HashMap<>();

		CustomerInfoData = FetchData.FetchCustomerInfo(lines, CustomerInfoData, c_properties);
		InvoiceInfoData = FetchData.FetchInvoiceInfo(lines, InvoiceInfoData, i_properties);

		CustomerInfoData.Display();
		InvoiceInfoData.Display();

		//Assert.assertTrue(DataProperties.Compare(InvoiceInfoData, ConfigData));

	}

}
