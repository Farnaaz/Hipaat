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
public class PurposeofUsepage extends TestBaseClass {

	@FindBy(xpath="//td[@class='normal sorting_1']/input")
	@CacheLookup
	WebElement code;


	@FindBy(xpath = "//td[@class='normal']/input[1]")
	@CacheLookup
	WebElement description;

	@FindBy(xpath = "//input[@class='actionBtnSmall' and @title='Save']")
	@CacheLookup
	WebElement savebtn;

	@FindBy(id = "result:j_id_4q:13:j_id_55")
	@CacheLookup
	WebElement deletebtn;

	

	public PurposeofUsepage() {

		//initialize elements using PageFactory class
		PageFactory.initElements(driver,this); //driver coming from Testbase class
	}


	public void enterCodevalue(String codevalue) {
		code.sendKeys(codevalue);

	}
	
	public void enterdescription(String desc) {
		description.sendKeys(desc);

	}
	
	public void clickSave() {
		savebtn.click();

	}

	public void clickDelete() {
		deletebtn.click();

	}
}
