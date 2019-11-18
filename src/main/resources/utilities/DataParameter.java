package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataParameter {

	public String sDataFileName = DataMappingConstants.dataFile;
	public static String sSheetName = DataMappingConstants.sheetName;

	@DataProvider (name = "Auth")
	public static Iterator<Object[]> testData(Method m) throws Exception{
		ArrayList<Object[]> testDataValues = new ArrayList<Object[]>();
		String testCaseName = m.getName().toString();
		testDataValues = DataParameter.getTestDatawithSingledimension(testCaseName);
		return testDataValues.iterator();
	}

	public static ArrayList<Object[]> getTestDatawithSingledimension(String sTestCaseName) throws Exception{
		ExcelReader reader = new ExcelReader("C:\\Users\\hp\\eclipse-workspace\\CoreJavaAutomation\\src\\main\\resources\\TestData\\TestData.xlsx");
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		for(int rowNum=2;rowNum<=reader.getRowCount(sSheetName);rowNum++){
			String sTestName = reader.getCellData(sSheetName, "TestCaseName", rowNum);
			if(sTestName.equals(sTestCaseName)) {
				String UserID = reader.getCellData(sSheetName, "UserId", rowNum);
				String FirstName = reader.getCellData(sSheetName, "FirstName", rowNum);
				String LastName = reader.getCellData(sSheetName, "LastName", rowNum);
				String Email = reader.getCellData(sSheetName, "Email", rowNum);
				String Description = reader.getCellData(sSheetName, "Description", rowNum);
				myData.add(new Object[] {UserID,FirstName,LastName,Email,Description});
			}
		}
		return myData;
	}


	@DataProvider (name="TestData")
	public Object[][] getTestData(Method m){
		String testCase = m.getName().toString();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(sDataFileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Workbook book = null;
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet sheet = book.getSheet(sSheetName);
		
		//Getting the row of our test data array
		int count=0;
		for(int q=0;q<=sheet.getLastRowNum();q++) {
			String testCaseINXL = sheet.getRow(q).getCell(0).toString();
			if(testCaseINXL.equals(testCase)) {
				count++;
			}
		}

		//Initialize the test data object array
		Object[][] data=new Object[count][sheet.getRow(0).getLastCellNum()];
		
		//Storing the data in to the test data object array
		int temp=0;
		for(int i=0;i<=sheet.getLastRowNum();i++) {
					String testCaseINXL = sheet.getRow(i).getCell(0).toString();
					if(testCaseINXL.equals(testCase)) {
					for(int j=0;j<sheet.getRow(0).getLastCellNum();j++) {
						data[temp][j] = sheet.getRow(i).getCell(j).toString();
					}temp++;
				}
			}
		return data;
	}
}
