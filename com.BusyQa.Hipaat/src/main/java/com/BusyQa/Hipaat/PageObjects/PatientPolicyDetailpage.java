/**
 * 
 */
package com.BusyQa.Hipaat.PageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BusyQa.Hipaat.TestBase.TestBaseClass;

/**
 * @author Farnaaz
 *
 */
public class PatientPolicyDetailpage extends TestBaseClass {



	@FindBy(xpath="//span[contains (@class, 'ui-button-text')] [contains(text(), 'Yes')]")
	@CacheLookup
	WebElement Yesbtn;

	@FindBy(id="detail:startDate1")
	@CacheLookup
	WebElement sdate;

	@FindBy(xpath="//span[contains(@class, 'ui-button-text')] [contains(text(), 'Revoked')]")
	@CacheLookup
	WebElement validUntil_revoked;

	@FindBy(id="detail:description")
	@CacheLookup
	WebElement policyTitle;

	@FindBy(xpath="//span[contains(@class, 'ui-button-text')][contains(text(), 'Patient')]")
	@CacheLookup
	WebElement requestedbyPatient;

	@FindBy(xpath="//div[@id=\'pouRadio\']/label[2]/span")
	@CacheLookup
	WebElement specifyusebtn;


	@FindBy(xpath="//div[@id='pouRadio']//span[contains(text(), 'All')]")
	@CacheLookup
	WebElement useAllbtn;

	@FindBy(xpath="//div[@id= 'detail_pouSelectObj_chosen']//ul//li[1]//span")
	@CacheLookup
	List <WebElement> dropdownoptions;

	@FindBy(xpath="//input[@type='button' and @value= 'Add Directive Using...']")
	@CacheLookup
	WebElement addDirectiveUsing;

	@FindBy(id="detail:j_id_7z")
	@CacheLookup
	WebElement advanced;


	@FindBy(id="directiveDetail:privacyOperation")
	@CacheLookup
	WebElement privacyOperation;

	@FindBy(id="directiveDetail:directiveType")
	@CacheLookup
	WebElement directiveType;

	@FindBy(id="directiveDetail:outcome")
	@CacheLookup
	WebElement directiveOutcome;

	@FindBy(id="directiveDetail:cdTitle")
	@CacheLookup
	WebElement directiveTitlebox;

	@FindBy(xpath="//div[@id = 'appliesToRadio']//span[contains(@class, 'ui-button-text')] [contains(text(), 'Specify')]")
	@CacheLookup
	WebElement requestorbtn_specify;

	@FindBy(name="directiveDetail:j_id_ad:0:j_id_ah")
	@CacheLookup
	WebElement providerdropdown;

	@FindBy(id="directiveDetail:j_id_ad:0:j_id_an")
	@CacheLookup
	WebElement addProviderbtn;


	@FindBy(xpath="//div[@id='phiGranularityRadio']/div[1]/label/span[text()='All']")
	@CacheLookup
	WebElement Specifyphi_All;

	@FindBy(id="directiveDetail:doneBtn")
	@CacheLookup
	WebElement donebtn;

	@FindBy(id="detail:saveBtn")
	@CacheLookup
	WebElement savebtn;

	@FindBy(id="save-comment")
	@CacheLookup
	WebElement savecomment;

	@FindBy(id="save-comment-btn-continue")
	@CacheLookup
	WebElement continuebtn;

	@FindBy(id="detail:j_id_8e")
	@CacheLookup
	WebElement activatebtn;

	@FindBy(id="detail:j_id_8i")
	@CacheLookup
	WebElement revokebtn;
	
	@FindBy(id="revoke-comment-btn-continue")
	@CacheLookup
	WebElement revokebtn_continue;
	
	@FindBy(xpath="//button[@id='revoke-comment-btn-cancel']/span")
	@CacheLookup
	WebElement cancel;
	
	@FindBy(xpath="//div//span [contains(@class, 'ui-accordion-header-icon ui-icon ui-icon-triangle-1-e')]")
	@CacheLookup
	WebElement triangle;
	
		

	

	public PatientPolicyDetailpage() {

		PageFactory.initElements(driver, this);
	}


	public void executefirst_Yes(){
		Yesbtn.click();
	}

	public void startdate(String date){
		sdate.clear();
		sdate.sendKeys(date);

	}


	public void validUntil_revoked(){

		validUntil_revoked.click();
	}

	public void policyTitle(String title){

		policyTitle.sendKeys(title);
	}

	public void requestedby_Patient(){

		requestedbyPatient.click();
	}

	public void purposeofuse_All(){


		useAllbtn.click();
	}


	public void addDirectiveUsing(){

		addDirectiveUsing.click();
	}

	public void advanced() {
		advanced.click();
	}

	public void privacyOperation(String privacy) {
		privacyOperation.sendKeys(privacy);

	}

	public void directiveType(String type) {
		directiveType.sendKeys(type);
	}


	public void directiveOutcome(String outcome) {
		directiveOutcome.sendKeys(outcome);
	}

	public void directiveTitlebox(String dtitle) {
		directiveTitlebox.sendKeys(dtitle);
	}

	public void requestorbtn_specify() {
		requestorbtn_specify.click();
	}
	public void providerdropdown(String exclude) {
		providerdropdown.sendKeys(exclude);
	}
	public void addProviderbtn() {

		addProviderbtn.click();
	}

	public void Specifytophi_All() {

		Specifyphi_All.click();

	}

	public void donebtn() {
		donebtn.click();
	}

	public void savebtn() {
		savebtn.click();
	}

	public void entersavecomment(String comment) {

		savecomment.sendKeys(comment);	
	}

	public void continuebtn() {


		continuebtn.click();
	}

	public void activatebtn() {


		activatebtn.click();
	}


	public void triangleicon() {


		triangle.click();
	}


	public void revokebtn() {


		revokebtn.click();
	}

	public void revokecontinuebtn() {


		revokebtn_continue.click();
	}

	
	public void cancelbtn() {


		cancel.click();
	}



}




