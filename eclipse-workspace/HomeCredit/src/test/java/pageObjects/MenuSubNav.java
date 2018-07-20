package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasicFunction;

public class MenuSubNav {
	/**
     * ##################################################
     * ### DECLARE
     * ##################################################
     */
    /**
     * General item
     */
	@FindBy(xpath = "//*[text()='New Customer']")
	private WebElement LNav_NewCustomer;

	@FindBy(xpath = "//*[text()='New Account']")
	private WebElement LNav_NewAccount;

	@FindBy(xpath = "//*[text()='Deposit']")
	private WebElement LNav_Deposit;

	private WebDriver driver;

	/**
     * Constructor
     */
	
	public MenuSubNav() {
	}

	public MenuSubNav(WebDriver driver) {
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
     * Action click "Add Customer" menu at MenuSub Navigation.
     *
     * @throws Exception
     */
	public void clickAddCustomerMenu() throws Exception {
		try {
			BasicFunction.clickElement(driver, LNav_NewCustomer);
		} catch (Exception e) {
			throw new Exception("Failed Click Add Customer Menu. Exception " + e);
		}
	}
	
	/**
     * 
     * Action click "Add Account" menu at MenuSub Navigation.
     *
     * @throws Exception
     */
	public void clickAddAccountMenu() throws Exception {
		try {
			BasicFunction.clickElement(driver, LNav_NewAccount);
		} catch (Exception e) {
			throw new Exception("Failed Click Add Account Menu. Exception " + e);
		}
	}
	
	/**
     * 
     * Action click "Deposit" menu at MenuSub Navigation.
     *
     * @throws Exception
     */
	public void clickDepositMenu() throws Exception {
		try {
			BasicFunction.clickElement(driver, LNav_Deposit);
		} catch (Exception e) {
			throw new Exception("Failed Click Deposit Menu. Exception " + e);
		}
	}
}
