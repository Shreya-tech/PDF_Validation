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

	String loc = "\\src\\test\\resources\\File\\Sample Invoice.pdf";

	@Test
	public void Test1() throws IOException {

		String pdfFileInText = ExtractDataFromPDFMethods.readPdfContent("file:///C:/Users/shreyasaxena/eclipse-workspace/DataValidationOnPDF/src/test/resources/File/Sample Invoice.pdf");
		String lines[] = pdfFileInText.split("\\n");

		DataProperties CustomerInfoData = null, InvoiceInfoData = null;
		DataFromConfig ConfigDataOfCustomer = null, ConfigDataOfInvoice = null;
		
		Map<String, String> c_properties = new HashMap<String, String>();
		Map<String, String> i_properties = new HashMap<String, String>();
		Map<String, String> conf_properties = new HashMap<String, String>();

		CustomerInfoData = FetchData.FetchCustomerInfo(lines, CustomerInfoData, c_properties);
		InvoiceInfoData = FetchData.FetchInvoiceInfo(lines, InvoiceInfoData, i_properties);
		ConfigDataOfCustomer = FetchData.FetchFromConfigFile2(conf_properties, "Customer info");
		ConfigDataOfInvoice = FetchData.FetchFromConfigFile2(conf_properties, "Invoice info");

		CustomerInfoData.Display();
		InvoiceInfoData.Display();
		
		//Assert.assertTrue(DataProperties.Compare(InvoiceInfoData, ConfigData));

		Assert.assertTrue(DataFromConfig.CheckData(CustomerInfoData, ConfigDataOfCustomer));

	}

}
