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
import com.BusyQa.Hipaat.PageObjects.PatientPoliciespage;
import com.BusyQa.Hipaat.PageObjects.PatientPolicyDetailpage;
import com.BusyQa.Hipaat.PageObjects.PatientSearchpage;
import com.BusyQa.Hipaat.PageObjects.ProviderSelectpage;
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

public class BeHO_TC_007 extends TestBaseClass {

	Loginpage login;
	Menupage menu;
	PatientSearchpage psearch;
	PatientPoliciespage ppolicies;
	PatientPolicyDetailpage ppdetail;
	ProviderSelectpage pselect;

	public BeHO_TC_007() {
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
	public void TC_007_conflictpolicy() throws InterruptedException {
	
		
		menu = new Menupage();
		menu.clickConsentmenu();
		menu.clickManagement();
		log.info("*****Management page clicked*****");

		psearch= new PatientSearchpage() ;
		psearch.InternalID();
		psearch.pID("BQ0001");
		psearch.clickonSearchbtn();
		psearch.clickonSearchresult();
		log.info("*****patient search is done*****");

		ppolicies = new PatientPoliciespage();	
		ppolicies.clickoninactiveList();
		ppolicies.clickonnewUsing();
		ppolicies.clickonadvanced();

		log.info("*****entering patient policy details *****");
		ppdetail = new PatientPolicyDetailpage();
		ppdetail.executefirst_Yes();
		ppdetail.startdate("2018-05-04");
		ppdetail.validUntil_revoked();
		ppdetail.policyTitle("This is a demo policy");
		ppdetail.requestedby_Patient();
		ppdetail.purposeofuse_All();
		ppdetail.addDirectiveUsing();
		ppdetail.advanced();
		ppdetail.privacyOperation("Use");
		ppdetail.directiveType("Directive Outcome");

		//Scenario 1: Create "Deny All" Consent Directive
		ppdetail.directiveOutcome("Deny");
		ppdetail.directiveTitlebox("Deny All consent directive");
		ppdetail.requestorbtn_specify();
		ppdetail.providerdropdown("Exclude List");
		ppdetail.addProviderbtn();

		pselect = new ProviderSelectpage();	
		pselect.internalID();
		pselect.ID("drbob");
		pselect.searchbtn();
		pselect.checkbox();
		pselect.returnSelected();
		log.info("*****provider has been added*****");

		ppdetail.Specifytophi_All();
		ppdetail.donebtn();

		ppdetail.savebtn();
		log.info("*****saved button clicked*****");

		ppdetail.entersavecomment("deny all consent directive");
		ppdetail.continuebtn();
		log.info("*****comment saved *****");
		String message = driver.findElement(By.id("infoMessagesDialog")).getText();
		System.out.println("******Alert msg is : "+message);
		log.info("*****read the text of dialog box*****");
		ppdetail.activatebtn();
		log.info("***** deny all policy created and activated *****");

		//create "Allow All" CD 
		Thread.sleep(5000);

		menu = new Menupage();
		menu.clickConsentmenu();
		menu.clickManagement();
		log.info("*****Management page clicked*****");

		psearch= new PatientSearchpage() ;
		psearch.InternalID();
		psearch.pID("BQ0001");
		psearch.clickonSearchbtn();
		psearch.clickonSearchresult();
		log.info("*****patient search is done*****");

		ppolicies = new PatientPoliciespage();	
		ppolicies.clickoninactiveList();
		ppolicies.clickonnewUsing();
		ppolicies.clickonadvanced();

		log.info("*****entering patient policy details *****");
		ppdetail = new PatientPolicyDetailpage();
		ppdetail.executefirst_Yes();
		ppdetail.startdate("2018-05-04");
		ppdetail.validUntil_revoked();
		ppdetail.policyTitle("This is an allow policy");
		ppdetail.requestedby_Patient();
		ppdetail.purposeofuse_All();
		ppdetail.addDirectiveUsing();
		ppdetail.advanced();
		ppdetail.privacyOperation("Use");
		ppdetail.directiveType("Directive Outcome");

		ppdetail.directiveOutcome("Allow All");
		ppdetail.directiveTitlebox("Allow All consent directive");
		ppdetail.requestorbtn_specify();
		ppdetail.providerdropdown("Exclude List");
		ppdetail.addProviderbtn();

		pselect = new ProviderSelectpage();	
		pselect.internalID();
		pselect.ID("drbob");
		pselect.searchbtn();
		pselect.checkbox();
		pselect.returnSelected();
		log.info("*****provider has been added*****");

		ppdetail.Specifytophi_All();
		ppdetail.donebtn();

		ppdetail.savebtn();
		log.info("*****saved button clicked*****");

		

		ppdetail.entersavecomment("Allow all consent directive");
		ppdetail.continuebtn();
		log.info("*****comment saved *****");
		
		//AC01: Conflict error message is displayed
		String actual_message = driver.findElement(By.id("attnMessagesDialog")).getText();
		System.out.println("******Alert msg is : "+actual_message);
		String expected_message = "Directive 'Allow All consent directive' conflicts with Policy 'This is a demo policy' Directive 'Deny All consent directive'";
		
		softAssert.assertEquals(actual_message, expected_message); 

		softAssert.assertAll();



	}


	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		
	}	 

}




