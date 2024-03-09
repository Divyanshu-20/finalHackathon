package com.IdentifyCourses.pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class pom_InvalidErrorCapture extends BasePage {
	public pom_InvalidErrorCapture(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//div[@class=\"css-j6ha89\"]/div/a[2]")
	WebElement businessesButton;

	@FindBy(xpath = "//a[normalize-space()='Solutions']")
	WebElement solutionsButton;

	@FindBy(xpath = "//a[@data-click-key='ent_website._business.click.navigation_mega_menu_Solutions_Universities']")
	WebElement courseraForCampusButton;

	@FindBy(xpath = "//div[@class=\"css-1rltwv6\"]/a")
	WebElement contactUsButton;

	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement firstNameInput;

	@FindBy(xpath = "//input[@id='LastName']")
	WebElement lastNameInput;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailInput;

	@FindBy(xpath = "//input[@id='Phone']")
	WebElement phoneInput;

	@FindBy(xpath = "//select[@id='Institution_Type__c']")
	WebElement institutionTypeDropdown;

	@FindBy(xpath = "//input[@id='Company']")
	WebElement companyInput;

	@FindBy(xpath = "//select[@id='Title']")
	WebElement jobRoleDropdown;

	@FindBy(xpath = "//select[@id='Department']")
	WebElement departmentDropdown;

	@FindBy(xpath = "//select[@id='What_the_lead_asked_for_on_the_website__c']")
	WebElement needsDropdown;

	@FindBy(xpath = "//select[@id='Country']")
	WebElement countryDropdown;

	@FindBy(xpath = "//select[@id='State']")
	WebElement stateDropdown;

	@FindBy(xpath = "//button[normalize-space()='Submit']")
	WebElement submitButton;

	@FindBy(xpath = "//div[@id='ValidMsgEmail']")
	WebElement validMsgEmail;

	String fileName = System.getProperty("user.dir") + "/src/test/resources/courseData.xlsx"; // storing the path of excel
	// file in "fileName"

	public void clickBusinessesButton() {
		businessesButton.click();
	}

	public void clickSolutionsButton() {
		solutionsButton.click();
	}

	public void clickCourseraForCampusButton() {
		courseraForCampusButton.click();
	}

	public void clickContactUsButton() {
		contactUsButton.click();
	}

	public void fillFirstName() {
		// Add your code here
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		firstNameInput.sendKeys("Divyanshu");
	}

	public void fillLastName() {
		// Add your code here
		lastNameInput.sendKeys("Dangore");
	}

	public void fillEmail() {
		// Add your code here
		emailInput.sendKeys("1234");
	}

	public void fillPhone() {
		// Add your code here
		phoneInput.sendKeys("9876543210");
	}

	public void selectInstitutionType() {
		// Add your code here
		Select dropdown = new Select(institutionTypeDropdown);
		// Select by visible text
		dropdown.selectByIndex(3);
	}

	public void fillCompany() {
		// Add your code here
		companyInput.sendKeys("Cognizant");
	}

	public void selectJobRole() {
		// Add your code here
		Select jobRoleSelect = new Select(jobRoleDropdown);
		jobRoleSelect.selectByVisibleText("Student");
	}

	public void selectDepartment() {
		// Add your code here
		Select departmentSelect = new Select(departmentDropdown);
		departmentSelect.selectByIndex(2);
	}

	public void selectNeeds() {
		// Add your code here
		Select needsSelect = new Select(needsDropdown);
		needsSelect.selectByIndex(2);
	}

	public void selectCountry() {
		// Add your code here
		Select countrySelect = new Select(countryDropdown);
		countrySelect.selectByVisibleText("India");
	}

	public void selectState() {
		// Add your code here
		Select stateSelect = new Select(stateDropdown);
		stateSelect.selectByVisibleText("Maharashtra");
	}

	public void clickSubmitButton() {
		// Add your code here
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		js.executeScript("arguments[0].scrollIntoView();", submitButton);
		js.executeScript("arguments[0].click();", submitButton);
	}

	public String getValidMsgEmailText() {
		// Add your code here
		System.out.println("Captured Error Message :" + validMsgEmail.getText());
		return null;
	}
}
