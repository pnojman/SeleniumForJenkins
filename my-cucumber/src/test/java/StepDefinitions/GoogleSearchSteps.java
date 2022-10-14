package StepDefinitions;

import Initialization.Initialization;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.AcceptCookiesPage;
import pageobjects.GoogleResultPage;
import pageobjects.GoogleSearchPage;

public class GoogleSearchSteps extends Initialization {
	
	GoogleSearchPage googleSearchPage;
	GoogleResultPage googleResultPage;
	AcceptCookiesPage acceptCookiesPage;
	
	@Before()
      public void init() {
		
         setWebDriver(driver);    
    }

	@Given("I am on the Google search page")
	public void i_am_on_the_Google_search_page() {
		
		getDriver().get("http://google.pl");
		acceptCookiesPage = new AcceptCookiesPage();
        acceptCookiesPage.acceptCookies();
		
	}

	@When("^I search for (.*)$")
	public void i_search_for_searchKey(String searchKey) {
		
		googleSearchPage = new GoogleSearchPage();
		googleResultPage = googleSearchPage.seach(searchKey);
	  
	}

	@Then("^the page title should start with (.*)$")
	public void the_page_title_should_start_with_keyvalue(String keyValue) {
		googleResultPage.checkTitle(keyValue);
	}

	@After
	public void tearDown() {
		getDriver().quit();
	}

}
