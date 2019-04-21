package co.zoopla.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import co.zoopla.Base.Base;

public class AgentInfoPage extends Base {
	public AgentInfoPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h4[@class='ui-agent__name']")
	private List<WebElement> agent_name;

	@FindBy(xpath = "//div[@class='ui-agent__logo']")
	private List<WebElement> agent_logo;

	@FindBy(xpath = "//p[@class='ui-agent__tel ui-agent__text']/a[@class='ui-link']")
	private List<WebElement> agent_no;

	public String getAgentName() {
		return agent_name.get(0).getText();
	}

	public boolean isAgentLogo() {
		return agent_logo.get(0).isDisplayed();
	}

	public String getAgent_no() {
		return agent_no.get(0).getText().replaceAll("[^0-9]", "");
	}

	public DetailPage clickAgentName() {
		agent_name.get(0).click();
		return new DetailPage();
	}
}