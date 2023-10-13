package com.qa.opencart.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.QA.utilities.CommonUtility;
import com.qa.opencaert.base.BaseTest;

public class HomePageTest extends BaseTest{

	@Test(priority = 1)
	public void HomepagetitleTest() {
		String Actualtitle= homepage.getHomePageTitle();
		String ExpectedTitle="Your Store";
		log.warn("HomePage title Matching");
		if(Actualtitle.equals(ExpectedTitle)) {
			Assert.assertTrue(true);
			log.warn("HomePage title Matched");
		}else {
			Assert.assertTrue(false);
			log.warn("HomePage title not Matched");
		}
	}

	@Test(priority = 2)
	public void HomepageurlTest() {
		String Actualurl= homepage.getHomePageUrl();
		String Expectedurl="https://naveenautomationlabs.com/opencart/";
		log.warn("HomePage title Matching");
		if(Actualurl.equals(Expectedurl)) {
			Assert.assertTrue(true);
			log.warn("HomePage title Matched");
		}else {
			Assert.assertTrue(false);
			log.warn("HomePage title not Matched");
		}
	}

	@Test(priority = 6, dataProvider = "getDataForSearch")
	public void HomepouctTest(String product) {
	    String header = homepage.SearchProduct(product);
	    String expectedheader = "Search - " + product;
	    log.warn("Checking Home Page Serch data");
	    if (header.equals(expectedheader)) {
	        Assert.assertTrue(true);
	        log.warn("Home Page Serch data matched");
	    } else {
	        Assert.assertTrue(false);
	        log.warn("Home Page Serch data matched");
	    }
	}

	
	@Test(priority = 4)
	public void navigateToLoginPage() {
	boolean a= homepage.findMackbook();
	System.out.println("Mackbook Exist on HomePage :"+a);
	log.info("mackbook found");
	}
	
	@Test(priority = 3)
	public void HomePageProductsTest() {
		String present= homepage.ValidateHomePageVisibleProductsText();
		String expected="Featured";
		log.warn("Home Page product text checking");
		if(present.equals(expected)) {
			Assert.assertTrue(true);
			log.warn("Home Page product text matched");
		}
		else {
			Assert.assertTrue(false);
			log.warn("Home Page product text not matched");
		}
	}
	
	@Test(priority = 5)
	public void validateFooterHyperLinkTest() {
		List<String> linkList= homepage.ValidateFooterHyperLink();
		
		for(String list :linkList) {
			System.out.println(list);
		}
		log.info("Home Page product text checking");
	}
	
	@DataProvider
	public Object[][] getDataForSearch(){
		return new Object[][] {{"Apple"},{"Samsung"},{"Mackbook"}};		
	//	Object[][] obj=CommonUtility.getExcelData();
	//	return obj;
	}
	
	
}
