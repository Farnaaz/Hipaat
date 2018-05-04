package com.BusyQa.Hipaat.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * This page object class will store all webelements and actions related to Consent page. 
 *
 */

public class PatientSearchpage extends TestBaseClass{



	@FindBy(id="detail:j_id_4o")
	@CacheLookup
	WebElement internalID;

	@FindBy(id="criteria:patId")
	@CacheLookup
	WebElement pID;

	@FindBy(id="criteria:search")
	@CacheLookup
	WebElement searchbtn;

	@FindBy(id="result:j_id_6t:0:j_id_6v")
	@CacheLookup
	WebElement searchresult;



	public PatientSearchpage() {

		PageFactory.initElements(driver, this);
	}


	
	public void InternalID() {

		internalID.click();

	}	
	public void pID(String ID) {

		pID.sendKeys(ID);
		
	}
		
	public void clickonSearchbtn() {
		searchbtn.click();
	}
	
	public void clickonSearchresult() {
		searchresult.click();
	}
		
		

	}


