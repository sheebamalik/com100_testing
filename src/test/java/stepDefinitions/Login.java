package stepDefinitions;

import org.openqa.selenium.support.ui.ExpectedConditions;

import baseClass.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObject.HomePage;
import pageObject.LoginPage;

import java.util.concurrent.TimeUnit;

public class Login extends BaseClass {
	
	@Given("^User is in login page$")
	public void User_is_in_login_page(){
		LoginPage loginpage = new LoginPage();
		wait.until(ExpectedConditions.visibilityOf(loginpage.logintitle));
	}
	
	@When ("^User enters Username$")
	public void User_enters_Username() {
		LoginPage loginpage = new LoginPage();
		readConfigFile();
		wait.until(ExpectedConditions.visibilityOf(loginpage.email)).sendKeys(prop.getProperty("username"));
	}

	@And ("^User enters Password$")
	public void User_enters_Password() {
		LoginPage loginpage = new LoginPage();
		readConfigFile();
		wait.until(ExpectedConditions.visibilityOf(loginpage.password)).sendKeys(prop.getProperty("password"));
	}
	
	@And ("^User clicks on login button$")
	public void User_clicks_on_login_button() {
		LoginPage loginpage = new LoginPage();
		wait.until(ExpectedConditions.elementToBeClickable(loginpage.submit)).click();
	}
	
	@Then ("^User is able to login to his account$")
	public void User_is_able_to_login_to_his_account() {
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(),"Com100 - Home Page", "Login Failed");
	}
	
}
