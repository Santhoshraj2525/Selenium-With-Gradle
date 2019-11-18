package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.qa.basetest.BaseTest;

public class TestUtil extends BaseTest{
	
	public TestUtil() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "\\Selenium\\Screenshots\\" + System.currentTimeMillis() + ".png"));
		
		/*File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\Selenium\\Screenshots\\defect1.png"));*/
	}

}
