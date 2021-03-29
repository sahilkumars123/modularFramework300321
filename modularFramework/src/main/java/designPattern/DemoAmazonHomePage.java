package designPattern;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import commonLibs.implementations.CommonDriver;
import commonLibs.implementations.DropDownControl;
import commonLibs.implementations.ElementControl;

public class DemoAmazonHomePage {
	
	
	ElementControl elemControl;
	DropDownControl dropControl;
	AmazonHomePage homePage;
	WebDriver driver;
	
	CommonDriver commonDriver;
	String url = "https://www.amazon.in//";
	
	@BeforeClass
	public void invokeBrowser() throws Exception
	{
		commonDriver = new CommonDriver("chrome");
		commonDriver.navigateToFirstUrl(url);	
		elemControl = new ElementControl();
		dropControl = new DropDownControl();
		driver = commonDriver.getDriver();	
		homePage = new AmazonHomePage(driver);	
	}
	
	@Test
	public void searchProduct() throws Exception
	{
		
		elemControl.setText(homePage.textBox, "titan");
		dropControl.selectViaVisibleText(homePage.dropDown, "Watches");
		elemControl.clickElement(homePage.searchButton);	
	}
	
	
	@AfterClass
	public void closeBrowser() throws Exception
	{
		commonDriver.closeBrowser();
	}

}
