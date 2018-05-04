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
public class PatientSelectpage extends TestBaseClass{



		@FindBy(id="detail:j_id_4o")
		@CacheLookup
		WebElement internalID;

		@FindBy(id="criteria:patId")
		@CacheLookup
		WebElement pID;

		@FindBy(id="criteria:search")
		@CacheLookup
		WebElement searchbtn;

		@FindBy(xpath="//*[@id='resultData']//label")
		@CacheLookup
		WebElement checkbox;

		@FindBy(id = "result:returnBtn")
		@CacheLookup
		WebElement returnselected ;
		
		
	

		public PatientSelectpage() {

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
		
		public void clickcheckbox() {
			checkbox.click();
		}
			
		public void clickreturnselectedbtn() {
			returnselected.click();
		}
			
			

		}



