package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import base.WrapperMethods;

public class LoginPage extends WrapperMethods {
	
	public LoginPage(ChromeDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

    @FindBy(how=How.CLASS_NAME , using="input__input")
    WebElement eleUserName;
    
    public LoginPage enterUsername(String Username) throws InterruptedException {
		
    	eleUserName.sendKeys(Username);
		return this;

	}
    
    @FindBy(how=How.ID,using="session_password") 
    WebElement elePassword;
	
	public LoginPage enterPassword(String Password) {
		elePassword.sendKeys(Password);
		return this;
	}
	
	
	@FindBy(how=How.XPATH,using="//button[@type='submit']") WebElement eleLogin;
	public LinkedinHomePage clickLogin() {
		eleLogin.click();
		
		return new LinkedinHomePage(driver);

	}
	
	

}
