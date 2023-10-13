package com.QA.Opencart.factory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

import com.microsoft.playwright.*;

public class PlaywrightFactory {

	Playwright playwright;
	Browser browser;
	BrowserContext context;
	static Page page;
	Properties pro;

	/*
	private static ThreadLocal<Browser> threadbrowser=new ThreadLocal<>();
	private static ThreadLocal<BrowserContext> threadcontext=new ThreadLocal<>();
	private static ThreadLocal<Page> threadpage=new ThreadLocal<>();
	private static ThreadLocal<Playwright> threadplawright=new ThreadLocal<>();
	
	public static Playwright getPlaywright() {
		return threadplawright.get();
	}

	public static Browser getBrowser() {
		return threadbrowser.get();
	}

	public static BrowserContext getBrowserContext() {
		return threadcontext.get();
	}

	public static Page getPage() {
		return threadpage.get();
	}
	*/
	public Page initializeBrowser(Properties pro) {
		pro= initialize_properties();
		String browsername=pro.getProperty("browser").trim();
		
		System.out.println("Browser name : "+browsername);

		playwright=Playwright.create();
		//threadplawright.set(Playwright.create());

		if(browsername.toLowerCase().equals("chromium")) {
			browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		  //  threadbrowser.set(playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)));
		}

		else if(browsername.toLowerCase().equals("firefox")) {
			browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		}

		else if(browsername.toLowerCase().equals("webkit")) {
			browser=playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		}
		else {
              System.out.println("Please Enter Correct Browser Name......!");
		}
		
		context=browser.newContext();
		page=context.newPage();
		page.navigate(pro.getProperty("url").trim());
		return page;
	}
	
	public Properties initialize_properties() {
		try {
			FileInputStream file=new FileInputStream("src//test//resources//Config//config.properties");
		    pro=new Properties();
		    pro.load(file);
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	}
	
	public static String takeScreenshot() {
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		//getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		
		byte[] buffer =page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
		String base64Path = Base64.getEncoder().encodeToString(buffer);
		
		return base64Path;
	}
}
