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
public class SessionManagementpage extends TestBaseClass{

	@FindBy(id="cache:j_id_4p")
	@CacheLookup
	WebElement reloadsystemcache;
	
	@FindBy(id="cache:j_id_4t")
	@CacheLookup
	WebElement reloadpatientcache;
	
	@FindBy(id="cache:j_id_51")
	@CacheLookup
	WebElement reloadcache;
	
	@FindBy(xpath="//*[@id='cache:j_id_5c']")
	@CacheLookup
	WebElement clearerrormssg; 



public SessionManagementpage() {

	PageFactory.initElements(driver, this);
}



public void reloadsystemcache() {
	reloadsystemcache.submit();
	
	}


public void reloadpatientcache() {
	reloadpatientcache.submit();
	
	
}


public void reloadcache() {
	
	reloadcache.submit();
	
	
}

public void clearerrormssg() {
	
	clearerrormssg.submit();
	

}

}