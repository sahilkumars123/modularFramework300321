package designPattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHomePage {
	
	public WebElement textBox;
	public WebElement searchButton;
	public WebElement dropDown;
	
	public AmazonHomePage(WebDriver driver)
	{
		textBox = driver.findElement(By.id("twotabsearchtextbox"));
		dropDown = driver.findElement(By.name("url"));
		searchButton = driver.findElement(By.id("nav-search-submit-button"));
	}

}
