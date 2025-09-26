@Seven @Add
Feature: Verifying the login functionality with Backgroung

Background:
		Given BG1 Cucumber Background one
		When BG1 Cucumber Background two
  @Seven-1
  Scenario Outline: BG1 Login with valid functionality
    Given BG1 Launch chrome browser and hit test URL
    When BG1 Enter valid user name and password
    And BG1 Click login button to ensure login success
    Then BG1 User should be logged in successfully
  @Seven-2
  Scenario: BG2 Login with valid functionality
    Given BG2 Launch chrome browser and hit test URL
    When BG2 Enter valid user name and password
    And BG2 Click login button to ensure login success
    Then BG2 User should be logged in successfully