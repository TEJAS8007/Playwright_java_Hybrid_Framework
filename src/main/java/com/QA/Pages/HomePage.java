package com.QA.Pages;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {

	private Page page;
	
	private String search="input[name='search']";
	private String searchicon="div#search button";
	private String searchpageheader="div#content h1";
	private String loginLink="a:text('Login')";
	private String Myaccountlink="a[title='My Account']";
	private String Mackbook ="//*[@id=\"content\"]/div[2]/div[1]/div/div[1]/a";
	private String MackbookLink="//*[@id=\"content\"]/div[2]/div[1]/div/div[1]/a";
	private String RegisterLink="a:text('Register')";
	private String HomePageProductsLink="//*[@id=\"content\"]/h3";
	private String HomePageFooterHHyperLink="//div[@class='container'] /parent ::footer";
	
	public HomePage(Page page) {
		this.page=page;
	}
	
	public String getHomePageTitle() {
		String title= page.title();
		System.out.println("Page title :"+title);
		return title;
	}
	
	public String getHomePageUrl() {
		String url= page.url();
		System.out.println("Page url is :"+url);
		return url;
	}
	
	public String SearchProduct(String productName) {
		page.fill(search, productName);
		page.click(searchicon);
		String content= page.textContent(searchpageheader);
		System.out.println("header content : "+content);
		return content;
	}
	
	public LoginPage NavigatetoLoginPage() {
		page.click(Myaccountlink);
		page.click(loginLink);
		return new LoginPage(page);
	}
	
	public RegisterPage NavigatetoRegisterPage() {
		page.click(Myaccountlink);
		page.click(RegisterLink);
		return new RegisterPage(page);
	}
	
	public boolean findMackbook() {
		boolean found;
		
		if(page.locator(Mackbook).isVisible()) {
			found=true;
		}
		else {
			found=false;
		}
		return found;
	}
	
	public AddToCartPage NavigateToAddToCartPage() {
		page.locator(MackbookLink).click();
		return new AddToCartPage(page);
	}
	
	public String ValidateHomePageVisibleProductsText() {
		
		String text= page.locator(HomePageProductsLink).textContent();
		System.out.println(text);
		return text;
	}
	
	public List<String> ValidateFooterHyperLink() {
		Locator footer= page.locator(HomePageFooterHHyperLink);
		List<String> linklist=footer.locator("a").allInnerTexts();
		return linklist;
	}
}
