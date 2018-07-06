package com.practice.qa;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDef {
	Homepage hp = new Homepage();

	@Given("^user is on vehicle Homepage$")
	public void user_is_on_Homepage() {
		hp.verifyHomepageTitle();
	}

	@When("^user clicks on Get updates Link$")
	public void user_clicks_on_Get_updates_Link() throws Throwable {
		hp.OpenGetUpdateForm();
	}

	@Then("^user verifies Golf form$")
	public void user_verifies_Golf_form() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		hp.VerifyGetUpdateForm();
	}

	@And("^user click on submit button$")
	public void user_click_on_submit_button() throws Throwable {
		hp.ClickOnSubmitButton();
		
	}

	@Then("^user enters details firstname as \"([^\"]*)\" lastname as \"([^\"]*)\" and zip as \"([^\"]*)\"$")
	public void user_enters_details_firstname_as_lastname_as_and_zip_as(String fName, String lName, String zip)
			throws Throwable {
		hp.fillBasicDetails(fName, lName, zip);
	}

	@Then("^user enter email as \"([^\"]*)\"$")
	public void user_enter_email_as(String email) throws Throwable {
		hp.fillEmailOnGetUpdatesForm(email);
	}

	@And("^user login to handraiser db on new tab$")
	public void accessHandRaiser() {
		hp.gotoHandRaiserAndLogin();
	}

	@Then("^user searches for the Lead$")
	public void user_searches_for_the_Lead() {
		hp.searchSubmittedLead();
	}

	@Then("^user verifies \"([^\"]*)\", \"([^\"]*)\", szBrchr as \"([^\"]*)\", szQA as \"([^\"]*)\",szLanguage as \"([^\"]*)\"$")
	public void user_verifies_szBrchr_as_szQA_as_szLanguage_as(String lName, String zip, String szBrchr1, String szQA,
			String szLanguage) throws Throwable {
		hp.verifyFieldsOnTable(lName, zip, szBrchr1, szQA, szLanguage);
	}

	@Then("^user verifies  \"([^\"]*)\"$")
	public void user_verifies(String email) throws Throwable {

		hp.verifyEmailOnTable(email);
	}

	@Then("^user verifies \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", szBrchr as \"([^\"]*)\", szQA as \"([^\"]*)\",szLanguage as \"([^\"]*)\"$")
	public void user_verifies_szBrchr_as_szQA_as_szLanguage_as(String lName, String zip, String email, String szBrchr1,
			String szQA, String szLanguage) {
		// Write code here that turns the phrase above into concrete actions
		hp.verifyFieldsOnTable(lName, zip, szBrchr1, szQA, szLanguage);
	}

	@Then("^user Checks postal checkbox$")
	public void user_Checks_postal_checkbox() throws Throwable {
		hp.selectPostalCheckBox();
	}

	@Then("^user Unchecks email checkbox$")
	public void user_Unchecks_postal_checkbox() throws Throwable {
		hp.deSelectEmailCheckBox();
	}
	
	@Then("^user enters details street as \"([^\"]*)\", city as \"([^\"]*)\"$")
	public void user_enters_details_street_as_city_as(String street, String city) throws Throwable {
		hp.fillAddressOnGetUpdatesForm(street, city);

	}

	@Then("^user verifies \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_verifies_and(String street, String city) throws Throwable {
		hp.verifyAddressOnTable(street, city);

	}
	@Then("^user close the tab$")
	public void closeTab(){
		
		hp.closeTab();
	}
}
