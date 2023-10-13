package com.qa.opencaert.base;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.QA.Opencart.factory.PlaywrightFactory;
import com.QA.Pages.AddToCartPage;

import com.QA.Pages.HomePage;
import com.QA.Pages.LoginPage;
import com.QA.Pages.RegisterPage;
import com.microsoft.playwright.Page;

public class BaseTest {

	PlaywrightFactory pfactory;
	protected Page page;
	protected HomePage homepage;
    protected Properties prop;
    protected LoginPage login;
    protected AddToCartPage add;
    protected RegisterPage register;
    protected Logger log;
    
	
	@BeforeTest
	public void setup() {
		pfactory=new PlaywrightFactory();
		page=pfactory.initializeBrowser(prop);
		homepage=new HomePage(page);
		prop= pfactory.initialize_properties();
		log=LogManager.getLogger(this.getClass());
	}

	@AfterTest
	public void teardown() {
		page.context().browser().close();
	}
	
}
