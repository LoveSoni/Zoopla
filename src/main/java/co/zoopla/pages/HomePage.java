package co.zoopla.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import co.zoopla.Base.Base;

public class HomePage extends Base {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='search-input-location']")
	private WebElement enter_location;

	@FindBy(xpath = "//button[@type='submit' and @value='Search']")
	private WebElement search_button;

	@FindBy(xpath = "//a[contains(@class,'listing-results-price')]")
	private List<WebElement> price_list;

	public void enterLocation(String location) {
		enter_location.sendKeys(location);
		search_button.click();
	}

	public String homePageTitle() {
		return driver.getTitle();
	}

	public List<WebElement> priceList() {
		return price_list;
	}

	public AgentInfoPage click5thProperty() {

		price_list.get(7).click();
		return new AgentInfoPage();
	}

}
