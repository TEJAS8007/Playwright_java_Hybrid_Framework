package com.qa.opencart.test;

import org.testng.annotations.Test;
import com.qa.opencaert.base.BaseTest;
public class AddToCartPageTest extends BaseTest{


	@Test(priority = 1)
	public void getOrderDetailsTest() {
		add= homepage.NavigateToAddToCartPage();
		add.getOrderDetails();
		log.warn("Order Details Fetched Succesfully");
	}

	@Test(priority = 2)
	public void click_on_addtocart_Test() {
		add.clickAddtocartbutton();
		log.warn("Click on addtocart button");
	}

	@Test(priority = 3)
	public void getOrderDataTest() {
		add.gettableorderData();
		log.warn("Order Data Fetche Succesfully");
	}

	@Test(priority = 4)
	public void ClickonRemoveTest() {
		add.clickonCheckoutButton();
		log.info("click on remove button");
	}

}
