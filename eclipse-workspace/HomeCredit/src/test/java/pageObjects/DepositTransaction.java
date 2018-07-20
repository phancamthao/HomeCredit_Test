package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common.BasicFunction;

public class DepositTransaction {
	WebDriver driver;

	/**
	 * ################################################## 
	 * ### DECLARE
	 * ##################################################
	 */
	/**
	 * General item
	 */

	@FindBy(xpath = "//*[@id='deposit']//p[@class='heading3']")
	WebElement TxtFd_mainMesage;
	
	@FindBy(xpath = "//*[text()='Transaction ID']/following-sibling::td")
	WebElement TxtFd_TransactionID;
	
	@FindBy(xpath = "//*[text()='Account No']/following-sibling::td")
	WebElement TxtFd_AccountNo;
	
	@FindBy(xpath = "//*[text()='Amount Credited']/following-sibling::td")
	WebElement TxtFd_AmountCredited;
	
	@FindBy(xpath = "//*[text()='Type of Transaction']/following-sibling::td")
	WebElement TxtFd_TransactionType;
	
	@FindBy(xpath = "//*[text()='Description']/following-sibling::td")
	WebElement TxtFd_Description;
	
	@FindBy(xpath = "//*[text()='Current Balance']/following-sibling::td")
	WebElement TxtFd_CurrentBalance;

	/**
	 * Constructor
	 */
	public DepositTransaction() {
	}

	public DepositTransaction(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * ################################################## 
	 * ### ACTION
	 * ##################################################
	 */
	/**
	 * Action get main message of Deposit Transaction
	 * @throws Exception
	 */
	public String getMainMessage() throws Exception {
		return BasicFunction.getText(driver, TxtFd_mainMesage);
	}
	
	
	/**
	 * Action get ammount credited from Deposit Transaction
	 * @throws Exception
	 */
	public String getTransactionID() throws Exception {
		return BasicFunction.getText(driver, TxtFd_TransactionID);
	}
	
	
	/**
	 * Action get account no from Deposit Transaction
	 * @throws Exception
	 */
	public String getAccountNo() throws Exception {
		return BasicFunction.getText(driver, TxtFd_AccountNo);
	}
	
	
	/**
	 * Action get amount credited from Deposit Transaction
	 * @throws Exception
	 */
	public String getAmountCredited() throws Exception {
		return BasicFunction.getText(driver, TxtFd_AmountCredited);
	}
	
	
	/**
	 * Action get type of transaction from Deposit Transaction
	 * @throws Exception
	 */
	public String getTransactionType() throws Exception {
		return BasicFunction.getText(driver, TxtFd_TransactionType);
	}
	
	
	/**
	 * Action get description from Deposit Transaction
	 * @throws Exception
	 */
	public String getDescription() throws Exception {
		return BasicFunction.getText(driver, TxtFd_Description);
	}
	
	
	/**
	 * Action get current balance from Deposit Transaction
	 * @throws Exception
	 */
	public String getCurrentBalance() throws Exception {
		return BasicFunction.getText(driver, TxtFd_CurrentBalance);
	}
	
	 /**
     * ##################################################
     * ### FUNCTION
     * ##################################################
     */
    /**
     * 
     * Function verify transaction info view correctly after depositing
     *
     * @throws Exception
     */

	public void verifyDepositTransactionInfo(String strAccountNo,String strAmountCredited, 
			String strDescription, String strCurrentBalance) throws Exception {
		Assert.assertTrue(this.getMainMessage().contains(strAccountNo));
		Assert.assertTrue(this.getAccountNo().equals(strAccountNo));
		Assert.assertTrue(this.getAmountCredited().equals(strAmountCredited));
		Assert.assertTrue(this.getTransactionType().equals("Deposit"));
		Assert.assertTrue(this.getDescription().equals(strDescription));
		Assert.assertTrue(this.getCurrentBalance().equals(strCurrentBalance));
	}
	
}
