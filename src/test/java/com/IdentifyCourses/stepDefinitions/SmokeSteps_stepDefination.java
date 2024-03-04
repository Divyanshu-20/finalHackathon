package com.IdentifyCourses.stepDefinitions;

import org.testng.Assert;

import com.IdentifyCourses.factory.helperClass;
import com.IdentifyCourses.pageObjects.HomePage;
import com.IdentifyCourses.pageObjects.pom_webDev;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SmokeSteps_stepDefination extends helperClass {
	// com.IdentifyCourses.pageObjects.HomePage hp;
	pom_webDev wd;
	HomePage hp;

	@Given("user should launch the browser")
	public void user_should_launch_the_browser() {
		// Write code here that turns the phrase above into concrete actions\
		wd = new pom_webDev(helperClass.getDriver());
		String s = driver.toString();
		boolean flag = false;
		if (s != "")
			flag = true;

		Assert.assertEquals(flag, true);
	}

	@When("user navigates to url")
	public void user_navigates_to_url() {
		driver.get("https://www.coursera.org/");
	}

	@Then("Web page should load")
	public void web_page_should_load() {
		hp = new HomePage(driver);
		boolean flag = hp.pageLoaded();
		Assert.assertEquals(flag, true);

	}

	@Given("user should be on coursera homepage")
	public void user_should_be_on_coursera_homepage1() {
		driver.get("https://www.coursera.org/");
	}

	@Then("search box should displayed")
	public void search_box_should_displayed() {
		hp = new HomePage(driver);
		boolean flag = hp.searchBoxDisplay();
		Assert.assertEquals(flag, true);
	}

	@When("user search for {string} course")
	public void user_search_for_course(String string) {
		hp = new HomePage(driver);
		hp.submitSearch(string);
		hp.clickSearchIcon();
	}

	@When("user clicks on for individual link")
	public void user_clicks_on_for_individual_link() {

		hp = new HomePage(driver);
		hp.clickNav1();
	}

	@Then("user should see courseera homepage")
	public void user_should_see_courseera_homepage() {

		hp.clickNav1();
		String s = driver.getTitle();
		Assert.assertEquals(s, "Coursera | Degrees, Certificates, & Free Online Courses");
	}

	@When("user clicks on for bussiness link")
	public void user_clicks_on_for_buiseness_link() {

		hp = new HomePage(driver);
		hp.clickNav2();
	}

	@Then("user should see bussiness page.")
	public void user_should_see_buiseness_page() {

		String s = driver.getTitle();
		Assert.assertEquals(s, "Employee Training and Development Programs | Coursera for Business");
	}

	@When("user clicks on for universities link")
	public void user_clicks_on_for_universities_link() {

		hp = new HomePage(driver);
		hp.clickNav3();
	}

	@Then("user should see for campus page")
	public void user_should_see_for_campus_page() {

		String s = driver.getTitle();
		Assert.assertEquals(s, "Online Learning Platform for Universities | Coursera");

	}
}
