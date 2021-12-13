package healthGraph.PageObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import healthGraph.base.TestBaseSetup;

public class BasePage extends TestBaseSetup {

	WebDriver driver;

	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement waitAndFindElement(By locator) {
		WebDriverWait extWait = new WebDriverWait(driver, Duration.ofSeconds(30));;
		return highlightElement(extWait.until(ExpectedConditions.visibilityOfElementLocated(locator)));
	}
	
	private WebElement highlightElement(WebElement element)
	{
		((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid red'", element);
		return element;
	}
	
	public boolean isDisplayed(By locator) {
		boolean result = driver.findElement(locator).isDisplayed();
		if(result)
			((JavascriptExecutor) driver).executeScript("arguments[0].style.border='2px solid blue'", driver.findElement(locator));
		return result;
	}
	
}
