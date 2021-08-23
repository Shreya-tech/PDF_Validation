package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataTest6 extends BaseTest {
	String loc = "file:///C:/Users/shreyasaxena/Desktop/github/PDF_Validation/src/test/resources/File/Sample Invoice.pdf";

	@Test
	public void Test1() throws IOException {

		String pdfFileInText = ExtractDataFromPDFMethods.readPdfContent(loc);
		String[] lines = pdfFileInText.split("\\n");
		String path = System.getProperty("user.dir")+"\\src\\main\\resources\\ExpectedData.csv";

		DataProperties CustomerInfoData = null, InvoiceInfoData = null;
		ExcelModel ExpectedData = null;

		List<String> e_properties = new ArrayList<>();
		Map<String, String> c_properties = new HashMap<>();
		Map<String, String> i_properties = new HashMap<>();
		//Map<String, String> e_properties = new HashMap<>();

		CustomerInfoData = FetchData.FetchCustomerInfo(lines, CustomerInfoData, c_properties);
		InvoiceInfoData = FetchData.FetchInvoiceInfo(lines, InvoiceInfoData, i_properties);
		ExpectedData = ExcelReader.ReadCSV(path,e_properties);

		CustomerInfoData.Display();
		InvoiceInfoData.Display();
		ExpectedData.Display();

		Assert.assertTrue(Compare.check(CustomerInfoData,ExpectedData));

	}

}
