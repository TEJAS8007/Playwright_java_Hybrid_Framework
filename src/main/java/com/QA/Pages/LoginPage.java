package com.QA.Pages;

import com.microsoft.playwright.Page;

public class LoginPage {
	
	Page page;

	private String emailBox="input#input-email";
	private String passwordBox="//input[@id='input-password']";
	private String loginbutton="input[value='Login']";
	private String loginLink="a:text('Login')";
	private String Myaccountlink="a[title='My Account']";
	private String forgotpassword="a:text('Forgotten Password')";
	private String LogoutLink="//*[@id=\"column-right\"]/div/a[13]";
	
	public LoginPage(Page page) {
		this.page=page;
	}
	
	public String getLoginpageTitle() {
		page.click(Myaccountlink);
		page.click(loginLink);
		String title= page.title();
		System.out.println("Login  page title :"+title);
		return title;
	}
	
	public String getLoginpageurl() {
		String url= page.url();
		System.out.println("Login  page url :"+url);
		return url;
	}
	
	public boolean ISforgotLinkButtonvisible() {
		boolean found;
		if(page.isVisible(forgotpassword)) {
			found=true;
		}
		else {
			found=false;
		}
		return found;
	}
	
	public void enterloginDetails(String username,String password) {
		System.out.println("Login Credentials : "+username +" : "+password);
		page.fill(emailBox, username);
		page.fill(passwordBox, password);
		page.click(loginbutton);
		page.waitForLoadState();
		page.click(LogoutLink);
		
	}
}
