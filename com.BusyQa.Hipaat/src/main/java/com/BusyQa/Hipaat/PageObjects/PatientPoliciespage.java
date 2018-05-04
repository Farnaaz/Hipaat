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
public class PatientPoliciespage extends TestBaseClass{

	@FindBy(id="detail:j_id_4w")
	@CacheLookup
	WebElement activeList;


	@FindBy(id="detail:j_id_51")
	@CacheLookup
	WebElement inactiveList;

	@FindBy(xpath="//input[contains(@type, 'button')]")
	@CacheLookup
	WebElement newUsing;

	@FindBy(id="inactivePoliciesResult:j_id_8t")
	@CacheLookup
	WebElement advanced;

	@FindBy(id="inactivePoliciesResult:j_id_8f:0:j_id_8h")
	@CacheLookup
	WebElement policyTitle;

	@FindBy(id="criteria:startDate")
	@CacheLookup
	WebElement Asof_Date;

	@FindBy(id="criteria:search")
	@CacheLookup
	WebElement searchbtn;

	@FindBy(id="policiesResult:j_id_78:0:j_id_7a")
	@CacheLookup
	WebElement policytitle;

		

	public PatientPoliciespage() {

		PageFactory.initElements(driver, this);
	}


	public void clickonactiveList() {

		activeList.click();
	}

	public void clickAsofDate(String date) {

		Asof_Date.clear();
		Asof_Date.sendKeys(date);
	}

	public void clickonSearchbtn() {

		searchbtn.click();
	}

	public void clickonPolicyTitle() {

		policytitle.click();
	}

	public void clickoninactiveList() {

		inactiveList.click();
	}

	public void clickonnewUsing() {
		newUsing.click();

	}
	public void clickonadvanced() {
		advanced.click();
	}

	public void clickonpolicyTitleforrevoke() {
		policyTitle.click();
	}






}





