package com.IdentifyCourses.stepDefinitions;

import com.IdentifyCourses.factory.helperClass;
import com.IdentifyCourses.pageObjects.pom_PrintLanguages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PrintCourses_stepDefinations {
	pom_PrintLanguages pl = new pom_PrintLanguages(helperClass.getDriver());

	@Given("the user is on the homepage")
	public void the_user_is_on_the_homepage() {
		System.out.println("Feature is running");
	}

	@When("the user explores language learning")
	public void the_user_explores_language_learning() {
		pl.clickExploreButton();
		pl.clickLanguageLearningButton();
	}

	@When("selects popular courses")
	public void selects_popular_courses() {
		pl.clickPopularLanguageButton();
	}

	@Then("validate courses and levels")
	public void validate_courses_and_levels() {
		pl.getCourseElementsRequirements();
	}
}
