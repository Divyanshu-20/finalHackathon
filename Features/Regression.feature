Feature: Regression testing

  Scenario: Search For Courses
    Given user should be on homepage
    When user search for "Web Development" courses
    And user select beginners level
    And user select English language

  Scenario: Extracting course details
    Given user should see all courses
    When user click on both course
    Then user get the first course details
    Then user get the second course details

