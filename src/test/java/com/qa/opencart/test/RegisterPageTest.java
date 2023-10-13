package com.qa.opencart.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencaert.base.BaseTest;

public class RegisterPageTest extends BaseTest{

	@Test(priority = 1)
	public void EnterRegistrationTest() {
		register= homepage.NavigatetoRegisterPage();
		register.EnterRegistrationDetails();
		log.info("Registration Details Entered");
	}
	
	@Test(priority = 2)
	public void AccountCreationVerificationTest() {
		String expectedmeassage= register.getVerfiredAccontMessage();
		String ActualMessage="Your Account Has Been Created!";
		log.info("Account Message Verification");
		if(expectedmeassage.equals(ActualMessage)) {
			Assert.assertTrue(true);
			log.warn("Account Message Matched");
		}
		else {
			Assert.assertTrue(false);
			log.warn("Account Message not Matched");
		}
	}
	
	@Test(priority = 3)
	public void VerifyLinksTest() {
		List<String>linkslist= register.getAllLinks();
		
		for(String link :linkslist)
		{
			System.out.println(link);
		}
		log.warn("Links validated Succesfully");
	}
}
