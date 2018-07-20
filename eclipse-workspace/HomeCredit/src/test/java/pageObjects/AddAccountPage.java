package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasicFunction;

public class AddAccountPage {
	
	WebDriver driver;
	
	/**
     * ##################################################
     * ### DECLARE
     * ##################################################
     */
    /**
     * General item
     */
	@FindBy(name = "cusid")
	private WebElement Txb_CustomerID;
	
	@FindBy(name = "selaccount")
	private WebElement DrMn_AccountType;
	
	@FindBy(name = "inideposit")
	private WebElement Txb_InitialDeposit;
	
	@FindBy(name = "button2")
	private WebElement Btn_Submit;

	/**
     * Constructor
     */
	
	public AddAccountPage() {
	}

	public AddAccountPage(WebDriver driver) {
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
     * Action input Customer ID.
     *
     * @param strCustomerID
     * @throws Exception
     */
	public void setCustomerID(String strCustomerID) throws Exception {
		try {
			BasicFunction.inputText(driver, Txb_CustomerID, strCustomerID);
			} catch (Exception e) {
				throw new Exception("Failure Input Customer ID "+ strCustomerID +". Exception " + e);
		}
	}
	
	 /**
     * 
     * Action select Account type.
     *
     * @param strAccountType
     * @throws Exception
     */
	public void selectAccountType(String strAccountType) throws Exception {
		try {
			BasicFunction.selectByVisibleText(driver, DrMn_AccountType, strAccountType);
			} catch (Exception e) {
				throw new Exception("Failure select Account Type "+ strAccountType +". Exception " + e);
		}
	}
	
	/**
     * 
     * Action input Initial Deposit.
     *
     * @param strInitialDeposit
     * @throws Exception
     */
	public void setInitialDeposit(String strInitialDeposit) throws Exception {
		try {
			BasicFunction.inputText(driver, Txb_InitialDeposit, strInitialDeposit);
			} catch (Exception e) {
				throw new Exception("Failure Input Initial Deposit "+ strInitialDeposit +". Exception " + e);
		}
	}
	
	/**
     * 
     * Action click Submit button
     *
     * @throws Exception
     */
	public void clickSubmitButton() throws Exception {
		try {
			BasicFunction.clickElement(driver, Btn_Submit);
		} catch (Exception e) {
			throw new Exception("Failed Click Submit Button. Exception " + e);
		}
	}
	
	 /**
     * ##################################################
     * ### FUNCTION
     * ##################################################
     */
    /**
     * 
     * Function input Account info
     *
     * @throws Exception
     */

	public void addNewAccount(String strCustomerID, String strAccountType, String strInitialDeposit) throws Exception {
		this.setCustomerID(strCustomerID);
		this.selectAccountType(strAccountType);
		this.setInitialDeposit(strInitialDeposit);
		this.clickSubmitButton();
	}
}
