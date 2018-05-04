/**
 * 
 */
package com.BusyQa.Hipaat.TestCases;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BusyQa.Hipaat.PageObjects.Loginpage;
import com.BusyQa.Hipaat.PageObjects.Menupage;
import com.BusyQa.Hipaat.PageObjects.SessionManagementpage;
import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 *
 */
public class BeHO_TC_018 extends TestBaseClass {

	Loginpage login;
	Menupage menu;
	SessionManagementpage sm;

	Logger log = Logger.getLogger(BeHO_TC_001.class);

	public BeHO_TC_018() {
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
	public void TC_018_verifybase53Error() {

		menu = new Menupage();
		menu.clickAdministration();
		menu.clickSessionManagement();
		log.info("*****entered session management page *****");
		
		sm = new SessionManagementpage();
		
				
		sm.clearerrormssg();
		log.info("*****clear error messages button clicked *****");
		
	boolean error =  driver.getPageSource().contains("base53");
	if (error==true) {
		System.out.print("verification unsuccessful, base53 error found");
    }
    else
    {
     System.out.print("verification successful, no base53 error");
    }
	}
			

}