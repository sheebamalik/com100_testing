package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static InputStream is;
	public static Properties prop = new Properties();
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static int PAGE_LOAD_TIMEOUT = 20;
	
	public void readConfigFile(){
	
		try {
			File file = new File ("src/main/java/config/config.properties");
			is = new FileInputStream(file);
			prop.load(is);
		}

		catch (Exception e) {
			System.out.println("Config file not found");
		}	
	}
	
	public void captureScreenshot() throws IOException {
		File source_file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(source_file, new File(currentDir + "/screenshots/"));
	}
}
