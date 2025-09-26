@Six @Add
Feature: Verifying the login functionality with tags
	@Six-1
  Scenario: tags - Login Functionality before clicking the login button
    Given tags - Launch chrome browser and hit test URL
    When tags - Enter valid user name and password
    And tags - Click login button to ensure login success
    Then tags - User should be logged in successfully