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
 * This page object class will store all webelements and actions related to login page. 
 *
 */
public class Loginpage extends TestBaseClass{

	
	
	public Loginpage () {

		//initialize elements using PageFactory class
		PageFactory.initElements(driver,this); //driver coming from Testbase class
	}

	
//PageFactory - locators on login page
	
	@FindBy(id="login:j_id_4l")
	@CacheLookup
	WebElement Userid;

	@FindBy(name="login:j_id_4n")
	@CacheLookup
	WebElement Pwd;

	@FindBy(name="login:facility")
	@CacheLookup
	WebElement Facility;

	@FindBy(id="login:j_id_4u")
	@CacheLookup
	WebElement Loginbtn;
	
	@FindBy(xpath= "//div[@id='applicationAreaId']/div/div/img")
	@CacheLookup
	WebElement Logo;

	
	public Menupage Login (String uname, String pwd, String facility) {
	
		Userid.sendKeys(uname); //webelement.action
		Pwd.sendKeys(pwd);
		Facility.sendKeys(facility);
		Loginbtn.click();
		return new Menupage();
	}
	

}
