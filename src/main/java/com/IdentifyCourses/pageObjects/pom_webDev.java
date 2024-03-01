package com.IdentifyCourses.pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class pom_webDev extends BasePage {

	public pom_webDev(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@placeholder='What do you want to learn?']")
	WebElement inputBar;

	@FindBy(xpath = "//button[@class='nostyle search-button']//div[@class='magnifier-wrapper']")
	WebElement searchButton;

	@FindBy(xpath = "//label[contains(text(),'Level')]")
	WebElement levelScroll;

	@FindBy(xpath = "//span[contains(text(),'Beginner')]")
	WebElement beginnerFilter;

	@FindBy(xpath = "//label[contains(text(),'Educator')]")
	WebElement educatorScroll;

	@FindBy(xpath = "//span[contains(text(),'English')]")
	WebElement englishFilter;

	@FindBy(xpath = "//h3[normalize-space()='Filter by']")
	WebElement Scrollup;

	@FindBy(xpath = "(//div[@class='css-kplcru'])[2]")
	WebElement secondCourse;

	@FindBy(xpath = "(//div[@class='css-kplcru'])[1]")
	WebElement firstCourse;

	@FindBy(xpath = "//*[@data-e2e=\"hero-module\"]//h1")
	WebElement firstCourseHeading;

	@FindBy(xpath = "(//section[@class='css-3nq2m6']/div[2]/div[3]/div[@class='cds-119 cds-Typography-base css-h1jogs cds-121'])[2]")
	WebElement firstCourseLearnTime;

	@FindBy(xpath = "(//*[@data-e2e='key-information']//div[@class='cds-119 cds-Typography-base css-h1jogs cds-121'])[1]")
	WebElement firstCourseRating;

	@FindBy(xpath = "//*[@data-e2e='hero-module']//h1")
	WebElement secondCourseHeading;

	@FindBy(xpath = "//section[@class='css-6hd39m']/div/div[2]/div/div[1]/div[1]")
	WebElement secondCourseLearnTime;

	@FindBy(xpath = "(//*[@data-e2e='key-information']//div[@class='cds-119 cds-Typography-base css-h1jogs cds-121'])[1]")
	WebElement secondCourseRating;

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
			System.out.println("Learning Time For Second Course:" + "Approx. 40 hours to complete");

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
