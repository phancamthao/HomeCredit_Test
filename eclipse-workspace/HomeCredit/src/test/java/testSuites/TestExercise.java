package testSuites;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import drivers.WebdriverFactory;
import pageObjects.AccCreateMsg;
import pageObjects.AddAccountPage;
import pageObjects.AddCustomerPage;
import pageObjects.CustomerRegMsg;
import pageObjects.DepositInput;
import pageObjects.DepositTransaction;
import pageObjects.LoginPage;
import pageObjects.ManagerHomePage;
import pageObjects.MenuSubNav;


public class TestExercise extends WebdriverFactory{
	static WebDriver driver;
	/**
	 * * TEST CASE DESCRIPTION
	 * 1. This test go to http://demo.guru99.com/V4/
	 * 
	 * 2. Verify login page title as guru99 bank
	 * 
	 * 3. Login to application
	 * 
	 * 4. Verify manager user in HomePage's dashboard
	 * 
	 * 5. Add new customer 
	 * 
	 * 6. Verify new customer info after adding
	 * 
	 * 7. Create new account based on above customer
	 * 
	 * 8. Verify the account info after creating
	 * 
	 * 9. Execute deposit function with above account
	 * 
	 * 10. Verify the deposit transaction info
	 * 
	 * @throws Exception
	 * 
	 */

	@Test
	public void HomeCreditExercise() throws Exception {
		
		/**
	     * ##################################################
	     * ### INIT
	     * ##################################################
	     */
		WebDriver driver = setupDriver("chrome");
		String strUserName = "mgr123"; 
		String strPassword = "mgr!23";
		String strLoginTitleKeyWord = "guru99 bank";
		
		String strCustomerName = "customerthaophan";
		String strGender = "male";
		String strDateofBirth = "11122018"; 
		
		String strAddress = "123ABC"; 
		String strCity = "HCM"; 
		String strState = "BinhThanh"; 
		String strPIN = "123456"; 
		String strMobileNumber = "0123456789"; 
		String strEmail = "custthaophan@gmail.com";
		String strCustomerPassword = "Customer1!!";
		String strCustomerSuccessMessage = "Customer Registered Successfully!!!";
		
		String strCustomerID;
		String strAccountType = "Savings"; 
		String strInitialDeposit = "40000";
		String strAccountSuccessMessage = "Account Generated Successfully!!!";
		
		String strAccountNo;
		String strCurrentAmount;
		String strDepositAmount ="200";
		String strDescription = "Testing";
		
		/**
	     * ##################################################
	     * ### 1. This test go to http://demo.guru99.com/V4/
	     * ##################################################
	     */
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4/");

		
		/**
	     * ##################################################
	     * ### 2. Verify login page title as guru99 bank
	     * ##################################################
	     */
		// Create Login Page object
		LoginPage loginPage = new LoginPage(driver);
		// Verify login page title
		loginPage.verifyTitleContainSpecificKeyWord(strLoginTitleKeyWord);
		
		
		/**
	     * ##################################################
	     * ### 3. Login to application
	     * ##################################################
	     */
		// Login to application
		loginPage.loginwithUserandPass(strUserName, strPassword);;
		
		
		/**
	     * ##################################################
	     * ### 4. Verify manager user in HomePage's dashboard
	     * ##################################################
	     */
		// Generate Manager Home Page object
		ManagerHomePage managerHomePage = new ManagerHomePage(driver);
		// Verify home page dashboard username
		managerHomePage.verifyUserNameViewinDashBoard(strUserName);
		
		
		/**
	     * ##################################################
	     * ### 5. Add new customer 
	     * ##################################################
	     */
		// Initilize MenuSub Navigation object
		MenuSubNav menuSubNav = new MenuSubNav(driver);
		// Click New "Add Customer" menu
		menuSubNav.clickAddCustomerMenu();
		// Initilize Add Customer Page object
		AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
		// Add new Customer
		addCustomerPage.addNewCustomer(strCustomerName, strGender, strDateofBirth, 
				strAddress, strCity, strState, strPIN, strMobileNumber, strEmail, 
				strCustomerPassword);
		
		
		/**
	     * ##################################################
	     * ### 6. Verify new customer info after adding
	     * ##################################################
	     */
		// Initilize CustomerRegMsg Page object
		CustomerRegMsg customerRegMsg = new CustomerRegMsg(driver);
		// Verify CustomerReg Message
		customerRegMsg.verifyCustomerInfo(strCustomerSuccessMessage, strCustomerName, 
				strGender, strDateofBirth, strAddress, strCity, strState, strPIN, 
				strMobileNumber, strEmail);
		//New variable to save Customer ID
		strCustomerID = customerRegMsg.getCustomerID();
		
		
		/**
	     * ##################################################
	     * ### 7. Create new account based on above customer
	     * ##################################################
	     */
		//Navigate to Add Account at MenuSubNav
		menuSubNav.clickAddAccountMenu();
		// Initilize Add Customer Page object
		AddAccountPage addAccountPage = new AddAccountPage(driver);
		// Add new account based on the customer just created above
		addAccountPage.addNewAccount(strCustomerID, strAccountType, strInitialDeposit);;
		
		
		/**
	     * ##################################################
	     * ### 8. Verify the account info after creating 
	     * ##################################################
	     */
		// Initilize Account Create Message Page object
		AccCreateMsg accCreateMsg = new AccCreateMsg(driver);	
		// Verify Account Create Message
		accCreateMsg.verifyAccountInfo(strAccountSuccessMessage, strCustomerID, 
				strCustomerName, strEmail, strAccountType, strInitialDeposit);
		//New variable to save Account ID and its Current Amount
		strAccountNo = accCreateMsg.getAccountID();
		strCurrentAmount = accCreateMsg.getCurrentAmount();
		int currentAmount = Integer.parseInt(strCurrentAmount);
		
		
		/**
	     * ##################################################
	     * ### 9. Execute deposit function with above account
	     * ##################################################
	     */
		//Navigate to Deposit Menu at MenuSubNav
		menuSubNav.clickDepositMenu();	
		// Initilize DepositInput Page object
		DepositInput depositInput = new DepositInput(driver);
		// Add new deposit based on the account just created above
		depositInput.addNewDeposit(strAccountNo, strDepositAmount, strDescription);;
		//Calculate the current balance
		int despositamount = Integer.parseInt("200");
		int currentbalance = currentAmount + despositamount;
		String strCurrentBalance = Integer.toString(currentbalance);
		
		
		/**
	     * ##################################################
	     * ### 10. Verify the deposit transaction info
	     * ##################################################
	     */
		// Initilize DepositTransaction Page object
		DepositTransaction depositTransaction = new DepositTransaction(driver);
		// Verify Deposit Transaction Details Message
		depositTransaction.verifyDepositTransactionInfo(strAccountNo, strDepositAmount, 
				strDescription, strCurrentBalance);
		
		//Quit driver session
		driver.quit();
	}

}