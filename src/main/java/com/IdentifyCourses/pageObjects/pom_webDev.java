package com.IdentifyCourses.pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class pom_webDev extends BasePage {

	public pom_webDev(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@placeholder='What do you want to learn?']")
	public WebElement inputBar;

	@FindBy(xpath = "//button[@class='nostyle search-button']//div[@class='magnifier-wrapper']")
	public WebElement searchButton;

	@FindBy(xpath = "//label[contains(text(),'Level')]")
	public WebElement levelScroll;

	@FindBy(xpath = "//span[contains(text(),'Beginner')]")
	public WebElement beginnerFilter;

	@FindBy(xpath = "//label[contains(text(),'Educator')]")
	public WebElement educatorScroll;

	@FindBy(xpath = "//span[contains(text(),'English')]")
	public WebElement englishFilter;

	@FindBy(xpath = "//h3[normalize-space()='Filter by']")
	public WebElement Scrollup;

	@FindBy(xpath = "(//div[@class='css-kplcru'])[2]")
	public WebElement secondCourse;

	@FindBy(xpath = "(//div[@class='css-kplcru'])[1]")
	public WebElement firstCourse;

	@FindBy(xpath = "//*[@data-e2e=\"hero-module\"]//h1")
	public WebElement firstCourseHeading;

	@FindBy(xpath = "//div[contains(text(),'hours')][1]")
	public WebElement firstCourseLearnTime;

	@FindBy(xpath = "(//div[contains(text(),'4')])[1]")
	public WebElement firstCourseRating;

	@FindBy(xpath = "//*[@data-e2e='hero-module']//h1")
	public WebElement secondCourseHeading;

	@FindBy(xpath = "(//div[contains(text(),'hours')])[2]")
	public WebElement secondCourseLearnTime;

	@FindBy(xpath = "(//div[contains(text(),'4')])[2]")
	public WebElement secondCourseRating;

	String fileName = System.getProperty("user.dir") + "/src/test/resources/courseData.xlsx"; // storing the path of
																								// excel
																								// file in "fileName"
	Locators loc = new Locators(com.IdentifyCourses.factory.helperClass.getDriver());

	// creating an instance for locators

	JavascriptExecutor js = (JavascriptExecutor) driver;

	// Additional elements can be added based on your script

	// Methods to interact with elements

	public void enterSearchQuery() {
		inputBar.sendKeys("Web Development Courses");
	}

	public void clickSearchButton() {
		searchButton.click();
	}

	public void filterByLevelBeginner() {

		js.executeScript("arguments[0].scrollIntoView();", levelScroll);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		js.executeScript("arguments[0].click();", beginnerFilter);
	}

	public void filterByEducatorEnglish() {
		js.executeScript("arguments[0].scrollIntoView();", educatorScroll);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		js.executeScript("arguments[0].click();", englishFilter);
	}

	public void scrollToFilterByHeader() {
		// You can implement scrolling logic here
		js.executeScript("arguments[0].scrollIntoView();", Scrollup);
	}

	public void clickCourses() {
		secondCourse.click();
		firstCourse.click();
	}

	public void firstCourseHandling() {
		Set<String> allHandles = driver.getWindowHandles();
		List<String> allHandlesList = new ArrayList<>(allHandles);
		System.out.println(allHandlesList);

		String parentWindowId = allHandlesList.get(0);
		String firstCourseWindowId = allHandlesList.get(1);
		String secondCourseWindowId = allHandlesList.get(2);

		driver.switchTo().window(firstCourseWindowId);

		try {
			String courseOneHeading = firstCourseHeading.getText();
			System.out.println("Heading of the Course: " + courseOneHeading);

			String courseOneLearnTime = firstCourseLearnTime.getText();
			System.out.println("Learning Time For the Course: " + courseOneLearnTime);

			String courseOneRating = firstCourseRating.getText();
			System.out.println("Rating for the Course: " + courseOneRating);

			System.out.println(
					"----------------------------------------------------------------------------------------------");

			try {
				com.IdentifyCourses.utils.excelUtils.setCellData(fileName, "Sheet1", 1, 1, courseOneHeading);
				com.IdentifyCourses.utils.excelUtils.setCellData(fileName, "Sheet1", 2, 1, courseOneLearnTime);
				com.IdentifyCourses.utils.excelUtils.setCellData(fileName, "Sheet1", 3, 1, courseOneRating);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (org.openqa.selenium.NoSuchElementException e) {
			// Handle the exception (e.g., print a message)
			System.out.println("Element not found: " + e.getMessage());
		}
	}

	public void secondCourseHandling() {

		Set<String> allHandles = driver.getWindowHandles();
		List<String> allHandlesList = new ArrayList<>(allHandles);
		System.out.println(allHandlesList);
		String parentWindowId = allHandlesList.get(0);
		String firstCourseWindowId = allHandlesList.get(1);
		String secondCourseWindowId = allHandlesList.get(2);
		driver.switchTo().window(secondCourseWindowId);
//
//		WebElement SecondCourse = driver.findElement(By.xpath("(//div[@class='css-kplcru'])[2]"));
//		SecondCourse.click();

		try {

			String courseTwoHeading = secondCourseHeading.getText();
			System.out.println("Heading of the Second Course: " + courseTwoHeading);

			String courseTwoLearnTime = secondCourseLearnTime.getText();
			System.out.println("Learning Time For Second Course:" + courseTwoLearnTime);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			String courseTwoRating = secondCourseRating.getText();
			System.out.println("Rating for the Second Course:" + courseTwoRating);

			try {
				com.IdentifyCourses.utils.excelUtils.setCellData(fileName, "Sheet1", 1, 2, courseTwoHeading);
				com.IdentifyCourses.utils.excelUtils.setCellData(fileName, "Sheet1", 2, 2, courseTwoLearnTime);
				com.IdentifyCourses.utils.excelUtils.setCellData(fileName, "Sheet1", 3, 2, courseTwoRating);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (org.openqa.selenium.NoSuchElementException e) {
			// Handle the exception (e.g., print a message)
			System.out.println("Element not found: " + e.getMessage());
		}

		driver.switchTo().window(parentWindowId);
	}

}
