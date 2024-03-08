@update
Feature: Create pets with different details

  Scenario Outline: Create a pet with specific details
    Given I create a pet with the following details:
      | id  | name   | status    | catId | catName | tagId | tagName | photoUrl  |
      | <id> | <name> | <status> | <catId> | <catName> | <tagId> | <tagName> | <photoUrl> |
    When i send request to create user
    Then the pet payload should be created successfully

    Examples:
      | id | name   | status    | catId | catName | tagId | tagName | photoUrl  |
      | 1  | doggie | available | 1     | category1 | 1    | tag1    | http://example.com/doggie.jpg |
      | 2  | kitty  | sold      | 2     | category2 | 2    | tag2    | http://example.com/kitty.jpg  |
      | 3  | ghoda  |  available|   3   |category2  |  3   |tag3     |http://example.com/kitty.jpg   |


  @update
  Scenario Outline: Update pet by name and Id and status
    Given Call the pet with <id>
    And Store previous id , name and status
    When i call for the pet update with the petid <id> , name "<name>" and status "<status>"
    Then Check the response status code
    Then Check the response that name is changed or not
    Then Check the status is changed or not
    Examples:
    |id|name | status|
    | 2 |billa|aviable|
    | 3 |   horse  |sold|
