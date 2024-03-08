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
      | 101  | ankit89  | John      | Doe      | johndoe@example.com | johnDoe  | 1234567890  | 1          |
      | 2  | janeasdfDoe  | Jane      | Doe      | janedoe@example.com | pass456  | 9876543210  | 1          |
      |  4   | narendramodi       |     modi    |  jii        |   politica@tmc          |9876543210|9876543210|    1        |


  Scenario Outline: User logs in with username and password
    When the user logs in "<username>" and "<password>"
    Then the user is logged in successfully
    Examples:
    |username|password|
    |   ankit89     |   johnDoe     |
    |       janeasdfDoe        |pass456|

  Scenario Outline: User should able to get his information
    When I GET "https://petstore.swagger.io/v2/user/" and "<username>"
    And the user ID should be <userId>
    And the username should be "<expectedUsername>"
    And the email should be "<expectedEmail>"
    And the password should be "<expectedPassword>"

    Examples:
      | username     | userId | expectedUsername  | expectedEmail | expectedPassword |
      | janeasdfDoe  | 2      | janeasdfDoe       | janedoe@example.com        | pass456           |
      | ankit89      | 101     | ankit89          | johndoe@example.com        | johnDoe             |

  Scenario Outline: Delete a User and Check
    When I Delete "<username>"
    And Check the response <code>
    And  I Check the user Details "<checkuser>"
    Then response status should be <res>
    Examples:
    |username          |code|checkuser |res|
    |   janeasdfDoe    | 200 |janeasdfDoe  |  404   |
    |       ankit89    | 200 |narendramodi |   200 |








