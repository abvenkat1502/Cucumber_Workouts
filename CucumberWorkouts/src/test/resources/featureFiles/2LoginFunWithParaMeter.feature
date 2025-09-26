@Two @Add
Feature: Verify login functionality with parameter
@Two-1
Scenario: Login with valid functionality using parameter
	Given Open chrome browser and hit test URL
	When Enter valid user name "AB1" and password "Test@123"
	And Clicking the login button to ensure login success
  Then User should be logged in successfully on expected site

