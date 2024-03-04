Feature: Smoke Testing

  Scenario: Launch Browser
    Given user should launch the browser
    When user navigates to url
    Then Web page should load

  Scenario: Validate search box
    Given user should be on coursera homepage
    Then search box should displayed

  Scenario: Validate Search Icon
    Given user should be on coursera homepage
    When user search for "Web Development" course

  Scenario: Validate first navigation links
    Given user should be on coursera homepage
    When user clicks on for individual link
    Then user should see courseera homepage

  
  Scenario: Validate second navigation links
    Given user should be on coursera homepage
    When user clicks on for bussiness link
    Then user should see bussiness page.

  
  Scenario: Validate third navigation links
    Given user should be on coursera homepage
    When user clicks on for universities link
    Then user should see for campus page
