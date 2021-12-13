package healthGraph.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import healthGraph.PageObject.CityDetailsWeb;
import healthGraph.PageObject.CityListWeb;
import healthGraph.PageObject.HomeWeb;
import healthGraph.base.TestBaseSetup;

public class TestScenario1 extends TestBaseSetup {

	@Test(description="verify logo and Nav bar")
	public void test1() {

		String[] navBarOptions = { "Guide", "API", "Pricing", "Maps", "Our Initiatives", "Partners", "Blog",
				"Marketplace", "Sign in", "Support" };

		HomeWeb homeWeb = new HomeWeb(driver).load();
		Assert.assertTrue(homeWeb.verifyLogo());

		for (String navBarOption : navBarOptions) {
			Assert.assertTrue(homeWeb.verifyNavBarOption(navBarOption));
		}
	}

	@Test(description="Search City -ve")
	public void test2() {
		String cityName = "CityThatDoesn'tExist";

		HomeWeb homeWeb = new HomeWeb(driver);

		CityListWeb cityListWeb = homeWeb.load().searchCity(cityName);
		Assert.assertTrue(cityListWeb.verifyNotFound());
	}

	@Test(description = "Search City +ve")
	public void test3() {
		String cityName = "Mumbai";

		HomeWeb homeWeb = new HomeWeb(driver);

		CityListWeb cityListWeb = homeWeb.load().searchCity(cityName);
		Assert.assertTrue(cityListWeb.verifyCityInList(cityName));
	}

	@Test(description = "verify Next 8 days Date in City Details Page")
	public void test4() {
		String cityName = "Mumbai";

		CityDetailsWeb cityDetailsWeb = new HomeWeb(driver).load().searchCity(cityName).SelectCity(cityName);
		
		Assert.assertTrue(cityDetailsWeb.verifyNext8Dates());
		

	}

}
