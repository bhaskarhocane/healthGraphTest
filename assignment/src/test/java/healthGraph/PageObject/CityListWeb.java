package healthGraph.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CityListWeb extends BasePage {

	private By notFoundLocator = By.xpath("//*[contains(@class,'alert-warning')]");
	private By cityListLocator = By.xpath("//*[@id='forecast_list_ul']//b//a");

	private String notFoundMessage = "Not found";

	public CityListWeb(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public boolean verifyCityInList(String cityName) {
		return waitAndFindElement(cityListLocator).getText().contains(cityName);
	}

	public boolean verifyNotFound() {
		return waitAndFindElement(notFoundLocator).getText().replace("×", "").trim().equals(notFoundMessage);
	}
	
	public CityDetailsWeb SelectCity(String cityName) {
		waitAndFindElement(cityListLocator).click();
		return new CityDetailsWeb(driver);
	}

}
