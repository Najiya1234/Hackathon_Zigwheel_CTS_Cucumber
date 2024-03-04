package factory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseClass {

	static WebDriver driver;
	static Properties p;
	public static  Logger logger;
	
	public static Logger initializelogger() {
		logger = LogManager.getLogger();
		return logger;
		
	}
	
	
	public static WebDriver initializeDriver() throws IOException {
		
		
		if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			DesiredCapabilities capabilities = new DesiredCapabilities();
			//os            
			if (getProperties().getProperty("os").equalsIgnoreCase("windows")) {
			    capabilities.setPlatform(Platform.WINDOWS);
			} else if (getProperties().getProperty("os").equalsIgnoreCase("mac")) {
			    capabilities.setPlatform(Platform.MAC);
			} else {
			    System.out.println("No matching OS..");
			      }
			
			//browser
			switch (getProperties().getProperty("browser").toLowerCase()) {
			    case "chrome":
			        capabilities.setBrowserName("chrome");
			        break;
			    case "edge":
			        capabilities.setBrowserName("edge");
			        break;
			    default:
			        System.out.println("No matching browser");
			     }
			//driver = new RemoteWebDriver(new URL("http://192.168.43.241:4444"),capabilities);
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
//	        try {
//				driver = new RemoteWebDriver(new URL("http://192.168.43.241:4444"),capabilities);
//			} catch (MalformedURLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		else if(getProperties().getProperty("execution_env").equalsIgnoreCase("local"))
			{
				switch(getProperties().getProperty("browser").toLowerCase()) 
				{
				case "chrome":
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--disable-notifications");
					options.addArguments("--disable-blink-features=AutomationControlled");
			        driver=new ChromeDriver(options);
			        break;
			    case "edge":
			    	driver=new EdgeDriver();
			        break;
			    default:
			        System.out.println("No matching browser");
			        driver=null;
				}
			}
		 driver.get(p.getProperty("appURL"));
		 driver.manage().deleteAllCookies(); 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 
		 
		 return driver;
	}
	public static Properties getProperties()
	{		 
        try {
			FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configuration.properties");
			p=new Properties();
			p.load(file);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
 
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static Logger getLogger() {
		return logger;
	}
	
	
	
}
