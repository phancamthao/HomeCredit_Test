package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common.BasicFunction;

public class LoginPage {
	/**
     * ##################################################
     * ### DECLARE
     * ##################################################
     */
    /**
     * General item
     */
	@FindBy(name = "uid")
	private WebElement Txb_Username;

	@FindBy(name = "password")
	private WebElement Txb_Password;

	@FindBy(name = "btnLogin")
	private WebElement Btn_Login;

	private WebDriver driver;

	/**
     * Constructor
     */
	
	public LoginPage() {
	}

	public LoginPage(WebDriver driver) {
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
     * Action input text Username at Login Page.
     *
     * @param strUsername
     * @throws Exception
     */
	public void setUserName(String strUserName) throws Exception {
		try {
			BasicFunction.inputText(driver, Txb_Username, strUserName);
			} catch (Exception e) {
				throw new Exception("Failure Input UserName "+ strUserName +". Exception " + e);
		}
	}

	 /**
     * 
     * Action input text Password at Login Page.
     * 
     * @param strPassword
     * @throws Exception
     */
	public void setPassword(String strPassword) throws Exception {
		try {
			BasicFunction.inputText(driver, Txb_Password, strPassword);
			} catch (Exception e) {
				throw new Exception("Failure Input Password "+ strPassword +". Exception "  + e);
		}
	}

	/**
     * 
     * Action click button Login at Login Page.
     *
     * @throws Exception
     */
	public void clickLogin() throws Exception {
		try {
			BasicFunction.clickElement(driver, Btn_Login);
		} catch (Exception e) {
			throw new Exception("Failed Click Login Button. Exception " + e);
		}
	}

	/**
     * 
     * Action get the title of Login Page.
     *
     */
	public String getLoginTitle() {
		return this.driver.getTitle();
	}

	 /**
     * ##################################################
     * ### FUNCTION
     * ##################################################
     */
	 /**
     * 
     * Verify the title contain specific string key word
     * 
     * @param strLoginTitleKeyWord
     * @throws Exception
     */

	public void verifyTitleContainSpecificKeyWord(String strLoginTitleKeyWord) throws Exception {
		Assert.assertTrue(this.getLoginTitle().toLowerCase().contains(strLoginTitleKeyWord));
	}
	
    /**
     * 
     * Function input Username/Password without verify
     * 
     * @param strUsername
     * @param strPassword
     * @throws Exception
     */

	public void loginwithUserandPass(String strUserName, String strPassword) throws Exception {
		this.setUserName(strUserName);
		this.setPassword(strPassword);
		this.clickLogin();
	}
}