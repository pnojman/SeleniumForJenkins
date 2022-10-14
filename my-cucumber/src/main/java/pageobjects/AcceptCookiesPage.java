package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Initialization.Initialization;

public class AcceptCookiesPage extends Initialization {
	
	public AcceptCookiesPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(css="button[id='L2AGLb']")
	WebElement acceptBtn;
	

	public void acceptCookies() {
		acceptBtn.click();

	}

}
