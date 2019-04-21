package co.zoopla.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import co.zoopla.Base.Base;

public class DetailPage extends Base {
	public DetailPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h1[@class='bottom-half']/b")
	private List<WebElement> agent_list;

	public String verifyAgent() {
		return agent_list.get(0).getText();
	}
}
