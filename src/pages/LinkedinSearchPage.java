package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.WrapperMethods;

public class LinkedinSearchPage extends WrapperMethods {
	
	public LinkedinSearchPage(ChromeDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("from searchpage");
	}

	@FindBy(how=How.XPATH , using="//input[contains(@id,'location-id')]")
	WebElement eleLocation;
	    
    public LinkedinSearchPage selectLoc() throws InterruptedException {
    	
    	driver.findElementByXPath("//a[text()='See all job results']").click();
			
    	eleLocation.sendKeys("Dubai, United Arab Emirates");
	    return this;

		}
    
   
    
    
}
