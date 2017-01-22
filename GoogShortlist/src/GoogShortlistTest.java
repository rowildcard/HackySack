//	JavaSE 1.8
//	Selenium 3.0.1
//	Maven 3.5.1
//	TestNG 6.9.6
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.GoogSetUp;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//	Pendo Automation Challenge  01-20-2017
//	Using google.com 'Shopping' filter:
//	- search for a product
//	- select the Nth product
//	- dd to user's shortlist with a note

public class GoogShortlistTest {
	
	static WebDriver driver;
	static String sUser = "hackysack181@gmail.com";	//	store in text file
	static String sPwd = "pend0ch1J";				//	store in text file
		
	//	Before each @Test --------------------------
	@BeforeMethod
	public static void BeforeTests() {
		driver = GoogSetUp.SetUp();
		GoogSetUp.UserLogin(driver, sUser, sPwd);
	}
	
	//	After each @Test ---------------------------	
	@AfterMethod
	public static void AfterTests() {
		driver.quit();
	}
	
	//	@Test --------------------------------------	
	@Test
	public static void ShortlistTest() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element;
		String sProdSrch = "hacky sack\n";
		String sProdName = "";
		
		//	Page Objects (Home, Results, Product, Shop)
		By byHomeSearchBox = By.name("q");
		
		By byResultsShop = By.xpath(".//*[@id='hdtb-msb']/div[1]/div[2]/a");
		
		// ------------------------------------------------------v Nth product on results page
		By byProductN = By.xpath(".//*[@id='rso']/div[1]/div/div[4]/div[1]/h3/a");
		
		By byShopShortlistBtn = By.cssSelector("*[class$='gko-add']");
		By byShopAddNote = By.cssSelector("*[class$='_-b']");
		By byShopViewShortlist = By.cssSelector("*[class$='gko-ctrl-cp']");
		
		//	Search for product
		driver.findElement(byHomeSearchBox).sendKeys(sProdSrch);

		//	click 'Shopping' filter
		driver.findElement(byResultsShop).click();

		//	click Nth product 
		driver.findElement(byProductN).click();
		
		//	click 'Save to Shortlist' button
		//	ISSUE: If product is already on user's shortlist, the button changes & rmvs the product (test cleanup)
		wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.elementToBeClickable(byShopShortlistBtn) );
		driver.findElement(byShopShortlistBtn).click();

		//	click 'Add Note' on alertdialog
		// driver.findElement(byShopAddNote).click();			*selenium.ElementNotVisibleException
		
		//	click 'View Shortlist'
		driver.findElement(byShopViewShortlist).click();	//	does not work
		
		//	add Note "Please buy me"							TBD
		
	}	//	ShortlistTest()
}	//	class