package drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverFactory {
	private static WebDriver driver;

	public static WebDriver getWebDriver() {
		return driver;
	}

	public static WebDriver setupDriver(String browser) {
		if (browser.equals("chrome")) {
			if (driver == null) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}

		} else if ((browser.equals("firefox"))) {
			if (driver == null) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		} else {
			// Default is firefox
			if (driver == null) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
}
