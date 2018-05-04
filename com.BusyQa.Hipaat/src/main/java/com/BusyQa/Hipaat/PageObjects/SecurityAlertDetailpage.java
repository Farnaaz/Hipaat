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
public class SecurityAlertDetailpage extends TestBaseClass{

	@FindBy(id="detail:j_id_5i")
	@CacheLookup
	WebElement Acknowledgebtn;
	
	@FindBy(id="detail:j_id_5j")
	@CacheLookup
	WebElement Backbtn;
	
	
	

	public SecurityAlertDetailpage() {

		//initialize elements using PageFactory class
		PageFactory.initElements(driver, this); //driver coming from Testbase class
	}


	public void Acknowledgebtn() {
		Acknowledgebtn.click();

	}
	
	public void Backbtn() {
		Backbtn.click();

	}
	
	
}
