package pageObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import common.BasicFunction;

public class CustomerRegMsg {
	WebDriver driver;

	/**
	 * ################################################## 
	 * ### DECLARE
	 * ##################################################
	 */
	/**
	 * General item
	 */

	@FindBy(xpath = "//*[@id='customer']//p[@class='heading3']")
	WebElement TxtFd_mainMesage;
	
	@FindBy(xpath = "//*[text()='Customer ID']/following-sibling::td")
	WebElement TxtFd_CustomerID;
	
	@FindBy(xpath = "//*[text()='Customer Name']/following-sibling::td")
	WebElement TxtFd_CustomerName;
	
	@FindBy(xpath = "//*[text()='Gender']/following-sibling::td")
	WebElement TxtFd_Gender;
	
	@FindBy(xpath = "//*[text()='Birthdate']/following-sibling::td")
	WebElement TxtFd_Birthdate;
	
	@FindBy(xpath = "//*[text()='Address']/following-sibling::td")
	WebElement TxtFd_Address;
	
	@FindBy(xpath = "//*[text()='City']/following-sibling::td")
	WebElement TxtFd_City;
	
	@FindBy(xpath = "//*[text()='State']/following-sibling::td")
	WebElement TxtFd_State;
	
	@FindBy(xpath = "//*[text()='Pin']/following-sibling::td")
	WebElement TxtFd_Pin;
	
	@FindBy(xpath = "//*[text()='Mobile No.']/following-sibling::td")
	WebElement TxtFd_MobileNo;
	
	@FindBy(xpath = "//*[text()='Email']/following-sibling::td")
	WebElement TxtFd_Email;
	

	/**
	 * Constructor
	 */
	public CustomerRegMsg() {
	}

	public CustomerRegMsg(WebDriver driver) {
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
	 * Action get main message of CustomerRegMsg
	 * 
	 * @throws Exception
	 *
	 */

	public String getMainMessage() throws Exception {
		return BasicFunction.getText(driver, TxtFd_mainMesage);
	}
	
	/**
	 * 
	 * Action get customer id from CustomerRegMsg
	 * 
	 * @throws Exception
	 *
	 */

	public String getCustomerID() throws Exception {
		return BasicFunction.getText(driver, TxtFd_CustomerID);
	}
	
	/**
	 * 
	 * Action get customer name from CustomerRegMsg
	 * 
	 * @throws Exception
	 *
	 */

	public String getCustomerName() throws Exception {
		return BasicFunction.getText(driver, TxtFd_CustomerName);
	}
	
	/**
	 * 
	 * Action get gender from CustomerRegMsg
	 * 
	 * @throws Exception
	 *
	 */

	public String getGender() throws Exception {
		return BasicFunction.getText(driver, TxtFd_Gender);
	}
	
	/**
	 * 
	 * Action get birthdate from CustomerRegMsg
	 * 
	 * @throws Exception
	 *
	 */

	public String getBirthDate() throws Exception {
		return BasicFunction.getText(driver, TxtFd_Birthdate);
	}
	
	/**
	 * 
	 * Action get address from CustomerRegMsg
	 * 
	 * @throws Exception
	 *
	 */

	public String getAddress() throws Exception {
		return BasicFunction.getText(driver, TxtFd_Address);
	}
	
	/**
	 * 
	 * Action get city from CustomerRegMsg
	 * 
	 * @throws Exception
	 *
	 */

	public String getCity() throws Exception {
		return BasicFunction.getText(driver, TxtFd_City);
	}
	
	/**
	 * 
	 * Action get State from CustomerRegMsg
	 * 
	 * @throws Exception
	 *
	 */

	public String getState() throws Exception {
		return BasicFunction.getText(driver, TxtFd_State);
	}
	
	/**
	 * 
	 * Action get Pin from CustomerRegMsg
	 * 
	 * @throws Exception
	 *
	 */

	public String getPin() throws Exception {
		return BasicFunction.getText(driver, TxtFd_Pin);
	}
	
	/**
	 * 
	 * Action get Mobile No. from CustomerRegMsg
	 * 
	 * @throws Exception
	 *
	 */

	public String getMobileNo() throws Exception {
		return BasicFunction.getText(driver, TxtFd_MobileNo);
	}
	
	/**
	 * 
	 * Action get Email from CustomerRegMsg
	 * 
	 * @throws Exception
	 *
	 */

	public String getEmail() throws Exception {
		return BasicFunction.getText(driver, TxtFd_Email);
	}
	
	
	 /**
     * ##################################################
     * ### FUNCTION
     * ##################################################
     */
    /**
     * 
     * Function verify Customer info view correctly
     *
     * @throws Exception
     */

	public void verifyCustomerInfo(String strSuccessMessage, String strCustomerName, String strGender, String strDateofBirth, String strAddress, String strCity,
			String strState, String strPIN, String strMobileNumber, String strEmail) throws Exception {
		Date date = new SimpleDateFormat("MMddyyyy").parse(strDateofBirth);
		DateFormat customerFormDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String strDateofBirthNewFormat = customerFormDateFormat.format(date);
		
		Assert.assertTrue(this.getMainMessage().equals(strSuccessMessage));
		Assert.assertTrue(this.getCustomerName().equals(strCustomerName));
		Assert.assertTrue(this.getGender().equals(strGender));
		Assert.assertTrue(this.getBirthDate().equals(strDateofBirthNewFormat));
		Assert.assertTrue(this.getAddress().equals(strAddress));
		Assert.assertTrue(this.getCity().equals(strCity));
		Assert.assertTrue(this.getState().equals(strState));
		Assert.assertTrue(this.getPin().equals(strPIN));
		Assert.assertTrue(this.getMobileNo().equals(strMobileNumber));
		Assert.assertTrue(this.getEmail().equals(strEmail));
	}
}
