package com.IdentifyCourses.pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class pom_extractLanguages extends BasePage {

	public pom_extractLanguages(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@placeholder='What do you want to learn?']")
	WebElement searchInput;

	@FindBy(xpath = "//button[@class='nostyle search-button']//div[@class='magnifier-wrapper']")
	WebElement searchButton;

	@FindBy(xpath = "//*[@data-testid='search-filter-group-Subject']//span[contains(text(),'Language Learning')]")
	WebElement languageLearningSubject;

	@FindBy(xpath = "//*[@data-testid='search-filter-group-Subject']//span[contains(text(),'Language Learning')]")
	WebElement subjectScroll;

	@FindBy(xpath = "//button[@aria-label='Show more Language options']//span[@class='cds-button-label'][normalize-space()='Show more']")
	WebElement showMoreLanguagesButton;

	@FindBy(xpath = "//div[@id='checkbox-group']//span[@class='cds-checkboxAndRadio-labelContent css-imksha']")
	List<WebElement> languageCheckboxes;

	@FindBy(xpath = "//*[@data-testid='search-filter-group-Learning Product']//label[contains(text(),'Learning Product')]")
	WebElement learningProduct;

	@FindBy(xpath = "//button[@class='cds-149 cds-button-disableElevation cds-button-ghost css-1s96oj']//span[@class='cds-button-label'][normalize-space()='Close']")
	WebElement closeLanguagesButton;

	@FindBy(xpath = "//*[@data-testid='search-filter-group-Level']//div[@class='css-nsxeb5']")
	List<WebElement> Level;

	String fileName = System.getProperty("user.dir") + "/src/test/resources/courseData.xlsx";
	Locators loc = new Locators(com.IdentifyCourses.factory.helperClass.getDriver());

	public void enterSearchKeyword() {
		searchInput.sendKeys("Language Learning");
	}

	public void clickSearchButton() {
		searchButton.click();
	}

	public void clickLanguageLearningSubject() {
		languageLearningSubject.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", subjectScroll);
	}

	public void clickShowMoreLanguagesButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", showMoreLanguagesButton);
	}

	public void getLanguageCheckboxes() {
		int langCount = languageCheckboxes.size(); // Printing the count
		System.out.println("Number of Languages: " + langCount);
		try {
			com.IdentifyCourses.utils.excelUtils.setCellDataInt(fileName, "Sheet2", 2, 0, langCount);
		} catch (Exception e) {
			// Handle any IO exceptions
		}
		System.out.println(
				"---------------------------------------------------------------------------------------------------");

		for (int i = 1; i <= languageCheckboxes.size(); i++) {
			WebElement loopingLang = driver.findElement(By.xpath(
					"(//div[@id=\"checkbox-group\"]//span[@class='cds-checkboxAndRadio-labelContent css-imksha'])[" + i
							+ "]"));
			String langType = loopingLang.getText();
			System.out.println("Language " + i + ": " + langType);

			try {
				com.IdentifyCourses.utils.excelUtils.setCellData(fileName, "Sheet2", i + 1, 1, langType);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void closeLanguagesTab() {
		closeLanguagesButton.click();

	}

	public void ScrollToLevel() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", learningProduct);
	}

	public void getLevelOptions() {
		int levelCount = Level.size();

		System.out.println("Level Count :" + levelCount);
		try {
			com.IdentifyCourses.utils.excelUtils.setCellDataInt(fileName, "Sheet3", 2, 0, levelCount);
		} catch (Exception e) {
			// Handle any IO exceptions
		}

		System.out.println(

				"---------------------------------------------------------------------------------------------------");

		for (int i = 1; i <= levelCount; i++) {
			WebElement showLevel = driver.findElement(
					By.xpath("(//*[@data-testid='search-filter-group-Level']//div[@class='css-nsxeb5'])[" + i + "]"));
			String levelUp = showLevel.getText();
			System.out.println("Level " + i + ": " + levelUp);
			try {
				com.IdentifyCourses.utils.excelUtils.setCellData(fileName, "Sheet3", i + 1, 1, levelUp);
			} catch (Exception e) {
				// Handle any IO exceptions
			}

		}
	}
}
