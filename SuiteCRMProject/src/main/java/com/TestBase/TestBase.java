package com.TestBase;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Utility.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase
{
	ReadConfig readConfig = new ReadConfig();

	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();

	public String username = readConfig.getusername();
	public String password = readConfig.getPassword();


	public static WebDriver driver;
	public static Logger logger;

	@BeforeClass
	public void setup()
	{

		//launch browser
		switch(browser.toLowerCase())
		{
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}

		//implicit wait of 10 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//for logging
		logger = LogManager.getLogger("SuiteCRMProject");

		//open url
		driver.get(url);
		logger.info("url opened");

	}



	@AfterClass
	public void tearDown()
	{
		//driver.close();
		//driver.quit();
	}


}
