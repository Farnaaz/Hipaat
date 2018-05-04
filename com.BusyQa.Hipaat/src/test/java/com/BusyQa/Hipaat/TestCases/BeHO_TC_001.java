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
 * -----This test case is testing the creation of policy ------
 * The test case extends TestBaseClass which defines properties and browserinitialization()
 *    - browserinitialization() will launch browser, clearcookies, add dynamic wait & pass url 
 *    - login details has been stored in properties file to achieve abstraction  
 * 
 * Super() Constructor has been called to initialize properties file from parent class
 *@BeforeMethod used to achieve browser independency
 * Logger class is used to generate custom logs
 *
 */ 

public class BeHO_TC_001 extends TestBaseClass {

	Loginpage login;
	Menupage menu;
	PatientSearchpage psearch;
	PatientPoliciespage ppolicies;
	PatientPolicyDetailpage ppdetail;
	ProviderSelectpage pselect;

	

	public BeHO_TC_001() {
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
	public void TC_001_policycreation() throws InterruptedException {
		
		//AC01: A Policy will be created with Consent Directive
		menu = new Menupage();
		menu.clickConsentmenu();
		menu.clickManagement();
		log.info("*****Consent menu clicked*****");

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
		ppdetail.startdate("2018-06-21");
		ppdetail.validUntil_revoked();
		ppdetail.policyTitle("This is a deny policy");
		ppdetail.requestedby_Patient();
		ppdetail.purposeofuse_All();
		ppdetail.addDirectiveUsing();
		ppdetail.advanced();
		ppdetail.privacyOperation("Use");
		ppdetail.directiveType("Directive Outcome");
		ppdetail.directiveOutcome("Deny");
		ppdetail.directiveTitlebox("Deny Outcome Policy");
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

		ppdetail.entersavecomment("demo purpose");
		ppdetail.continuebtn();
		log.info("*****comment saved *****");

		//AC02: A Policy Saved Successfully message will be displayed
		
		String expected_message="Policy was saved successfully.";
		String actual_message = driver.findElement(By.id("infoMessagesDialog")).getText();
		softAssert.assertEquals(expected_message, actual_message);
		
		softAssert.assertAll();

		//AC03: Created Policy will be displayed in policy table
		ppdetail.activatebtn();
		log.info("***** policy activated *****");

	}
			
		@Test (dependsOnMethods = {"policycreation"})                                                            
		public void deletepolicycreation() {                                                  
			                                                                                  
			                                                                                  
			//code for revoking created policy                                                
			menu = new Menupage();                                                            
			menu.clickConsentmenu();                                                          
			menu.clickManagement();                                                           
			psearch= new PatientSearchpage() ;                                                
			psearch.InternalID();                                                             
			psearch.pID("BQ0001");                                                            
			psearch.clickonSearchbtn();                                                       
			psearch.clickonSearchresult();                                                    
			ppolicies = new PatientPoliciespage();	                                          
			ppolicies.clickonactiveList();                                                    
			ppolicies.clickAsofDate("2018-06-21");                                            
			ppolicies.clickonSearchbtn();                                                     
			ppolicies.clickonPolicyTitle();                                                   
			                                                                                  
			ppdetail = new PatientPolicyDetailpage();                                         
			                                                                                  
			ppdetail.revokebtn();                                                             
			log.info("clicked on revoke btn");                                                
			ppdetail.revokecontinuebtn();                                                     
			String revoke_message = driver.findElement(By.id("infoMessagesDialog")).getText();
			System.out.println(revoke_message);                                               
		}		                                                                              
		                                                                                      			
	
@AfterMethod
	public void tearDown() {

		driver.quit();
		log.info("***** BeHO_TC_001 Test case completed, Browser closed*****");
	}


}




