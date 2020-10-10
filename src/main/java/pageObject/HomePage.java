package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(xpath = "//*[text() = 'Welcome']")
	@CacheLookup
	public WebElement homepagetitle;

}
