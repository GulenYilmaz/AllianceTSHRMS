@TestCase3
Feature: Add multiple Users to ATS
  Background:
    Given user enters valid username and password
    When user clicks on login button
    Then user succesfully logged in
    And user navigates to UserManagementPage
    And user click add button
  Scenario Outline: Add multiple Users with Scenario Outline
    When user enter "<Username>", "<UserEmail>", "<UserContact>", "<AssignPassword>"
    Then user upload a picture "<UploadPicture>"
    Then user selects permission to Grades, Courses, Teacher, Student, User Managements ans ToDos
    And user click save changes button
    Then "<Username>", "<UserEmail>", "<UserContact>", "<AssignPassword>" and "<UploadPicture>" is added successfully
    Examples:
      | Username | UserEmail        | UserContact | AssignPassword | UploadPicture                              |
      | James    | james@james.com  |  1234567890 |       12345678 | C:\Users\gulen\Desktop\1.jpg |
      | Jones    | jones@joness.com |  1234567890 |       12345678 | C:\Users\gulen\Desktop\1.jpg |
      | Mike     | mike@mike.com    |  1234567890 |       12345678 | C:\Users\gulen\Desktop\1.jpg |





