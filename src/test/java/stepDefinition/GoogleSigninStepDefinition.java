package stepDefinition;

import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


import POM.GoogleSignin_3;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleSigninStepDefinition {
	
	
	WebDriver driver;
	GoogleSignin_3 signin;
	Properties p;
	Logger logger;
	
	@Given("User navigates to the forum")
	public void user_navigates_to_the_forum() {
		logger = BaseClass.getLogger();
		p= BaseClass.getProperties();
        logger.info("***Starting TC_3_GoogleSignin***");
		signin = new GoogleSignin_3(BaseClass.getDriver());
		signin.click_Forum();
    	logger.info("Click on Forum");
		
	    
	}
    @Then("User verify Forum Page Title")
    public void user_verify_forum_page_title(){
    	logger.info("***********verifing Forum Page Title ***********");
		String actual = signin.Forum_Page_Title();
		String expected = p.getProperty("ForumPageTitle");
		Assert.assertEquals(actual, expected);
		logger.info("Verified Forum Page title");
    	
    }
	@When("User clicks on the login\\/sign-up button")
	public void user_clicks_on_the_login_sign_up_button() {
		signin.click_Signup();
		logger.info("Click on signup");
	    
	}

	@When("User clicks on the Google")
	public void user_clicks_on_the_google() {
		signin.click_Google();
		logger.info("click on Google");
	    
	}

	@When("User enters invalid email address")
	public void user_enters_invalid_email_address() {
		signin.signin_With_Email();
		logger.info("Signin with wrong Email account deatils");
	    
	}

	@When("User clicks on Next button")
	public void user_clicks_on_next_button() {
		signin.email_NextButton_Click();
		BaseClass.logger.info("Click on Next button");
	    
	}

	@Then("User should see an error message about invalid email")
	public void user_should_see_an_error_message_about_invalid_email() {
		signin.get_Error_Message();
		BaseClass.logger.info("Capture the error message");
		BaseClass.logger.info("***Finished TC_3_GoogleSignin***");
	    
	}

}
