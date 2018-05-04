/**
 * 
 */
package com.BusyQa.Hipaat.TestCases;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BusyQa.Hipaat.PageObjects.Loginpage;
import com.BusyQa.Hipaat.PageObjects.Menupage;
import com.BusyQa.Hipaat.PageObjects.PatientSearchpage;
import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 * 
 * This test case is testing the help in various pages 
 * 
 *
 */
public class BeHO_TC_021 extends TestBaseClass {

	Loginpage login;
	Menupage menu;
	PatientSearchpage psearch;

	public BeHO_TC_021() {
		super();
	}

	@BeforeMethod
	public void setUp() {


		browserinitialization(); 
		log.info("*****browser is successfully initialised*****");

		login=new Loginpage();	
		login.Login(pro.getProperty("UserID"), pro.getProperty("Password"), pro.getProperty("Facility"));
		log.info("*****login is successfully done*****");
	}

	@Test
	public void TC_021_verifyHelp_Patientpage() {

		menu = new Menupage();
		menu.clickConsentmenu();
		menu.clickManagement();
		log.info("*****Management page clicked *****");

		psearch= new PatientSearchpage() ;
		psearch.InternalID();


		menu.clickHelp();

		log.info("*****entered Help page*****");


		Set<String> handles = driver.getWindowHandles();
		Iterator <String> it = handles.iterator();
		String parentWindowId = it.next();{System.out.println(parentWindowId);}
		String childWindowId = it.next();{System.out.println(parentWindowId);}
		driver.switchTo().window(childWindowId);

		String help_page_title = driver.findElement(By.id("_Toc484762067")).getText();

		String expected_message = "Searching by Internal ID";
		softAssert.assertEquals(expected_message, help_page_title); 

		softAssert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		log.info("*****BeHO_TC_021 Test case is done, Browser closed*****");


	}		

}

