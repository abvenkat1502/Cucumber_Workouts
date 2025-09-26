@Five @Add
Feature: Verify login functionality with Pipeline with Example Keyword
@Five-1
Scenario Outline: Login with valid functionality Pipeline with Example Keyword
	Given Pipeline with Example Keyword - Open chrome browser and hit test URL
	When  Pipeline with Example Keyword Enter valid user name "<USERNAME>" and password "<PASSWORD>"	
	And   Pipeline with Example Keyword - Clicking the login button to ensure login success
  Then   Pipeline with Example Keyword - User should be logged in successfully on expected site
  
  Examples:
  | USERNAME | PASSWORD |
	| AB1 | Test@123      |
  | AB1 | Test@123      |