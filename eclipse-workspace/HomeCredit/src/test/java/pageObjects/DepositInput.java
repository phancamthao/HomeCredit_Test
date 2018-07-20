package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasicFunction;

public class DepositInput {
WebDriver driver;
	
	/**
     * ##################################################
     * ### DECLARE
     * ##################################################
     */
    /**
     * General item
     */
	@FindBy(name = "accountno")
	private WebElement Txb_AccountNo;
	
	@FindBy(name = "ammount")
	private WebElement Txb_Amount;
	
	@FindBy(name = "desc")
	private WebElement Txb_Description;
	
	@FindBy(name = "AccSubmit")
	private WebElement Btn_Submit;

	/**
     * Constructor
     */
	
	public DepositInput() {
	}

	public DepositInput(WebDriver driver) {
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
     * Action input Account No.
     *
     * @param strAccountNo
     * @throws Exception
     */
	public void setAccountNo(String strAccountNo) throws Exception {
		try {
			BasicFunction.inputText(driver, Txb_AccountNo, strAccountNo);
			} catch (Exception e) {
				throw new Exception("Failure Input Account No "+ strAccountNo +". Exception " + e);
		}
	}
	
	 /**
     * 
     * Action input Amount.
     *
     * @param strAmount
     * @throws Exception
     */
	public void setAmount(String strAmount) throws Exception {
		try {
			BasicFunction.inputText(driver, Txb_Amount, strAmount);
			} catch (Exception e) {
				throw new Exception("Failure Input Amount "+ strAmount +". Exception " + e);
		}
	}
	
	/**
     * 
     * Action input Description.
     *
     * @param strDescription
     * @throws Exception
     */
	public void setDescription(String strDescription) throws Exception {
		try {
			BasicFunction.inputText(driver, Txb_Description, strDescription);
			} catch (Exception e) {
				throw new Exception("Failure Input Descriptiont "+ strDescription +". Exception " + e);
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
     * Function add new deposit info
     *
     * @throws Exception
     */

	public void addNewDeposit(String strAccountNo, String strDepositAmount, String strDescription) throws Exception {
		this.setAccountNo(strAccountNo);
		this.setAmount(strDepositAmount);
		this.setDescription(strDescription);
		this.clickSubmitButton();
	}
}
