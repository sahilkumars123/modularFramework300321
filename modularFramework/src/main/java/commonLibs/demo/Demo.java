package commonLibs.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import commonLibs.implementations.CommonDriver;
import commonLibs.implementations.DropDownControl;
import commonLibs.implementations.ElementControl;
import commonLibs.implementations.MouseActions;

public class Demo {

	public static void main(String[] args) throws Exception {
		
		
		
		CommonDriver cmndriver = new CommonDriver("chrome");
		cmndriver.navigateToFirstUrl("http://demo.guru99.com/v4");
		
		ElementControl elementControl;
		DropDownControl dropControl;
		MouseActions mouseControl;
		WebDriver driver;
		
		driver = cmndriver.getDriver();//V.Imp Step(To create a bridge)
		
		elementControl = new ElementControl();
		dropControl = new DropDownControl();
		mouseControl = new MouseActions(driver);
		WebElement userID = driver.findElement(By.name("uid"));
		mouseControl.rightClick(userID);
		Thread.sleep(5000);
		cmndriver.closeAllBrowsers();
		

	}

}
