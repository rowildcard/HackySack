package utilities;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GoogSetUp {
	
	//	SetUp() - basic setup for Chrome webdriver for google.com testing
	public static WebDriver SetUp() {
	
		//	setup Chrome to open incognito
		ChromeOptions options = new ChromeOptions();
		options.addArguments("-incognito");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		//	Launch Chrome 
		WebDriver driver = new ChromeDriver(capabilities);
		
		//	turn on implicit wait timer
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
		
		//	navigate to google.com
		driver.get("https://www.google.com");
		return driver;	
	}
	
	//	UserLogin() - login to a Google test user
	//	              Pre-requisite - GoogSetUp.SetUp()
	public static void UserLogin(WebDriver d, String sUser, String sPw) {
		//	Page objects
		By byHomeSignIn = By.id("gb_70");
		By bySignInEmail = By.id("Email");
		By bySignInPasswd = By.id("Passwd");
		
		//	Click SIGN IN button
		d.findElement(byHomeSignIn).click();

		//	enter test user email
		d.findElement(bySignInEmail).sendKeys(sUser);
		d.findElement(bySignInEmail).sendKeys(Keys.RETURN);

		//	enter test user password
		d.findElement(bySignInPasswd).sendKeys(sPw);
		d.findElement(bySignInPasswd).sendKeys(Keys.RETURN);
		
	}	//	UserLogin()
}	//	class
