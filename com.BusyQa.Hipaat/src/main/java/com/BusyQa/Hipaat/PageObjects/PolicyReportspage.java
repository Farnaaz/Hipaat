/**
 * 
 */
package com.BusyQa.Hipaat.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 *
 */
public class PolicyReportspage extends TestBaseClass {

	@FindBy(id= "report:j_id_4v")
	@CacheLookup
	WebElement activepolicies;

	@FindBy(id= "report:j_id_63")
	@CacheLookup
	WebElement activepoliciesselectbtn;

	@FindBy(id= "generateReportBtn")
	@CacheLookup
	WebElement generateReport;

	
	@FindBy(id= "report:j_id_aj")
	@CacheLookup
	WebElement AP_pdfReport;

	
	
	
	@FindBy(id= "report:j_id_5f")
	@CacheLookup
	WebElement policymanagement;

	@FindBy(id= "report:j_id_7u")
	@CacheLookup
	WebElement selectbtn;

	@FindBy(id= "ui-id-6")
	@CacheLookup
	WebElement scheduleparameters;

	@FindBy(id= "report:schedReportDescription")
	@CacheLookup
	WebElement schedreportdescription;
	
	@FindBy(id= "report:email")
	@CacheLookup
	WebElement recipientemail;
	
	
	@FindBy(id= "scheduleReportBtn")
	@CacheLookup
	WebElement scheduleReportBtn;
	
	
	@FindBy(id= "report:j_id_as")
	@CacheLookup
	WebElement PM_pdfreport;
	
	
	
	


	public PolicyReportspage() {

		PageFactory.initElements(driver, this);
	}



	public void clickActivepolicies() {

		activepolicies.click();

	}

	public void activepoliciesSelectbtn() {

		activepoliciesselectbtn.click();

	}

	public void clickGenerateReportbtn() {

		generateReport.click();

	}

	public void AP_pdfversion() {

		AP_pdfReport.click();

	}

	
	public void clickpolicymanagement() {

		policymanagement.click();

	}

	public void patientSelectbtn() {

		selectbtn.click();

	}


	public void clickSchdParameters() {

		scheduleparameters.click();

	}

	public void SchedReportdescription(String description) {

		schedreportdescription.sendKeys(description);

	}


	public void clickScheduleReportBtn() {

		scheduleReportBtn.click();

	}


	public void recipientemail(String email) {

		recipientemail.sendKeys();

	}

	public void PM_pdfversion() {

		PM_pdfreport.click();

	}


	

}
