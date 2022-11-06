package com.PageLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver driver;
    public LoginPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
    
    // obj 
    
    @FindBy(name="username")
    private WebElement username_txt;
    
    @FindBy(name="password")
    private WebElement password_txt;
    
    @FindBy(id="login-button")
    private WebElement login_btn;
    
    @FindBy (xpath = "//span[contains(text(),'Will Westin')]")
    private WebElement profile;
    
    
    // Action methods
    
    public void enterUsername(String user)
    {
    	username_txt.sendKeys(user);
    }
    
    public void enterPassword(String pass)
    {
    	password_txt.sendKeys(pass);
    }
    
    public void clickOnLoginBtn()
    {
    	login_btn.click();
    }
    
    public String getProfileName()
    {
      String txt = profile.getText();
      return txt;
    	
    }
    
    
    
    
    
    
    
}
