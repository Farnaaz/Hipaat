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
public class ProviderSelectpage extends TestBaseClass{

	@FindBy(id="detail:j_id_4o")
	@CacheLookup
	WebElement internalID;

	@FindBy(id="criteria:id1")
	@CacheLookup
	WebElement ID;

	@FindBy(id="criteria:search")
	@CacheLookup
	WebElement searchbtn;

	@FindBy(xpath="//div[@class=\'row-select-col\']/label[1]")
	@CacheLookup
	WebElement checkbox;

	@FindBy(id="result:returnBtn")
	@CacheLookup
	WebElement returnSelected;

	public void internalID() {
		internalID.click();
	}

	public void ID(String num) {
		ID.sendKeys(num);
	}

	public void searchbtn() {
		searchbtn.click();
	}

	public void checkbox() {
		checkbox.click();
	}

	public void returnSelected() {
		returnSelected.click();
	}




	public ProviderSelectpage() {

		PageFactory.initElements(driver, this);
	}


}


