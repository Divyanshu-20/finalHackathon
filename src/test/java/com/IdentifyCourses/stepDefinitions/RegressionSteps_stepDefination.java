package com.IdentifyCourses.stepDefinitions;

import com.IdentifyCourses.factory.helperClass;
import com.IdentifyCourses.pageObjects.pom_extractLanguages;
import com.IdentifyCourses.pageObjects.pom_webDev;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegressionSteps_stepDefination extends helperClass {

	pom_webDev wd;

	@Given("user should be on homepage")
	public void user_should_be_on_homepage1() {
		// Write code here that turns the phrase above into concrete actions
		wd = new pom_webDev(helperClass.getDriver());
	}

	@When("user search for {string} courses")
	public void user_search_for_courses(String string) {
		wd.enterSearchQuery();
		wd.clickSearchButton();
	}

	@When("user select beginners level")
	public void user_select_beginners_level() {
		wd.filterByLevelBeginner();
	}

	@When("user select English language")
	public void user_select_english_language() {
		wd.filterByEducatorEnglish();
	}

	@Given("user should see all courses")
	public void user_should_see_all_courses() {
		wd = new pom_webDev(helperClass.getDriver());
		wd.enterSearchQuery();
		wd.clickSearchButton();
		wd.filterByLevelBeginner();
		wd.filterByEducatorEnglish();
	}

	@When("user click on both course")
	public void user_click_on_both_course() {
		wd.clickCourses();
	}

	@Then("user get the first course details")
	public void user_get_the_first_course_details() {
		wd.firstCourseHandling();
	}

	@Then("user get the second course details")
	public void user_get_the_second_course_details() {
		wd.secondCourseHandling();
	}

}
