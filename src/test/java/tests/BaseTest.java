package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

	// Creating variable to connect config.properties file
	static File file = new File(System.getProperty("user.dir")+".\\src\\test\\resources\\File\\config.properties");
	static FileInputStream fis = null;
	public static Properties prop = new Properties();
	static {
		try {
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
