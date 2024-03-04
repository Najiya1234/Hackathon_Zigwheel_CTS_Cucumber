package stepDefinition;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import POM.UpcomingBikes_1;
import POM.UsedCars_2;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsedCarsStepDefinition {
	WebDriver driver;
	UsedCars_2 uc;
	Logger logger;
	
	@Given("User checking visibility of used cars dropdown")
	public void user_checking_visibility_of_used_cars_dropdown() {
		uc = new UsedCars_2(BaseClass.getDriver());
		logger = BaseClass.getLogger();
		 logger.info("***Starting TC_2_UsedCars****");
		 uc.used_Cars_Dropdown_Visible();
		 logger.info("Checking visibility of used cars dropdown");
	}
	
	@When("User move to the Used Cars Dropdown")
	public void user_move_to_the_used_cars_dropdown() throws InterruptedException {
	
		logger.info("******Starting TC_2_UsedCars****");
    	uc = new UsedCars_2(BaseClass.getDriver());
    	uc.move_To_Dropdown();
    	logger.info("Move to used cars dropdown");
	    
	}

	@When("User select Chennai from the dropdown")
	public void user_select_chennai_from_the_dropdown() {
		uc.select_Chennai_Used_Cars();
		logger.info("Click on Chennai city");
	   
	}

	@Then("User should extract the list of popular models and display the models")
	public void user_should_extract_the_list_of_popular_models_and_display_the_models() {
		uc.popular_Model(); 
		logger.info("Extracting all the popular models");
		logger.info("***Finished TC_2_UsedCars****");
	}


}
