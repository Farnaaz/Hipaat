/**
 * 
 */
package com.BusyQa.Hipaat.TestCases;


import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BusyQa.Hipaat.PageObjects.Loginpage;
import com.BusyQa.Hipaat.PageObjects.Menupage;
import com.BusyQa.Hipaat.PageObjects.PatientSelectpage;
import com.BusyQa.Hipaat.PageObjects.PolicyReportspage;
import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 *
 */
public class BeHO_TC_011 extends TestBaseClass{
		
		Loginpage login;
		Menupage menu;
		PolicyReportspage pr;
		PatientSelectpage ps;
		
		
		public BeHO_TC_011() {
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
		public void TC_011_verifyScheduling() {

			menu = new Menupage();
			menu.clickonreport();
			menu.clickonPolicyreports();
			log.info("*****entered Policy Reports page*****");
			
			pr = new PolicyReportspage();
			pr.clickpolicymanagement();
			pr.patientSelectbtn();
			
			
			 ps= new PatientSelectpage();
			 ps.InternalID();
			 ps.pID("BQ0001");
			 ps.clickonSearchbtn();
			 ps.clickcheckbox();
			 ps.clickreturnselectedbtn();
			log.info("*****added patient button*****");

	
			pr = new PolicyReportspage();
			pr.clickSchdParameters();
			pr.SchedReportdescription("demo");
			pr.recipientemail("abc@gmail.com");
			pr.clickScheduleReportBtn();
			pr.PM_pdfversion();
			
			//AC01: Message Box Displayed
			String message = driver.findElement(By.xpath("//*[@id='infoMessagesDialog']//td[contains(@class, 'infoMessages')]")).getText();
			System.out.println("******Message is : " +message);
			
			
						
			
		}	

		@AfterMethod
		public void tearDown() {
			driver.quit();
			log.info("*****BeHO_TC_011 Test case is done, Browser closed*****");

		}
	}



