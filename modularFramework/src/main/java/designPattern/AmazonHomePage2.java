package designPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonLibs.implementations.DropDownControl;
import commonLibs.implementations.ElementControl;

public class AmazonHomePage2 {
	
	private WebElement textBox;
	private WebElement searchButton;
	private WebElement dropDown;
	
	
	ElementControl elemControl;
	DropDownControl dropControl;
	
	public AmazonHomePage2(WebDriver driver)
	{
		textBox = driver.findElement(By.id("twotabsearchtextbox"));
		dropDown = driver.findElement(By.name("url"));
		searchButton = driver.findElement(By.id("nav-search-submit-button"));
		elemControl = new ElementControl();
		dropControl = new DropDownControl();
	}
	
	public void seachProduct(String product, String category) throws Exception
	{
		elemControl.setText(textBox,product);
		dropControl.selectViaVisibleText(dropDown, category);
		Thread.sleep(3000);
		elemControl.clickElement(dropDown);
	}

}
