@One @Add
Feature: Verifying the login functionality
  @One-1
  Scenario: Login with valid functionality
    Given Launch chrome browser and hit test URL
    When Enter valid user name and password
    And Click login button to ensure login success
    Then User should be logged in successfully
  @One-2
  Scenario Outline: Invalid - Login with valid functionality
    Given Invalid - Launch chrome browser and hit test URL
    When Invalid - Enter valid user name and password
    And Invalid - Click login button to ensure login success
    Then Invalid - User should be logged in successfully