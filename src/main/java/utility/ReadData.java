package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData 
{
	 public static String readPropertyFile(String value) throws IOException
	  {
		  Properties prop=new Properties();
		  FileInputStream file=new FileInputStream("C:\\Users\\shrip\\eclipse-workspace\\Data_Driven_Test_Framework\\TestData\\config.properties.crossbrowser");
		  prop.load(file);
		  return prop.getProperty(value);
	  }
	 public static String readExcelFile(int RowNum,int ColNum) throws EncryptedDocumentException, IOException
	 {
		 FileInputStream File=new FileInputStream("C:\\Users\\shrip\\eclipse-workspace\\Data_Driven_Test_Framework\\TestData\\Book1.xlsx");
	     Sheet ab = WorkbookFactory.create(File).getSheet("Sheet1");
	     String value = ab.getRow(RowNum).getCell(ColNum).getStringCellValue();
	     return value;
	 
	 }
}
