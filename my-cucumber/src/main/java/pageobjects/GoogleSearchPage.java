package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Initialization.Initialization;

public class GoogleSearchPage extends Initialization {
	
	public GoogleSearchPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(css="input[name='q']")
	WebElement searchField;
	
	@FindBy(css="input[name='btnK']")
	WebElement btnk;
	
	public GoogleResultPage seach(String text) {
		searchField.sendKeys(text);
		searchField.sendKeys(Keys.ENTER);
		return new GoogleResultPage();
		
	}

}
