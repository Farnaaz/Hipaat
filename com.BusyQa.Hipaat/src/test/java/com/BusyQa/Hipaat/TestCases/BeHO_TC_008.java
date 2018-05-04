package com.BusyQa.Hipaat.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BusyQa.Hipaat.PageObjects.Loginpage;
import com.BusyQa.Hipaat.PageObjects.Menupage;
import com.BusyQa.Hipaat.PageObjects.SecurityAlertSearchpage;
import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 * 
 * -----This testcase is to testing Search is returning values in the Security Alert Page ----
 * This test case extends TestBaseClass which defines properties and browserinitialization()
 *    - browserinitialization() will launch browser, clearcookies, add dynamic wait & pass url 
 *    - login details has been stored in properties file to achieve abstraction  
 * 
 * Super() Constructor has been called to initialize properties file from parent class
 *@BeforeMethod used to achieve browser independency
 * 
 *
 */ 




public class BeHO_TC_008 extends TestBaseClass{

	Loginpage login;
	Menupage menu;
	SecurityAlertSearchpage sas;


	public BeHO_TC_008() {
		super();
		log.info("*****parent class constructor called and properties file initiated*****");
	}

	@BeforeMethod
	public void setUp() {

		browserinitialization(); 
		log.info("*****browser is successfully initialised*****");

		login = new Loginpage();
		login.Login(pro.getProperty("UserID"), pro.getProperty("Password"), pro.getProperty("Facility"));
		log.info("*****login is successfully done*****");
	}

	@Test (enabled = true)
	public void TC_008_verifySearch() {

		menu = new Menupage();
		menu.clickonAuditRepository();
		menu.clickonSecurityAlerts();
		log.info("*****entered security alerts search page*****");
		sas = new SecurityAlertSearchpage();

		sas.clickSearchbtn();
		log.info("*****clicked search button*****");

		
		//AC02: Web Table is Populated 
			
		List <WebElement> rows = driver.findElements(By.xpath("//*[@id='resultData']/tbody/tr"));
		List <WebElement> cols = driver.findElements(By.xpath("//*[@id='resultData']/tbody/tr/td"));

		System.out.println("Rows are:" + rows.size());
		System.out.println("Cols are:" + cols.size());
		
		log.info("*****Rows & Cols Count *****");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("*****BeHO_TC_008 Test case is done, Browser closed*****");

	}
}
