Feature: API Testing
  As a user of the API
  I want to verify its functionality

  Scenario: Retrieve user information
    Given I have the base URL "https://reqres.in"
    When I send a GET request to "/api/users?page=2"
    Then the response status code should be 200
    And the response body should contain "2"
