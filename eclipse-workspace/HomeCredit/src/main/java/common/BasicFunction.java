package common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasicFunction {
	private static long defaultWait = Long.getLong("defaultWait", 120);

	public static void inputText(WebDriver driver, WebElement element, String text) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, defaultWait);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.sendKeys(text);
		} catch (Exception ex) {
			throw new Exception(" FAILED.\nException: " + ex + "\n");
		}
	}

	public static void clickElement(WebDriver driver, WebElement element) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, defaultWait);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}

	public static boolean isElementExisted(WebDriver driver, WebElement element) throws Exception {
		try {
			if (element == null)
				return false;
			else
				return true;

		} catch (Exception ex) {
			throw new Exception("isElementExisted - Failed - Exception occurs: " + ex);
		}
	}

	public static String getCurrentWindow(WebDriver driver) {
		try {
			String currentWindows = driver.getWindowHandle();
			return currentWindows;
		} catch (Exception e) {
			throw e;
		}
	}

	public static void selectByVisibleText(WebDriver driver, WebElement element, String visibleText) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 200);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Select select = new Select(element);
			select.selectByVisibleText(visibleText);
		} catch (Exception ex) {
			throw new Exception("selectByVisibleText - Failed - Exception occurs: " + ex);
		}
	}
	
	public static void waitForPageLoadCompleted(WebDriver driver, int timeout)
			throws Exception {
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver _driver) {
				return ((JavascriptExecutor) _driver)
						.executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(expectation);
		} catch (Exception ex) {
			throw new Exception("waitForPageLoadCompleted - Failed - Exception occurs: " + ex);
		}
	}
	

	public static String getText(WebDriver driver, WebElement element) throws Exception {
		try {
			String text = element.getText();
			return text;
		} catch (Exception ex) {
			throw new Exception("getText - Failed - Exception occurs: " + ex);
		}
	}
	
}
