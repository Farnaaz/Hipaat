/**
 * 
 */
package com.BusyQa.Hipaat.TestCases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BusyQa.Hipaat.PageObjects.Loginpage;
import com.BusyQa.Hipaat.PageObjects.Menupage;
import com.BusyQa.Hipaat.PageObjects.SecurityAlertDetailpage;
import com.BusyQa.Hipaat.PageObjects.SecurityAlertSearchpage;
import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 *
 */
public class BeHO_TC_009 extends TestBaseClass{
	
	Loginpage login;
	Menupage menu;
	SecurityAlertSearchpage sas;
	SecurityAlertDetailpage sad;

	
	public BeHO_TC_009() {
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
	public void TC_009_verifyacknowldg() {

		menu = new Menupage();
		menu.clickonAuditRepository();
		menu.clickonSecurityAlerts();
		log.info("*****entered security alerts search page*****");
		sas = new SecurityAlertSearchpage();

		sas.clickSearchbtn();
		log.info("*****clicked search button*****");

	//first security message is checked
		sas.messageID_Num();
		log.info("*****message id checked*****");
	
		
		sad = new SecurityAlertDetailpage();				
		//security alert is acknowledged
		sad.Acknowledgebtn();		
		log.info("*****clicked acknowledged button*****");
		
		//check security alert is removed from table
		sad.Backbtn();
		log.info("*****clicked back button*****");
		
		
	}	

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("*****BeHO_TC_009 Test case is done, Browser closed*****");

	}	
}
