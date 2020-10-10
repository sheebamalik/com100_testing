package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(xpath = "//*[text() = 'User Sign in']")
	@CacheLookup
	public WebElement logintitle;
	
	@FindBy(id = "txtEmail")
	@CacheLookup
	public WebElement email;
	
	@FindBy(id = "txtPassword")
	@CacheLookup
	public WebElement password;
	
	@FindBy(id = "lblLogin")
	@CacheLookup
	public WebElement submit;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	

}
