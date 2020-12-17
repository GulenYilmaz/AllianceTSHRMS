@cucumberDatabaseTesting
Feature: LMS database Testing

  Background: 
    Given I create connection with LMS database
    And I create a statement

  Scenario: users validation for LMS database
    When I retrive all users from LMS database
    Then I validate results for  users
      | James |
      | Jones |
      | Mike  |
      | Nora  |
    And I close all connections
     
