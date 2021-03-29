package commonLibs.implementations;

import org.openqa.selenium.WebElement;

import commonLibs.contracts.ICommonElements;

public class ElementControl implements ICommonElements {

	@Override
	public String getText(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		return element.getText();
	}

	@Override
	public void clickElement(WebElement element) throws Exception {
		// TODO Auto-generated method stub
		element.click();
	}

	@Override
	public String getAttribute(WebElement element, String attribute) throws Exception {
		// TODO Auto-generated method stub
		return element.getAttribute(attribute);
	}

	@Override
	public String getCssValue(WebElement element, String csspropertyName) throws Exception {
	
		return element.getAttribute(csspropertyName);
	}

	@Override
	public boolean isElementEnabled(WebElement element) throws Exception {
	
		return element.isEnabled();
	
	}

	@Override
	public boolean isElementVisible(WebElement element) throws Exception {
	
		return element.isDisplayed();
		
	}

	@Override
	public boolean isElementSelected(WebElement element) throws Exception {
	
		return element.isSelected();
	
	}

	@Override
	public void setText(WebElement element, String textToWrite) throws Exception {
		
		element.sendKeys(textToWrite);
		
	}

	@Override
	public void clearText(WebElement element) throws Exception {
		
		element.clear();
		
	}

	@Override
	public void changeCheckboxStatus(WebElement element, boolean status) throws Exception {
		
		/*
		 * if( status == true && element.isSelected() == false) { element.click(); }
		 * else if(status == false && element.isSelected() == true) { element.click();
		 *conversion of this logic is below
		 *  }
		 */
		
		if(status && !element.isSelected() || !status && element.isSelected())
		{
			element.click();
		}
		
	}

}
