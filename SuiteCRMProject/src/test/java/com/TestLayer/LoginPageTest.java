package com.TestLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageLayer.LoginPage;
import com.TestBase.TestBase;

public class LoginPageTest extends TestBase
	{
	     @Test
	     public void VerifyLoginPage()
	     {
	    	 LoginPage lp = new LoginPage(driver);
	    	 lp.enterUsername(username);
	    	 logger.info("username entered");
	    	 lp.enterPassword(password);
	    	 logger.info("password entered");
	    	 lp.clickOnLoginBtn();
	    	 logger.info("login button clicked");
	    	 
	    	 String username = lp.getProfileName();
	    	 Assert.assertEquals("Will Westin", username);
	    	 logger.info("user successfully login  & username verified");
	    	 
	     }
	

}
