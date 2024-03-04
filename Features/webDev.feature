Feature: Identify Courses

  Scenario: Validate Display of First Two Web Development Courses for Beginners
    Given a user is on the website homepage
    When the user inputs "web development courses" as the search query
    And the user interacts with the search bar
    And the user applies filters for beginners level courses
    And the user applies filters for courses offered in English
    Then two new tabs should open, each containing details for the top two courses
    And the details for the first course should be validated
    And the details for the second course should be validated

  Scenario: Popular Courses Extraction
    Given the user is on the homepage
    When the user explores language learning
    And selects popular courses
    Then validate courses and levels

  Scenario: Extract Languages from Coursera
    Given the user is on the coursera.org website
    When the user enters Language Learning in the search bar and clicks
    And the user clicks on Language Learning in the subject
    And the user clicks on Show more in Languages to extract all languages
    Then the user extracts all languages
    And the user closes the Languages tab
    And the user scrolls down to the level section
    Then the user extracts all levels

  Scenario: Invalid Email Login
    Given the user is on the Coursera homepage
    When the user navigates to For Enterprise then to Solutions then to Coursera for Campus and finally to Contact Us
    Then the user should be on the Contact Us page
    When the user fills the Contact Us form with an invalid email address
    And clicks the Submit button
    Then the user should see an error message related to the invalid email input
