package com.IdentifyCourses.stepDefinitions;

import com.IdentifyCourses.factory.helperClass;
import com.IdentifyCourses.pageObjects.pom_webDev;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebDevelopment_stepDefination {

	pom_webDev wd = new pom_webDev(helperClass.getDriver());

	@Given("a user is on the website homepage")
	public void userIsOnHomePage() {
		// Implement code for navigating to the website homepage
		System.out.println("Website Loaded");
	}

	@When("the user inputs {string} as the search query")
	public void userInputSearchQuery(String searchQuery) {
		// Implement code for entering the search query
		wd.enterSearchQuery();
	}

	@When("the user interacts with the search bar")
	public void userInteractsWithSearchBar() {
		// Implement code for interacting with the search bar
		wd.clickSearchButton();
	}

	@When("the user applies filters for beginners level courses")
	public void userAppliesBeginnersFilter() {
		// Implement code for applying the filter for beginners level courses
		wd.filterByLevelBeginner();

	}

	@When("the user applies filters for courses offered in English")
	public void userAppliesEnglishFilter() {
		// Implement code for applying the filter for English language courses
		wd.filterByEducatorEnglish();
	}

	@Then("two new tabs should open, each containing details for the top two courses")
	public void verifyTabsOpened() {
		// Implement code for verifying that two new tabs have opened
		wd.scrollToFilterByHeader();
		wd.clickCourses();
	}

	@Then("the details for the first course should be validated")
	public void the_details_for_the_first_course_should_be_validated() {
		wd.firstCourseHandling();
	}

	@Then("the details for the second course should be validated")
	public void the_details_for_the_second_course_should_be_validated() {
		wd.secondCourseHandling();
	}
}
