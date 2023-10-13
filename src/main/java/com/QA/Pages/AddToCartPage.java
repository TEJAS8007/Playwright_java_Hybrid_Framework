package com.QA.Pages;
import java.util.ArrayList;
import java.util.List;

import com.QA.utilities.CommonUtility;
import com.github.javafaker.Faker;
import com.microsoft.playwright.*;

public class AddToCartPage extends CommonUtility{

	Page page;



	private String productInfo="//*[@id=\"content\"]/div/div[2]/ul[1]";
	private String Addtocartbutton="button#button-cart";
	private String cartbutton="//*[@id=\"cart\"]/button";
	private String viewcartbutton="//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]";
	private String TableOrderData="//*[@id=\"content\"]/div[2]/div/table";
	private String OrderinCartTable="//*[@id=\"content\"]/form/div/table/tbody/tr/td[1]/a/img";
	private String removebutton="//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[2]";
	
	public AddToCartPage(Page page) {
		this.page=page;
	}

	public void getOrderDetails() {

		Locator productinformation= page.locator(productInfo);
		List<String>productinfoList= productinformation.allInnerTexts();

		for(String text :productinfoList) {
			System.out.println(text);
		}

	}

	public void clickAddtocartbutton() {
		page.waitForLoadState();
		page.locator(Addtocartbutton).click();
		page.waitForLoadState();
		page.locator(cartbutton).click();
		page.waitForLoadState();
		page.locator(viewcartbutton).click();
	}

	public boolean VerifyOrderinTable() {
		boolean found;

		if(page.locator(OrderinCartTable).isVisible()) {
			found=true;
		}
		else {
			found=false;
		}
		return found;
	}

	public void gettableorderData() {
		Locator tableData= page.locator(TableOrderData);
		List<String> tableList= tableData.allInnerTexts();

		for(String ele :tableList) {
			System.out.println(ele);
		}
	}

	public void clickonCheckoutButton() {
		page.locator(removebutton).click();
	}

	
}
