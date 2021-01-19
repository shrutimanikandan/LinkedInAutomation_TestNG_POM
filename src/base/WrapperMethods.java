package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

public class WrapperMethods {

	public ChromeDriver driver;
	public String excelFileName;
	
	@BeforeMethod
	public void startApp() {
		WebDriverManager.chromedriver().setup();
		System.out.println("before initialisation");
		//System.setProperty("webdriver.chrome.driver","\\Users\\hariprasadshanmugavelu\\Downloads\\chromedriver.exec");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("chrome://settings/clearBrowserData");
		driver.findElementByXPath("//settings-ui").sendKeys(Keys.ENTER);
		driver.get("https://www.linkedin.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		System.out.println("done");

	}
	
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException {
		
		return ReadExcel.readData(excelFileName);

	}
}
