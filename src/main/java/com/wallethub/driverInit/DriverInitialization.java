package com.wallethub.driverInit;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.wallethub.webUtilities.PropertyUtils;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInitialization extends AbstractTestNGCucumberTests {

	public static String osName = System.getProperty("os.name");
	
	/**
	 * This method is used to set driver and get the URL
	 */
	@Parameters({ "browsername" })
	@BeforeMethod
	public static void driverInit(String browsername) throws MalformedURLException {
		DriverManager.setDriver(getBrowserDriver(browsername));
		
		
	}

	/**
	 * Chrome/Firefox Driver is called based on argument Browser
	 */
	public static WebDriver getBrowserDriver(String browser) throws MalformedURLException {

		URL hubUrl = new URL(PropertyUtils.configProperty("dockerURL")); // HUB URL
		String runmode = PropertyUtils.configProperty("runmode");
		

		WebDriver browserdriver = null;
		String chromeBrowserProfile;
		if (browser.equalsIgnoreCase("chrome")) {
			if (osName.contains("Mac")) {
				chromeBrowserProfile="--user-data-dir=~/Library/Application Support/Google/Chrome/Profile 2";
			}
			else if (osName.contains("Win")) {
				chromeBrowserProfile="--user-data-dir=%LOCALAPPDATA%\\Google\\Chrome\\User Data\\Google\\Chrome\\User Data\\Profile 2";
			}
			else {
				chromeBrowserProfile="--user-data-dir=~/.config/google-chrome";
			}
			
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_settings.popups", 0);
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--no-sandbox", "--disable-dev-shm-usage", "--disable-notifications");
			
			
			options.addArguments(chromeBrowserProfile);
			
			options.setCapability("platform", "Any");

			if (runmode.equalsIgnoreCase("remote")) {
				browserdriver = new RemoteWebDriver(hubUrl, options);
				((RemoteWebDriver) browserdriver).setFileDetector(new LocalFileDetector());
			} else {
		        WebDriverManager.chromedriver().setup();
				browserdriver = new ChromeDriver(options);
				

				
			}

		} else if (browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			FirefoxProfile profile = new FirefoxProfile();
			profile.setAcceptUntrustedCertificates(true);
			profile.setPreference("security.OCSP.enabled", 0);
			profile.setPreference("network.http.use-cache", false);

			if (runmode.equalsIgnoreCase("remote")) {
				options.setProfile(profile);
				options.setCapability("platform", "Any");
				browserdriver = new RemoteWebDriver(hubUrl, options);
				((RemoteWebDriver) browserdriver).setFileDetector(new LocalFileDetector());
			} else {
				options.setProfile(profile);
				options.setCapability("marionette", true);
				WebDriverManager.firefoxdriver().setup();
				browserdriver = new FirefoxDriver(options);
				

			}
		}
		return browserdriver;
	}

	/**
	 * Quit the Driver after each run
	 */
	@AfterMethod
	public static void teardown() {
		DriverManager.getDriver().quit();

	}
}
