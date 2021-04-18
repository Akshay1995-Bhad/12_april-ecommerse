package com.myprimeshop.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import com.utilities.PropertiesUtility;
import com.utilities.TestUtil;
import com.utilities.WebEventListener;

public class TestBase {
	FileInputStream fis = null;
	//Properties prop;
	public static Logger log=Logger.getLogger(TestBase.class);
	PropertiesUtility proputils=null;
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TestBase() {
		
		try {
			prop=new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\Akshay\\git\\12_april-ecommerse\\src\\main\\java\\com\\myprimeshop\\config\\config.properties");
		    prop.load(ip);    
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		//now create object of Event Listeners to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		}

		
	}
	
	
	

