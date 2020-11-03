package com.selenium.logintc;

import org.testng.annotations.Test;

import com.selenium.pageobject.LoginPageObj;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class LoginDataProvider {
  
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] {"admin", "admin" },
      new Object[] { "sspeed", "Demo1234" },
      new Object[] { "tuser", "tuser" },

    };
  }
  
  
	LoginPageObj lp = new LoginPageObj();
  
  @BeforeTest
  public void beforeTest() throws Exception {
	  
	  lp.openBrowser("chrome");
	  lp.exportPageFactory();
  }


  @Test(dataProvider = "dp")
  public void f(String username, String password) throws Exception {
	  
	  lp.openApplication();
	  lp.txtUsername.sendKeys(username);
	  lp.txtPassword.sendKeys(password);
	  lp.btnSubmit.click();
	  lp.delay(2);
	  lp.linkSignOff.click();
  }

  @AfterTest
  public void afterTest() {
	  
	  lp.closeBrowser();
  }

}
