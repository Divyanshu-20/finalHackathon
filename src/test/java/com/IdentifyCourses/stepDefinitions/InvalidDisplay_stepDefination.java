package com.IdentifyCourses.stepDefinitions;

import org.openqa.selenium.JavascriptExecutor;

import com.IdentifyCourses.factory.helperClass;
import com.IdentifyCourses.pageObjects.pom_InvalidErrorCapture;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InvalidDisplay_stepDefination {

	pom_InvalidErrorCapture erc = new pom_InvalidErrorCapture(helperClass.getDriver());

	@Given("the user is on the Coursera homepage")
	public void the_user_is_on_the_coursera_homepage() {
		System.out.println("Scenario 3 Started");
	}

	@When("the user navigates to For Enterprise then to Solutions then to Coursera for Campus and finally to Contact Us")
	public void the_user_navigates_to_for_enterprise_then_to_solutions_then_to_coursera_for_campus_and_finally_to_contact_us() {

		erc.clickBusinessesButton();
		erc.clickSolutionsButton();
		erc.clickCourseraForCampusButton();
	}

	@Then("the user should be on the Contact Us page")
	public void the_user_should_be_on_the_contact_us_page() {
		erc.clickContactUsButton();
	}

	@When("the user fills the Contact Us form with an invalid email address")
	public void the_user_fills_the_contact_us_form_with_an_invalid_email_address() {
		erc.fillFirstName();
		erc.fillLastName();
		erc.fillEmail();
		erc.fillPhone();
		erc.selectInstitutionType();
		erc.fillCompany();
		erc.selectJobRole();
		erc.selectDepartment();
		erc.selectNeeds();
		erc.selectCountry();
		erc.selectState();
	}

	@When("clicks the Submit button")
	public void clicks_the_submit_button() {
		erc.clickSubmitButton();
	}

	@Then("the user should see an error message related to the invalid email input")
	public void the_user_should_see_an_error_message_related_to_the_invalid_email_input() {
		erc.getValidMsgEmailText();
	}

}
