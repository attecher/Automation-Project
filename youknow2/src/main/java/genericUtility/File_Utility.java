package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {
	
	
	public String getDataFromProp(String Key) throws IOException {
		FileInputStream fis= new FileInputStream("D:\\java qspider\\youknow\\src\\test\\resources\\commonData.properties");
		
		Properties prop=new Properties();
		prop.load(fis);
		String VALUE=prop.getProperty(Key);
		fis.close();
		
		return VALUE;
		
		
		
	}

}
