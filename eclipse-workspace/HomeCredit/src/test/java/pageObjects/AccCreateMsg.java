package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common.BasicFunction;

public class AccCreateMsg {
	WebDriver driver;

	/**
	 * ################################################## 
	 * ### DECLARE
	 * ##################################################
	 */
	/**
	 * General item
	 */

	@FindBy(xpath = "//*[@id='Accmsg']//p[@class='heading3']")
	WebElement TxtFd_mainMesage;
	
	@FindBy(xpath = "//*[text()='Account ID']/following-sibling::td")
	WebElement TxtFd_AccountID;
	
	@FindBy(xpath = "//*[text()='Customer ID']/following-sibling::td")
	WebElement TxtFd_CustomerID;
	
	@FindBy(xpath = "//*[text()='Customer Name']/following-sibling::td")
	WebElement TxtFd_CustomerName;
	
	@FindBy(xpath = "//*[text()='Email']/following-sibling::td")
	WebElement TxtFd_Email;
	
	@FindBy(xpath = "//*[text()='Account Type']/following-sibling::td")
	WebElement TxtFd_AccountType;
	
	@FindBy(xpath = "//*[text()='Date of Opening']/following-sibling::td")
	WebElement TxtFd_DateofOpening;
	
	@FindBy(xpath = "//*[text()='Current Amount']/following-sibling::td")
	WebElement TxtFd_CurrentAmount;

	/**
	 * Constructor
	 */
	public AccCreateMsg() {
	}

	public AccCreateMsg(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * ################################################## 
	 * ### ACTION
	 * ##################################################
	 */
	/**
	 * Action get main message of AccCreateMsg
	 * @throws Exception
	 */
	public String getMainMessage() throws Exception {
		return BasicFunction.getText(driver, TxtFd_mainMesage);
	}
	
	
	/**
	 * Action get account id from AccCreateMsg
	 * @throws Exception
	 */
	public String getAccountID() throws Exception {
		return BasicFunction.getText(driver, TxtFd_AccountID);
	}
	
	
	/**
	 * Action get customer id from AccCreateMsg
	 * @throws Exception
	 */
	public String getCustomerID() throws Exception {
		return BasicFunction.getText(driver, TxtFd_CustomerID);
	}
	
	
	/**
	 * Action get customer name from AccCreateMsg
	 * @throws Exception
	 */
	public String getCustomerName() throws Exception {
		return BasicFunction.getText(driver, TxtFd_CustomerName);
	}
	
	
	/**
	 * Action get email from AccCreateMsg
	 * @throws Exception
	 */
	public String getEmail() throws Exception {
		return BasicFunction.getText(driver, TxtFd_Email);
	}
	
	/**
	 * Action get account type from AccCreateMsg
	 * @throws Exception
	 */
	public String getAccounttype() throws Exception {
		return BasicFunction.getText(driver, TxtFd_AccountType);
	}

	
	/**
	 * Action get current amount of AccCreateMsg
	 * @throws Exception
	 */
	public String getCurrentAmount() throws Exception {
		return BasicFunction.getText(driver, TxtFd_CurrentAmount);
	}
	
	/**
     * ##################################################
     * ### FUNCTION
     * ##################################################
     */
    /**
     * 
     * Function verify Acoount info view correctly
     *
     * @throws Exception
     */

	public void verifyAccountInfo(String strAccountSuccessMessage, String strCustomerID, String strCustomerName,
			String strEmail, String strAccountType, String strCurrentAmount) throws Exception {
		Assert.assertTrue(this.getMainMessage().equals(strAccountSuccessMessage));
		Assert.assertTrue(this.getCustomerID().equals(strCustomerID));
		Assert.assertTrue(this.getCustomerName().equals(strCustomerName));
		Assert.assertTrue(this.getEmail().equals(strEmail));
		Assert.assertTrue(this.getAccounttype().equals(strAccountType));
		Assert.assertTrue(this.getCurrentAmount().equals(strCurrentAmount));
	}
}
