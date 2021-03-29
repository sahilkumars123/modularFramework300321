package commonLibs.implementations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import commonLibs.contracts.IMouseActions;

public class MouseActions implements IMouseActions{
	
	private WebDriver driver;
	
	public MouseActions(WebDriver driver) {
		this.driver = driver;
	}
	
	private Actions getMouseActions()
	{
		Actions action = new Actions(driver);
		return action;
	}

	@Override
	public void dragAndDrop(WebElement source, WebElement target) throws Exception {
		getMouseActions().dragAndDrop(source, target).build().perform();
	}

	@Override
	public void moveToElement(WebElement element) throws Exception {
		getMouseActions().moveToElement(element).build().perform();
	}

	@Override
	public void rightClick(WebElement element) throws Exception {
		getMouseActions().contextClick(element).build().perform();	
	}

	@Override
	public void doubleClick(WebElement element) throws Exception {
		getMouseActions().doubleClick(element).build().perform();	
	}

	@Override
	public void moveToElementAndClick(WebElement element) throws Exception {
		getMouseActions().moveToElement(element).click().build().perform();	
	}

}
