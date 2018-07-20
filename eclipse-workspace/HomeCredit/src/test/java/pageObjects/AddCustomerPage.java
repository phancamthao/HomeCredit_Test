package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import common.BasicFunction;

public class AddCustomerPage {
	/**
     * ##################################################
     * ### DECLARE
     * ##################################################
     */
    /**
     * General item
     */
	@FindBy(name = "name")
	private WebElement Txb_CustomerName;

	@FindBy(name = "rad1")
	private WebElement RbBtn_Male;
	
	@FindBy(name = "rad2")
	private WebElement RbBtn_Female;

	@FindBy(id = "dob")
	private WebElement DtPck_DateofBirth;
	
	@FindBy(name = "addr")
	private WebElement TxtFd_Address;
	
	@FindBy(name = "city")
	private WebElement Txb_City;
	
	@FindBy(name = "state")
	private WebElement Txb_State;
	
	@FindBy(name = "pinno")
	private WebElement Txb_PIN;
	
	@FindBy(name = "telephoneno")
	private WebElement Txb_MobileNumber;
	
	@FindBy(name = "emailid")
	private WebElement Txb_Email;
	
	@FindBy(name = "password")
	private WebElement Txb_Password;
	
	@FindBy(name = "sub")
	private WebElement Btn_Submit;

	private WebDriver driver;

	/**
     * Constructor
     */
	
	public AddCustomerPage() {
	}

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
     * ##################################################
     * ### ACTION SET TEXT
     * ##################################################
     */    
 

	 /**
     * 
     * Action input Customer Name.
     *
     * @param strCustomerName
     * @throws Exception
     */
	public void setCustomerName(String strCustomerName) throws Exception {
		try {
			BasicFunction.inputText(driver, Txb_CustomerName, strCustomerName);
			} catch (Exception e) {
				throw new Exception("Failure Input UserName "+ strCustomerName +". Exception " + e);
		}
	}
	
	/**
     * 
     * Action click "Male" ratio at Gender.
     *
     * @throws Exception
     */
	public void clickMaleRatio() throws Exception {
		try {
			BasicFunction.clickElement(driver, RbBtn_Male);
		} catch (Exception e) {
			throw new Exception("Failed Click Male ratio at Gender. Exception " + e);
		}
	}
	
	/**
     * 
     * Action click "Female" ratio at Gender.
     *
     * @throws Exception
     */
	public void clickFemaleRatio() throws Exception {
		try {
			BasicFunction.clickElement(driver, RbBtn_Female);
		} catch (Exception e) {
			throw new Exception("Failed Click Female ratio at Gender. Exception " + e);
		}
	}
	
	/**
     * 
     * Action input Date of Birth.
     *
     * @param strDateofBirth
     * @throws Exception
     */
	public void setDateofBirth(String strDateofBirth) throws Exception {
		try {
			BasicFunction.inputText(driver, DtPck_DateofBirth, strDateofBirth);
			} catch (Exception e) {
				throw new Exception("Failure Input Date "+ strDateofBirth +". Exception " + e);
		}
	}
	
	/**
     * 
     * Action input Address.
     *
     * @param strAddress
     * @throws Exception
     */
	public void setAddress(String strAddress) throws Exception {
		try {
			BasicFunction.inputText(driver, TxtFd_Address, strAddress);
			} catch (Exception e) {
				throw new Exception("Failure Input Address "+ strAddress +". Exception " + e);
		}
	}
	
	/**
     * 
     * Action input City.
     *
     * @param strCity
     * @throws Exception
     */
	public void setCity(String strCity) throws Exception {
		try {
			BasicFunction.inputText(driver, Txb_City, strCity);
			} catch (Exception e) {
				throw new Exception("Failure Input City "+ strCity +". Exception " + e);
		}
	}
	
	/**
     * 
     * Action input State.
     *
     * @param strState
     * @throws Exception
     */
	public void setState(String strState) throws Exception {
		try {
			BasicFunction.inputText(driver, Txb_State, strState);
			} catch (Exception e) {
				throw new Exception("Failure Input State "+ strState +". Exception " + e);
		}
	}
	
	/**
     * 
     * Action input PIN.
     *
     * @param strState
     * @throws Exception
     */
	public void setPIN(String strPIN) throws Exception {
		try {
			BasicFunction.inputText(driver, Txb_PIN, strPIN);
			} catch (Exception e) {
				throw new Exception("Failure Input PIN "+ strPIN +". Exception " + e);
		}
	}
	
	/**
     * 
     * Action input Mobile Number.
     *
     * @param strMobileNumber
     * @throws Exception
     */
	public void setMobileNumber(String strMobileNumber) throws Exception {
		try {
			BasicFunction.inputText(driver, Txb_MobileNumber, strMobileNumber);
			} catch (Exception e) {
				throw new Exception("Failure Input Mobile Number "+ strMobileNumber +". Exception " + e);
		}
	}
	
	/**
     * 
     * Action input E-mail.
     *
     * @param strEmail
     * @throws Exception
     */
	public void setEmail(String strEmail) throws Exception {
		try {
			BasicFunction.inputText(driver, Txb_Email, strEmail);
			} catch (Exception e) {
				throw new Exception("Failure Input Email "+ strEmail +". Exception " + e);
		}
	}
	
	/**
     * 
     * Action input Password.
     *
     * @param 
     * @throws Exception
     */
	public void setPassword(String strPassword) throws Exception {
		try {
			BasicFunction.inputText(driver, Txb_Password, strPassword);
			} catch (Exception e) {
				throw new Exception("Failure Input Password "+ strPassword +". Exception " + e);
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
     * Function verify Customer info
     *
     * @throws Exception
     */

	public void addNewCustomer(String strCustomerName, String strGender, String strDateofBirth, String strAddress, String strCity,
			String strState, String strPIN, String strMobileNumber, String strEmail, String strCustomerPassword) throws Exception {
		this.setCustomerName(strCustomerName);
		if (strGender.equals("male")) {
			this.clickMaleRatio();
		} else if (strGender.equals("female")){
			this.clickFemaleRatio();
		} else {
			System.out.println("Invalid gender type!!!");
		}
		this.setDateofBirth(strDateofBirth);
		this.setAddress(strAddress);
		this.setCity(strCity);
		this.setState(strState);
		this.setPIN(strPIN);
		this.setMobileNumber(strMobileNumber);
		this.setEmail(strEmail);
		this.setPassword(strCustomerPassword);
		this.clickSubmitButton();
	}
	
	
}
