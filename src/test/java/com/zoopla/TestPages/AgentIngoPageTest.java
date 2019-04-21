package com.zoopla.TestPages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import co.zoopla.Base.Base;
import co.zoopla.pages.AgentInfoPage;
import co.zoopla.pages.HomePage;

public class AgentIngoPageTest extends Base {
	private HomePage hpage;
	private AgentInfoPage dpage;

	@BeforeMethod
	public void setUp() {
		init();
		hpage = new HomePage();
		hpage.enterLocation("London");
		dpage = hpage.click5thProperty();
	}

	@Test
	public void agentInfo() {
		System.out.println("Agent Name is : " + dpage.getAgentName());
		System.out.println("Agent Logo is Displayed : " + dpage.isAgentLogo());
		System.out.println("Agent Number is : " + dpage.getAgent_no());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
