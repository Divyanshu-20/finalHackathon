package com.IdentifyCourses.pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class pom_PrintLanguages extends BasePage {

	public pom_PrintLanguages(WebDriver driver) {
		super(driver);
	}

	// WebElements using @FindBy annotations
	@FindBy(xpath = "(//span[normalize-space()='Explore'])[2]")
	WebElement exploreButton;

	@FindBy(xpath = "//span[normalize-space()='Language Learning']")
	WebElement languageLearningButton;

	@FindBy(xpath = "//a[normalize-space()='Popuar Language Courses']")
	WebElement popularLanguageButton;

	@FindBy(xpath = "//div[@class='col-md-9 main-column m-y-2']/div/a")
	List<WebElement> courseElements;

	@FindBy(xpath = "//a[normalize-space()='Beginner Language Courses']")
	WebElement beginnerLanguageCoursesLink;

	@FindBy(xpath = "//a[normalize-space()='Advanced Language Courses']")
	WebElement advancedLanguageCoursesLink;
	
	String fileName = System.getProperty("user.dir") + "/src/test/resources/courseData.xlsx"; 
	Locators loc = new Locators(com.IdentifyCourses.factory.helperClass.getDriver());

	public void clickExploreButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", exploreButton);
	}

	public void clickLanguageLearningButton() {
		// Implementation left empty
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", languageLearningButton);
	}

	public void clickPopularLanguageButton() {
		// Implementation left empty
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", popularLanguageButton);
		
	}

	public void getCourseElementsRequirements() {
		String courseElements = "(//div[@class='col-md-9 main-column m-y-2']/div/a)";

		// Finding elements matching the XPath
		List<WebElement> singleCourseElement = driver.findElements(By.xpath(courseElements));

		// Getting the count of elements
		int itemCount = singleCourseElement.size();

		// Printing the count
		System.out.println("Number of items: " + itemCount);

		System.out.println(
				"---------------------------------------------------------------------------------------------------");
		String HeadingXpath = "(//div[@class='col-md-9 main-column m-y-2']/div/a)[%d]/div[2]/div/h4";

		// Loop through elements
		for (int i = 1; i <= itemCount; i++) {
			// Construct the dynamic XPath with the changing index
			String HeadDynamicXPath = String.format(HeadingXpath, i);

			// Find the element using the dynamic XPath
			WebElement Course = driver.findElement(By.xpath(HeadDynamicXPath));

			// Do something with the element, for example, print its text
			System.out.println("Course " + i + " Heading:" + Course.getText());
		}

		System.out.println(
				"---------------------------------------------------------------------------------------------------");

		for (int j = 1; j <= itemCount; j++) {
			try {
				String LevelXpath = "(//div[@class='col-md-9 main-column m-y-2']/div/a)[%d]/div[2]/div/div[2]/div/span";
				// Construct the dynamic XPath with the changing index
				String LeveldynamicXPath = String.format(LevelXpath, j);
				// Find the element using the dynamic XPath
				WebElement Course = driver.findElement(By.xpath(LeveldynamicXPath));
				// Print its text
				System.out.println("Course " + j + " Level:" + Course.getText());
			} catch (Exception e) {
				// If an exception occurs, print a message and continue to the next iteration
				System.out.println("No Level Assigned for Course " + j);
			}
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------");
	}

}
