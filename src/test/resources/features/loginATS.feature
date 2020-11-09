

@validLogin
Feature: Login to ATS
  I want to use this template for my feature file


  Scenario: Login to ATS page
    Given user enters valid username and password
    When  user clicks on login button
    Then  user succesfully logged in
  

  
