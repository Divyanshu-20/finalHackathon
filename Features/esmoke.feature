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

