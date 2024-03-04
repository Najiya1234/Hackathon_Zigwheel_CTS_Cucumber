package stepDefinition;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks {
	
	static WebDriver driver;
	static Properties p;
	static Logger logger;
    
	@BeforeAll
   public static void setup() throws IOException
   {
   	driver=BaseClass.initializeDriver();
   	logger=BaseClass.initializelogger();
   	p=BaseClass.getProperties();
   	logger.info("started running tests");
//   	p=BaseClass.getProperties();
//   	driver.get(p.getProperty("appURL"));
//   	driver.manage().window().maximize();
   
   			
	}
		
   
   @AfterAll
   //public static void tearDown(Scenario scenario) {
   public static void tearDown() {	
      driver.quit();
      
   }
   

   @AfterStep
   public void addScreenshot(Scenario scenario) {
       
   	// this is for cucumber junit report
	   if((scenario.isFailed())||(scenario.isFailed()==false)) {
       //if(scenario.isFailed()) {
       	
       	TakesScreenshot ts=(TakesScreenshot) driver;
       	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
       	scenario.attach(screenshot, "image/png",scenario.getName());
       	            
       }
     
   }

}
