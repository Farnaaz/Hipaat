/**
 * 
 */
package com.BusyQa.Hipaat.TestCases;

import java.io.File;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BusyQa.Hipaat.PageObjects.AuditReportpage;
import com.BusyQa.Hipaat.PageObjects.Loginpage;
import com.BusyQa.Hipaat.PageObjects.Menupage;
import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 *
 */
public class BeHO_TC_017 extends TestBaseClass {

	Loginpage login;
	Menupage menu;
	AuditReportpage ar;

	Logger log = Logger.getLogger(BeHO_TC_017.class);

	public BeHO_TC_017() {
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
	public void TC_017_auditReport() {

		menu = new Menupage();
		menu.clickonreport();
		menu.clickonAuditreports();
		log.info("*****entered Audit Reports page*****");

		ar = new AuditReportpage();
		ar.clickFrequentCriteria();
		ar.clickPatientdropdown();
		ar.SelectRandomPatient();
		ar.clickUserdropdown();
		ar.SelectRandomuser();
		ar.clickEventDate();
		ar.selectPreviousMonth();
		ar.generateReportbtn();
		ar.AR_pdfReport();

		String path = System.getProperty("C://Users//Farnaaz//Downloads") + "/AuditPatientAccess.rptdesign-20180429190033.pdf";

		File f = new File("C://Users//Farnaaz//Downloads//AuditPatientAccess.rptdesign-20180429190033.pdf");


		if (f.exists()) {
			System.out.println("File Location:" +path.toString());
			System.out.println("file exists");
		} else {
			System.out.println("file does not exist");
		}

	}	

	@AfterMethod
		public void tearDown() {
			driver.quit();
			log.info("*****BeHO_TC_017 Test case is done, Browser closed*****");
	 
}
}






