package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utilities.WriteToExcel;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import POM.UpcomingBikes_1;

import factory.BaseClass;

public class UpcomingBikesStepDefinition {


	 WebDriver driver;
	 UpcomingBikes_1 up;
	 Properties p;
	 Logger logger;
	 
	@Given("User is on the homepage")
	public void user_is_on_the_homepage() {
		logger = BaseClass.getLogger();
		p= BaseClass.getProperties();
		logger.info("***Starting TC_1_UpcomingBikes");
		
	}
	@Then("User verifying home page title")
	public void user_verifying_home_page_title() {
		logger.info("*********verifying Home Title ***********");
		up = new UpcomingBikes_1((BaseClass.getDriver()));
		String actual = up.homeTitle();
		logger.info("got the page title");
		String expected = p.getProperty("HomePageTitle");
		Assert.assertEquals(actual, expected);
		
	}

	@When("User move to  New Bikes dropdown")
	public void user_move_to_new_bikes_dropdown() {
		up.new_Bikes_Dropdown(); 
		logger.info("Move to New Bikes Dropdown"); 
	}

	@When("User selects Upcoming Bikes")
	public void user_selects_upcoming_bikes() {
		up.selecting_Upcoming_Bikes();
		logger.info("Click on Upcoming Bikes");
	    
	}
	
	
	
	@Then("Verifing Upcoming Bike Page url")
	public void verifing_upcoming_bike_page_url() {
		logger.info("***********verifing Upcoming Bike Page url ***********");
		String actual = up.upcomingBikePageUrl();
		String expected = p.getProperty("UpcomingBikePageUrl");
		Assert.assertEquals(actual, expected);
		logger.info("Verified Upcoming Bike Page url");
	}

	@When("User selects Honda from the manufacturers dropdown")
	public void user_selects_honda_from_the_manufacturers_dropdown()  {
		up.manufacturers_Dropdown();
		logger.info("From manufacturers dropdown select 'Honda'");
	    
	}
	
	@Then("verify Honda title")
	public void verify_honda_title () {
     logger.info("***********verify Honda title ***********");
		
		String actual = up.verify_hondaTitle();
		String expected = p.getProperty("HondaTitle");
		Assert.assertEquals(actual, expected);
		logger.info("Verified Honda page title");
	}

	@When("User clicks on View More Bikes")
	public void user_clicks_on_view_more_bikes() throws InterruptedException {
		up.view_More_Bikes();
		logger.info("Click on ViewMore");
	    
	}

	@Then("User filter the bikes by price less than four lac and also displaying their name and expected launch date in India")
	public void user_filter_the_bikes_by_price_less_than_four_lac_and_also_displaying_their_name_and_expected_launch_date_in_india() throws IOException {
		
		Map<String,String[]>x = up.getdetails();
		logger.info("Get bike models, prices, and expected launch date for manufacturer 'Honda' & Bike price less than 4Lac");
    	WriteToExcel.writeToExcel(x);
	
    	logger.info("***Finished TC_1_UpcomingBikes");
	    
	}

	
}
