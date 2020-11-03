package com.selenium.pageobject;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageObj {

	WebDriver w;
	String baseUrl = "http://altoromutual.com:8080/login.jsp";

	@FindBy(id = "uid")
	public WebElement txtUsername;

	@FindBy(id = "passw")
	public WebElement txtPassword;

	@FindBy(name = "btnSubmit")
	public WebElement btnSubmit;

	@FindBy(linkText = "Sign Off")
	public WebElement linkSignOff;
	
	@FindBy(xpath="/html/body/table[2]/tbody/tr/td[2]/div/h1")
	public WebElement userProfile;

	public void openBrowser(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			w = new ChromeDriver();
			w.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			w = new FirefoxDriver();
			w.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			w = new EdgeDriver();
			w.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}

	}

	public void openApplication() {

		w.get(baseUrl);
	}
	
	public void openApp(String url) {

		w.get(url);
	}

	
	public void closeBrowser() {

		w.quit();
	}
	
	public void delay(int sec)throws Exception {
		sec=sec*1000;
		Thread.sleep(sec);
	}
	
	public String verifyTitle() {		
		return w.getTitle();
	}
	
	public String verifyElementText(WebElement we) {
		return we.getText();		
	}
	
	public String readPropertiesFileData(String key)throws Exception {
		
		String projectPath=System.getProperty("user.dir");		
		FileInputStream fin=new FileInputStream(projectPath+"\\config.properties");
		
		Properties prop=new Properties();
		prop.load(fin);
		
		String value=prop.getProperty(key);
		return value;
		
	}
	
     public void exportPageFactory () {
    	 PageFactory.initElements(w, this);
     }

}
