@TestCase2
Feature: Add new User to ATS

  Background: 
    Given user enters valid username and password
    When user clicks on login button
    Then user succesfully logged in
    And user navigates to UserManagementPage

  @addUser
  Scenario: Add User with with Username, User Email, User Contact, Assign Password
    When user click add button
    When user enter employee name "John", "john@john.com", "1234567890" and "12345678"
    Then user upload a picture "C:\Users\gulen\Desktop\1.jpg"
    Then user selects permission to Grades, Courses, Teacher, Student, User Managements ans ToDos
    And user click save changes button
    Then "John" is added successfully
