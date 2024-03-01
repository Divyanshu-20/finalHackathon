package com.IdentifyCourses.stepDefinitions;

import com.IdentifyCourses.factory.helperClass;
import com.IdentifyCourses.pageObjects.pom_extractLanguages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class extractLanguages_stepDefination {
	
	pom_extractLanguages exL;
	@Given("the user is on the coursera.org website")
	public void the_user_is_on_the_coursera_org_website() {
		exL = new pom_extractLanguages(helperClass.getDriver());
	}

	@When("the user enters Language Learning in the search bar and clicks")
	public void the_user_enters_language_learning_in_the_search_bar_and_clicks() {
		exL.enterSearchKeyword();
		exL.clickSearchButton();
	}

	@When("the user clicks on Language Learning in the subject")
	public void the_user_clicks_on_language_learning_in_the_subject() {
		exL.clickLanguageLearningSubject();
	}

	@When("the user clicks on Show more in Languages to extract all languages")
	public void the_user_clicks_on_show_more_in_languages_to_extract_all_languages() {
	exL.clickShowMoreLanguagesButton();
	}

	@Then("the user extracts all languages")
	public void the_user_extracts_all_languages() {
		exL.getLanguageCheckboxes();
	}

	@Then("the user closes the Languages tab")
	public void the_user_closes_the_languages_tab() {
		exL.closeLanguagesTab();
	}

	@Then("the user scrolls down to the level section")
	public void the_user_scrolls_down_to_the_level_section() {
		exL.ScrollToLevel();
	}

	@Then("the user extracts all levels")
	public void the_user_extracts_all_levels() {
		exL.getLevelOptions();
	}

}
