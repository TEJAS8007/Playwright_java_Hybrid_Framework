package com.QA.Pages;

import java.util.List;

import com.github.javafaker.Faker;
import com.microsoft.playwright.Page;

public class RegisterPage {

	Page page;

	private String FirstName="input#input-firstname";
	private String LastName="input#input-lastname";
	private String Email="input#input-email";
	private String telephone="input#input-telephone";
	private String Password="input#input-password";
	private String CONPassword="input#input-confirm";
	private String CHECKBOX="input[name='agree']";
	private String RegButton="//input[@type='submit']";
    private String AccountVerificationMessage="//*[@id=\"content\"]/h1";
    private String AccountLinksList="div[class='list-group'] a";
    
	
	public RegisterPage(Page page) {
		this.page=page;
	}
	
	public void EnterRegistrationDetails() {

		
		Faker fak=new Faker();
		String fn=fak.name().firstName();
		String ln=fak.name().lastName();
		String em=fak.internet().safeEmailAddress();
		String teleNum=fak.phoneNumber().cellPhone().toString();
		String pass=fak.internet().password();

		
		page.locator(FirstName).fill(fn);;
		page.locator(LastName).fill(ln);;
		page.locator(Email).fill(em);;
		page.locator(telephone).fill(teleNum);;
		page.locator(Password).fill(pass);;
		page.locator(CONPassword).fill(pass);;
		page.locator(CHECKBOX).click();;
		page.locator(RegButton).click();
        page.waitForLoadState();
   
	}

	public String getVerfiredAccontMessage() {
		String message=page.locator(AccountVerificationMessage).textContent();
		System.out.println(message);
		return message;
	}
	
	public List<String> getAllLinks() {
		List<String> linksList= page.locator(AccountLinksList).allInnerTexts();
		return linksList;
	}
}
