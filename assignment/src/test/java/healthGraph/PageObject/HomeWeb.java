package healthGraph.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomeWeb extends BasePage {

	private By logo = By.xpath("//*[@class='logo']//img");
	private By searchInput = By.name("q");
	
	public HomeWeb(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public HomeWeb load() {
		driver.get("https://openweathermap.org/");
		return this;
	}
	
	public boolean verifyLogo(){
		return isDisplayed(logo);
	}
	
	public boolean verifyNavBarOption(String option) {
		return isDisplayed(By.xpath("//*[@id='desktop-menu']//ul//*[normalize-space(text())='"+option+"']"));
	}
	
	public CityListWeb searchCity(String cityName) {
		waitAndFindElement(searchInput).sendKeys(cityName + Keys.RETURN);
		return new CityListWeb(driver);
	}
}
