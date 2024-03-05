Feature: Post method test
  Background:
    Given http baseUri is "https://petstore.swagger.io/v2"

  Scenario Outline: Add user to PetStore
    When I set body to post user with details
      | id | username | firstname | lastname | email   | password | phone  | userStatus |
      | <id> | <username> | <firstname> | <lastname> | <email> | <password> | <phone> | <userStatus> |
    And I POST "/user"
    And http response code should be 200
    And http response header Content-Type should be "application/json"
    Examples:
      | id | username | firstname | lastname | email             | password | phone       | userStatus |
      | 101  | asdfasd  | John      | Doe      | johndoe@example.com | johnDoe  | 1234567890  | 1          |
      | 2  | janeasdfDoe  | Jane      | Doe      | janedoe@example.com | pass456  | 9876543210  | 1          |


  Scenario: User logs in with username and password
    When the user logs in "janeasdfDoe" and "pass456"
    Then the user is logged in successfully

  Scenario Outline: User should able to get his information
    When I GET "/user/" and "<username>"
    And the user ID should be <userId>
#    And the username should be "<expectedUsername>"
#    And the first name should be "<expectedFirstName>"
#    And the last name should be "<expectedLastName>"
#    And the email should be "<expectedEmail>"
#    And the password should be "<expectedPassword>"
#    And the phone number should be "<expectedPhone>"
#    And the status should be <expectedUserStatus>

    Examples:
      | username     | statusCode | userId | expectedUsername | expectedFirstName | expectedLastName | expectedEmail | expectedPassword | expectedPhone | expectedUserStatus |
      | janeasdfDoe  | 200        | 0      | string           | string            | string           | string        | string           | string        | 0                  |
      | johnDoe      | 404        | -1     | null             | null              | null             | null          | null             | null          | null               |










