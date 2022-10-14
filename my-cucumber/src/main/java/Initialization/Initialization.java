/**
 * 
 */
package Initialization;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author przem
 *
 */
public class Initialization {

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	public static String url;
	public static String browserName;

	public static void setWebDriver(ThreadLocal<RemoteWebDriver> driver) {

		setBrowserName();
		setAddressUrl();
		initSeleniumDriver(driver);

		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
	}

	public static WebDriver getDriver() {
		return driver.get();
	}

	private static void setBrowserName() {
		
		browserName = System.getProperty("browser");
		
		if(browserName.isEmpty()) {
			browserName = "chrome";
		}
	}

	private static void setAddressUrl() {
	
		url = System.getProperty("url");
		
		if(url.isEmpty()) {
			url = "www.google.pl";
		}
		
	}

	private static void initSeleniumDriver(ThreadLocal<RemoteWebDriver> driver) {

		if (browserName.equalsIgnoreCase("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());

		} else if (browserName.equalsIgnoreCase("Firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}
	}
}
