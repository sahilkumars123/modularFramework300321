package designPattern;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import commonLibs.implementations.CommonDriver;
import commonLibs.implementations.DropDownControl;
import commonLibs.implementations.ElementControl;

public class DemoAmazonHomePage2 {
	

	AmazonHomePage2 homePage2;
	WebDriver driver;
	
	CommonDriver commonDriver;
	String url = "https://www.amazon.in//";
	
	@BeforeClass
	public void invokeBrowser() throws Exception
	{
		commonDriver = new CommonDriver("chrome");
		commonDriver.navigateToFirstUrl(url);	
		driver = commonDriver.getDriver();	
		homePage2 = new AmazonHomePage2(driver);	
	}
	
	@Test
	public void searchProduct() throws Exception
	{	
		homePage2.seachProduct("Apple Watches","Watches");
	}
	
	
	@AfterClass
	public void closeBrowser() throws Exception
	{
		commonDriver.closeBrowser();
	}

}
