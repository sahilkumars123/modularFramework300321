package commonLibs.implementations;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IJavaScript;

public class JavaScriptController implements IJavaScript{

	private WebDriver driver;
	
	public void JavaScriptController(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private JavascriptExecutor getJSEngine()
	{
		JavascriptExecutor jsEngine =  (JavascriptExecutor) driver; 
		return jsEngine;
	}
	
	
	@Override
	public void executeJavaScript(String scriptToExecute) throws Exception {
		 
		getJSEngine().executeScript(scriptToExecute);
		
	}

	@Override
	public void scrollDown(int x, int y) throws Exception {
		
		String jsCommand = String.format("window.scrollBy(%d,%d)",x,y);
		getJSEngine().executeScript(jsCommand);
		
	}

	@Override
	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception {
		
		return getJSEngine().executeScript(scriptToExecute).toString();
	}

}
