package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.WrapperMethods;

public class LinkedinHomePage extends WrapperMethods {
	
	public LinkedinHomePage(ChromeDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		System.out.println("from homepage");
	}

    @FindBy(how=How.XPATH , using="//div[@id='ember20']/input[@class]")
    WebElement eleSearchbox;
    
    public LinkedinHomePage searchJob() throws InterruptedException {
		
    	eleSearchbox.sendKeys("LinkedIn");
    	return this;

	}
    
    @FindBy(how=How.XPATH , using="//div[@role='option'][1]")
    WebElement eleOption1;
    public LinkedinHomePage clickOption() throws InterruptedException {
		
    	eleOption1.click();
    	WebElement eleClear = driver.findElementByXPath("//span[text()='Clear history']");
    	if(eleClear.isDisplayed()) {
    		eleClear.click();
    		System.out.println("element clear button in popup clicked");
    		eleSearchbox.sendKeys("LinkedIn in Jobs");
    		eleSearchbox.sendKeys(Keys.ENTER);
    		}
    	return this;

	}
    
    
 
    public LinkedinSearchPage scrollDown() throws InterruptedException{
    	
       JavascriptExecutor js = (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,10000)");
    
       return new LinkedinSearchPage(driver);
    
    }
}
