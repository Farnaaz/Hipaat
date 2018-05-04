package com.BusyQa.Hipaat.TestCases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BusyQa.Hipaat.PageObjects.Loginpage;
import com.BusyQa.Hipaat.PageObjects.Menupage;
import com.BusyQa.Hipaat.PageObjects.PurposeofUsepage;
import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 * 
 * This test case extends TestBaseClass which defines properties and browserinitialization()
 *    - browserinitialization() will launch browser, clearcookies, add dynamic wait & pass url 
 *    - login details has been stored in properties file to achieve abstraction  
 * 
 * Super() Constructor has been called to initialize properties file from parent class
 *@BeforeMethod used to achieve browser independency
 * Logger class is used to generate custom logs
 *
 */ 




public class BeHO_TC_006 extends TestBaseClass{

	Loginpage login;
	Menupage menu;
	PurposeofUsepage use;

	
	public BeHO_TC_006() {
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

	@Test
	public void TC_006_purposeofuse() {

		menu = new Menupage();
		menu.clickAdministration();
		menu.clickListmaintenance();
		menu.clickConsentlist();
		menu.clickPurposeofuse();
		log.info("*****entered purpose of use maintenance page*****");

		//AC01: Values will be added to Purpose_of_use table as TEST123
		use = new PurposeofUsepage();
		use.enterCodevalue("TEST123");
		use.enterdescription("test1");
		use.clickSave();
		log.info("*****value added in purpose of use table *****");

	}
	
		@AfterMethod
		public void tearDown() {
			driver.quit();
			log.info("*****BeHO_TC_006 Test case is done, Browser closed*****");

		}
	}