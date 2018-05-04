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
import com.BusyQa.Hipaat.PageObjects.PolicyReportspage;
import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 * 
 * This test case is testing the help in various pages - REPORT
 * 
 *
 */
public class BeHO_TC_022 extends TestBaseClass {

		Loginpage login;
		Menupage menu;
		PolicyReportspage pr;
	
		public BeHO_TC_022() {
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
		public void TC_022_verifyHelp_Reportpage() {

			menu = new Menupage();
			menu.clickonreport();
			menu.clickonPolicyreports();
			log.info("*****entered Policy Reports page*****");
			
			pr = new PolicyReportspage();
			
			
			menu.clickHelp();

			log.info("*****entered Help page*****");


			Set<String> handles = driver.getWindowHandles();
			Iterator <String> it = handles.iterator();
			String parentWindowId = it.next();{System.out.println(parentWindowId);}
			String childWindowId = it.next();{System.out.println(parentWindowId);}
			driver.switchTo().window(childWindowId);

			String help_page_title = driver.findElement(By.id("_Toc484762134")).getText();

			String expected_message = "Policy Trends Report";
			softAssert.assertEquals(expected_message, help_page_title); 

			softAssert.assertAll();
		}

		@AfterMethod
		public void tearDown() {
			driver.quit();
			log.info("*****BeHO_TC_022 Test case is done, Browser closed*****");
		}

		

	}

