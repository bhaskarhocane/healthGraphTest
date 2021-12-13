package healthGraph.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseSetup {

	protected WebDriver driver;
	
	@BeforeMethod
	public WebDriver initializeDriver() {
		// Handling driver dependency
		WebDriverManager.chromedriver().cachePath("driverFolder").setup();

		// Initializing driver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	
	@AfterMethod
	public void quitDriver() {
		driver.quit();
	}
	
}
