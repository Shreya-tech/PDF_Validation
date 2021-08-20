package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DataProperties {

	private String sectionName;
	private Map<String, String> contents = new HashMap<String, String>();

	public DataProperties(String section_name, Map<String, String> content) {
		this.sectionName = section_name;
		this.contents = content;
	}

	// ----- Setters
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public void setContent(Map<String, String> content) {
		this.contents = content;
	}

	// ----- Getters
	public String getSectionName() {
		return sectionName;
	}

	public Map<String, String> getContent() {
		return contents;
	}

	// --- Display
	public void Display() {
		System.out.print(this.sectionName);
		System.out.println(this.contents);
	}

	// -- Get Value from Contents
	public String getValue(String key) {
		String value = null;
		for (String i : this.contents.keySet()) {
			if (key.contains(i))
				value = this.contents.get(i);
		}
		return value;
	}

	public static Boolean Compare(DataProperties a, DataProperties b) {
		Boolean check = false;
		
		if (a.getSectionName() == b.getSectionName()) {
			Set <String> setA = a.getContent().keySet();
			Set <String> setB = b.getContent().keySet();
			
			for(String keyA : setA) {
				for(String keyB : setB) {
					if(keyA == keyB) {
						
						String valueA = a.getContent().get(keyA);
						String valueB = b.getContent().get(keyB);
						
						check = valueB.contains(valueA);
						System.out.println("value A : "+valueA+"\t value B: "+valueB);
						System.out.println("------> "+check);
						if(check==false)
							break;
					}
				}
			}
//			System.out.println(a.getContent().equals(b.getContent()));
			
		}
		return check;
	}

}
