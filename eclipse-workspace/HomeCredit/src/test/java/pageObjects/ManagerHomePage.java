package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common.BasicFunction;

public class ManagerHomePage {

	WebDriver driver;
	
	/**
     * ##################################################
     * ### DECLARE
     * ##################################################
     */
    /**
     * General item
     */
	
	@FindBy(xpath = "//table//tr[@class='heading3']")
	WebElement homePageUserName;
	
	/**
     * Constructor
     */
	public ManagerHomePage() {
	}

	public ManagerHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
     * ##################################################
     * ### ACTION
     * ##################################################
     */    
    /**
     * 
     * Action get manager home page dashboard User Name
     * @throws Exception 
     *
     */

	public String getHomePageDashboardUserName() throws Exception {
		return BasicFunction.getText(driver, homePageUserName);
	}

	/**
     * ##################################################
     * ### FUNCTION
     * ##################################################
     */
	 /**
     * 
     * Verify the home page dashboard's username view correctly
     * 
     * @param strUserName
     * @throws Exception
     */

	public void verifyUserNameViewinDashBoard(String strUserName) throws Exception {
		Assert.assertTrue(this.getHomePageDashboardUserName().contains(strUserName));
	}
}