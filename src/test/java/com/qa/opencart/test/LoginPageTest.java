package com.qa.opencart.test;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.opencaert.base.BaseTest;

public class LoginPageTest extends BaseTest {

	
	@Test(priority = 1)
	public void LoginPageTitleTest() {
		login= homepage.NavigatetoLoginPage();
		String Expectedtitle= login.getLoginpageTitle();
		String actualtitle="Account Login";
		log.warn("Login title Matching");
		if(actualtitle.equals(Expectedtitle)) {
			Assert.assertTrue(true);
			log.warn("Login titile Matched");
		}
		else {
			Assert.assertTrue(false);
			log.warn("Login titile not Matched");
		}
	}
	
	@Test(priority = 2)
	public void LoginPageUrlTest() {
		String Expectedurl= login.getLoginpageurl();
		String actualurl="https://naveenautomationlabs.com/opencart/index.php?route=account/login";
		log.warn("Login url  Matching");
		if(actualurl.equals(Expectedurl)) {
			Assert.assertTrue(true);
			log.warn("Login url  Matched");
		}
		else {
			Assert.assertTrue(true);
			log.warn("Login url not Matched");
		}
	}
	
	@Test(priority = 3)
	public void forgotlinkTest() {
		boolean Linkfound= login.ISforgotLinkButtonvisible();
		System.out.println("Is Forgot password link found :"+Linkfound);
		log.warn("Forgot link Checking");
		if(Linkfound==true) {
			Assert.assertTrue(true);
			log.warn("Forgot link matched");
		}
		else {
			Assert.assertTrue(false);
			log.warn("Forgot link not matched");
		}
	}
	
	@Test(priority = 4)
	public void logiActionTest() {
	  login.enterloginDetails(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	  log.info("login Action Performed Sucessfully");
	}
}
