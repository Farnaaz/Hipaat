/**
 * 
 */
package com.BusyQa.Hipaat.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 *
 */
public class AuditReportpage extends TestBaseClass {


	@FindBy(id= "report:j_id_4p")
	@CacheLookup
	WebElement frequentcriteria;

	@FindBy(id= "report:patientOp1")
	@CacheLookup
	WebElement patientdropdown;


	@FindBy(id= "report:userOp1")
	@CacheLookup
	WebElement userdropdown;



	@FindBy(id= "report:startDateSel1")
	@CacheLookup
	WebElement eventdate;

	@FindBy(id= "generateReportBtn")
	@CacheLookup
	WebElement generateReportbtn;

	@FindBy(id= "report:j_id_90")
	@CacheLookup
	WebElement AR_pdfreport;


	


	public AuditReportpage() {

		PageFactory.initElements(driver, this);
	}

	public void clickFrequentCriteria() {


		frequentcriteria.click();

	}


	public void clickPatientdropdown() {


		patientdropdown.click();

	}
	public void SelectRandomPatient() {


		Select dropdown = new Select (patientdropdown);
		dropdown.selectByVisibleText("Random Patient");

	}


	public void clickUserdropdown() {


		userdropdown.click();

	}
	public void SelectRandomuser() {


		Select dropdown = new Select (userdropdown);
		dropdown.selectByVisibleText("Random");

	}

	


	public void clickEventDate() {


		eventdate.click();


	}

	public void selectPreviousMonth() {


		Select dropdown = new Select (eventdate);
		dropdown.selectByVisibleText("Previous Month");


	}

	public void generateReportbtn() {


		generateReportbtn.click();


	}
	
	public void AR_pdfReport() {


		AR_pdfreport.click();


	}


	
}