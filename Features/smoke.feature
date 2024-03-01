@smoke
Feature: Smoke Testing

  @smoke
  Scenario: Launch Browser
    Given user should launch the browser
    When user navigates to url
    Then Web page should load

  @smoke
  Scenario: Validate search box
    Given user should be on courseera homepage
    Then search box should displayed

  @smoke
  Scenario: Validate Search Icon
    Given user should be on courssera homepage
    When user search for "Web Development" course

  @smoke
  Scenario: Validate show more link
    Given user should see all courses
    When user clicks on show more link
    Then user should see all available language options

  @smoke
  Scenario: Validate filters
    Given user should see all courses
    When user clicks on Beginner level
    Then checkbox should be selected.
    
    @smoke
    Scenario: Extracting details1
    Given user should see all courses
    When user click on first course
    Then user get the details
    
     @smoke
    Scenario: Extracting details2
    Given user should see all courses
    When user click on second course
    Then user get the details

  @smoke
  Scenario: Validate first navigation links
    Given user should be on courssera homepage
    When user clicks on for individual link
    Then user should see courseera homepage

  @smoke
  Scenario: Validate second navigation links
    Given user should be on courssera homepage
    When user clicks on for bussiness link
    Then user should see bussiness page.

  @smoke
  Scenario: Validate third navigation links
    Given user should be on courssera homepage
    When user clicks on for universities link
    Then user should see for campus page

  @smoke
  Scenario: Validate Solution dropdown
    Given user should see bussiness page
    Then user clicks on the solution dropdown
    When user should see  solutions options

  @smoke
  Scenario: Validate Solution dropdown options
    Given user should click on solution dropdown
    When user clicks on For Campus option
    Then user should see for campus page
