package utils;

import tests.BaseTest;

import java.util.Map;

@SuppressWarnings("UnusedAssignment")
public class FetchData {

	public static DataProperties FetchCustomerInfo(String[] lines, DataProperties data, Map<String, String> properties) {
		String section, content;
		// ---------------------Fetching data ------------
		for (int i = 0; i < lines.length; i++) {

			// ------------------ Customer Info ---------------------
			if (lines[i].contains("Customer Info ")) {
				section = lines[i];
				i++;
				if (lines[i].contains("Customer Name:")) {
					// -- Customer name
					content = lines[i].substring(lines[i].indexOf("e: ") + 3, lines[i].lastIndexOf(" Customer ID"));
					properties.put("Customer Name", content);
					data = new DataProperties(section, properties);

					// -- Customer id
					content = lines[i].substring(lines[i].indexOf("D: ") + 3, lines[i].lastIndexOf(" "));
					properties.put("Customer ID", content);
					data = new DataProperties(section, properties);

					i++;
				}
				if (lines[i].contains("Phone Number:")) {
					// -- Customer Phone Number
					content = lines[i].substring(lines[i].indexOf("r: ") + 3, lines[i].lastIndexOf(" Address"));
					properties.put("Phone Number", content);
					data = new DataProperties(section, properties);

					// -- Customer Address
					content = lines[i].substring(lines[i].indexOf("s: ") + 3, lines[i].lastIndexOf(" "));
					properties.put("Address", content);
					data = new DataProperties(section, properties);

					i++;
				}

			}

		}
		return data;
	}
	
	public static DataProperties FetchInvoiceInfo(String[] lines,DataProperties data,Map<String, String> i_properties) {
		String section, content;
		for (int i = 0; i < lines.length; i++) {
			// ------------------ Invoice Info ---------------------
			if (lines[i].contains("Invoice Info ")) {
				section = lines[i];
				i++;
				if (lines[i].contains("Company Name:")) {
					// -- Company Name
					content = lines[i].substring(lines[i].indexOf("e: ") + 3, lines[i].lastIndexOf(" Invoice"));
					i_properties.put("Company Name", content);
					data = new DataProperties(section, i_properties);

					// -- Invoice ID
					content = lines[i].substring(lines[i].indexOf("#: ") + 3, lines[i].lastIndexOf(" "));
					i_properties.put("Invoice ID", content);
					data = new DataProperties(section, i_properties);

					i++;
				}
				if (lines[i].contains("Company Phone:")) {
					// -- Company Phone
					content = lines[i].substring(lines[i].indexOf("e: ") + 3, lines[i].lastIndexOf(" Company"));
					i_properties.put("Company Phone", content);
					data = new DataProperties(section, i_properties);

					// -- Company Address
					content = lines[i].substring(lines[i].indexOf("s: ") + 3, lines[i].lastIndexOf(" "));
					i_properties.put("Company Address", content);
					data = new DataProperties(section, i_properties);

					i++;
				}
				if (lines[i].contains("Date Of Purchase:")) {
					// -- Date Of Purchase
					content = lines[i].substring(lines[i].indexOf("e: ") + 3, lines[i].lastIndexOf(" Date"));
					i_properties.put("Date Of Purchase", content);
					data = new DataProperties(section, i_properties);

					// -- Date Delivered
					content = lines[i].substring(lines[i].indexOf("d: ") + 3, lines[i].lastIndexOf(" "));
					i_properties.put("Date Delivered", content);
					data = new DataProperties(section, i_properties);

					i++;
				}
			}

		}
		return data;
	}
	
	public static DataProperties FetchFromConfigFile(Map<String, String> conf_properties) {
		String section;
		DataProperties data = null;
		section = "Config File";
		// -- Customer info
		conf_properties.put("Customer Name", BaseTest.prop.getProperty("C_Name"));			
		conf_properties.put("Customer ID", BaseTest.prop.getProperty("C_ID"));		
		conf_properties.put("Phone Number", BaseTest.prop.getProperty("C_Num"));		
		conf_properties.put("Address", BaseTest.prop.getProperty("Add"));	
		
		// -- InInvoice info
		conf_properties.put("Company Name", BaseTest.prop.getProperty("Com_name"));		
		conf_properties.put("Invoice ID", BaseTest.prop.getProperty("Invoice_id"));		
		conf_properties.put("Company Phone", BaseTest.prop.getProperty("Com_Phone"));		
		conf_properties.put("Company Address", BaseTest.prop.getProperty("Com_Add"));		
		conf_properties.put("Date Of Purchase", BaseTest.prop.getProperty("DoP"));	
		conf_properties.put("Date Delivered", BaseTest.prop.getProperty("DDel"));	
		
		data = new DataProperties(section,conf_properties);
		return data;
	}

	public static DataFromConfig FetchFromConfigFile2(Map<String, String> conf_properties, String section) {
		DataFromConfig data = null;
		
		if(section.equalsIgnoreCase("Customer info")) {
			// -- Customer info
			conf_properties.put("Customer Name", BaseTest.prop.getProperty("C_Name"));			
			conf_properties.put("Customer ID", BaseTest.prop.getProperty("C_ID"));		
			conf_properties.put("Phone Number", BaseTest.prop.getProperty("C_Num"));		
			conf_properties.put("Address", BaseTest.prop.getProperty("Add"));	
			
			data = new DataFromConfig(section,conf_properties); 
		}
		
		if(section.equalsIgnoreCase("Invoice info")) {
			// -- InInvoice info
			conf_properties.put("Company Name", BaseTest.prop.getProperty("Com_name"));		
			conf_properties.put("Invoice ID", BaseTest.prop.getProperty("Invoice_id"));		
			conf_properties.put("Company Phone", BaseTest.prop.getProperty("Com_Phone"));		
			conf_properties.put("Company Address", BaseTest.prop.getProperty("Com_Add"));		
			conf_properties.put("Date Of Purchase", BaseTest.prop.getProperty("DoP"));	
			conf_properties.put("Date Delivered", BaseTest.prop.getProperty("DDel"));	
			
			data = new DataFromConfig(section,conf_properties); 
		}
		
		
		return data;
	}


}
