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
public class SecurityAlertSearchpage extends TestBaseClass {

	@FindBy(id="criteria:search")
	@CacheLookup
	WebElement searchbtn;

	@FindBy(id="criteria:messageId")
	@CacheLookup
	WebElement messageID;

	
	
	@FindBy(xpath="//div[@id='attnMessagesDialog']//td[@class= 'visibility:hidden']")
	@CacheLookup
	WebElement errormessage;
	
	@FindBy(id="resultData_wrapper")
	@CacheLookup
	WebElement webtable;
	

	@FindBy(xpath="//*[@id='resultData']/tbody/tr[1]")
	@CacheLookup
	WebElement totalRows;
	
	@FindBy(xpath="//*[@id='resultData']/tbody/tr[1]/td")
	@CacheLookup
	WebElement totalCols;
	
	@FindBy(id="result:j_id_5b:0:j_id_5j")
	@CacheLookup
	WebElement messageID_Num;
	
		
	public SecurityAlertSearchpage() {

		//initialize elements using PageFactory class
		PageFactory.initElements(driver,this); //driver coming from Testbase class
	}


	public void messageID(String ID) {
		messageID.sendKeys(ID);

	}
	
	public void messageID_Num() {
		messageID_Num.click();

	}
	
	
	
	public void clickSearchbtn() {
		searchbtn.click();

	}

	public void checktotalRows() {
		totalRows.getSize();
	}
	
	public void checktotalCols() {
		totalCols.getSize();
		
	}
	
	
}
