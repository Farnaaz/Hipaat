package com.BusyQa.Hipaat.TestBase;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/**
 * This testbase class will be the parent class for all other classes. 
 * Will use the concept of inheritance for child classes...
 * It will read/load properties file and have browsersetup 
 *  
 *
 */

public class TestBaseClass {

	public static WebDriver driver;
	public static Properties pro; 	
	public static Logger log; 
	public static SoftAssert softAssert;

	public ExtentReports extent;
	public ExtentTest extenttest;

	//constructor to define properties file

	public TestBaseClass() {

		pro = new Properties();
		//Reading file
		try {
			FileInputStream fis = new FileInputStream("./src/main/java/com/BusyQa/Hipaat/Config/ReadConfig.properties");

			//loading file
			pro.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {System.out.println("Exception is::" + e.getMessage());}

		softAssert=new SoftAssert();
		log=Logger.getLogger("TestBaseClass");
		PropertyConfigurator.configure("log4j.properties");
	}


	//for browser initialization 
	public static void browserinitialization() {


		String browserName = pro.getProperty("browser");

		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\eclipse-workspace\\com.Busyqa.Hipaat.Regression(OLD)\\drivers\\chromedriver.exe");	
			driver = new ChromeDriver();
			log.info("*****Initializing chrome browser*****");

		}else if (browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\eclipse-workspace\\com.Busyqa.Hipaat.Regression(OLD)\\drivers\\geckodriver.exe");	
			driver = new FirefoxDriver();
			log.info("*****Initializing firefox browser*****");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(pro.getProperty("Url"));

	}

	
}