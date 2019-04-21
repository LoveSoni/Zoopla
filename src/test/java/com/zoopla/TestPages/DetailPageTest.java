package com.zoopla.TestPages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import co.zoopla.Base.Base;
import co.zoopla.pages.AgentInfoPage;
import co.zoopla.pages.DetailPage;
import co.zoopla.pages.HomePage;

public class DetailPageTest extends Base {
	private HomePage hpage;
	private AgentInfoPage apage;
	private DetailPage dpage;
	String agentname;

	@BeforeMethod
	public void setUp() {
		init();
		hpage = new HomePage();
		hpage.enterLocation("London");
		apage = hpage.click5thProperty();
		agentname = apage.getAgentName();
		dpage = apage.clickAgentName();

	}

	@Test
	public void verifyAgent() {
		Assert.assertEquals(agentname, dpage.verifyAgent());
	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
}
