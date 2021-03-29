package commonLibs.implementations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import commonLibs.contracts.IDriver;

public class CommonDriver implements IDriver {
	
	//Recommandation if we need to add any function, first add it in Interface and then implement in this class.
	
	//We want to follow Encapsulation
	private WebDriver driver; 
	private int pageLoadTimeOut;
	private int elementDetectionTimeout;
	
	
	public WebDriver getDriver() {
		
		return driver;
	}

	public void setPageLoadTimeOut(int pageLoadTimeOut) {
		this.pageLoadTimeOut = pageLoadTimeOut;
	}

	public void setElementDetectionTimeout(int elementDetectionTimeout) {
		this.elementDetectionTimeout = elementDetectionTimeout;
	}

	public CommonDriver(String WebBrowserType) throws Exception {
		// TODO Auto-generated constructor stub
		pageLoadTimeOut = 30;
		elementDetectionTimeout = 10;
		
		WebBrowserType = WebBrowserType.trim();
		
		if(WebBrowserType.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\jar files\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
		else if(WebBrowserType.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\jar files\\geckodriver-v0.29.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		}
		else
		{
			throw new Exception("Invalid WebBrowser...."+ WebBrowserType);
		}
	}

	@Override
	public void navigateToFirstUrl(String url) throws Exception {
		
		url = url.trim();
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementDetectionTimeout, TimeUnit.SECONDS);	
		driver.get(url);
	}

	@Override
	public String getTitle() throws Exception {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}

	@Override
	public String getCurrentUrl() throws Exception {
		// TODO Auto-generated method stub
		return driver.getCurrentUrl();
	}

	@Override
	public String getPageSource() throws Exception {
		// TODO Auto-generated method stub
		return driver.getPageSource();
	}

	@Override
	public void navigateToUrl(String url) throws Exception {
	
		url = url.trim();
		driver.navigate().to(url);
	}

	@Override
	public void navigateForward() throws Exception {
		driver.navigate().forward();
		
	}

	@Override
	public void navigateBackward() throws Exception {
		driver.navigate().back();
		
	}

	@Override
	public void refresh() throws Exception {
		driver.navigate().refresh();
		
	}

	@Override
	public void closeBrowser() throws Exception {
		if(driver != null)
		{
			driver.close();
		}
	}

	@Override
	public void closeAllBrowsers() throws Exception {
		if(driver != null)
		{
			driver.quit();
		}	
	}

}
