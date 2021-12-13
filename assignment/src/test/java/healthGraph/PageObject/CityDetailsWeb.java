package healthGraph.PageObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CityDetailsWeb extends BasePage {

	public CityDetailsWeb(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private String dateFormat(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("EEE, MMM d");
		return formatter.format(date);
	}

	private Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days); // minus number would decrement the days
		return cal.getTime();
	}
	
	public boolean verifyNext8Dates() {
		for (int i = 1; i <= 7; i++) {
			if(!waitAndFindElement(By.xpath("(//*[@class='day-list']//li)["+i+"]")).getText().contains(dateFormat(addDays(new Date(), i-1))))
				return false;
		}
		return true;
	}

}
