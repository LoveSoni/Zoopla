package com.zoopla.TestPages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import co.zoopla.Base.Base;
import co.zoopla.pages.HomePage;

public class HomePageTest extends Base {
	private HomePage hpage;

	@BeforeMethod
	public void setUp() {
		init();
		hpage = new HomePage();
	}

	@Test()
	public void HomePageTitleTest() {
		String title = hpage.homePageTitle();
		Assert.assertEquals(title, "Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents");
	}

	@Test
	public void sortPrice() throws InterruptedException {
		hpage.enterLocation("London");
		List<WebElement> list = hpage.priceList();
		List<Integer> pricelist = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			String price[] = list.get(i).getText().split(" ");
			pricelist.add(Integer.parseInt(price[0].replace(",", "").replace("£", "")));
		}
		Collections.sort(pricelist, Collections.reverseOrder());
		for (int i = 0; i < pricelist.size(); i++) {
			System.out.println(pricelist.get(i));
		}

	}

	@AfterMethod()
	public void tearDown() {
		driver.quit();
	}
}
