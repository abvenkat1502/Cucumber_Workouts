@Four @Add
Feature: Verify login functionality with Pipeline with header
@Four-1
Scenario: Login with valid functionality Pipeline with header
	Given Pipeline with header - Open chrome browser and hit test URL
	When  Pipeline with header - Enter valid user name and password

	|USERNAME|PASSWORD|
	| AB1 | Test@123 |
		
	And   Pipeline with header - Clicking the login button to ensure login success
  Then  Pipeline with header- User should be logged in successfully on expected site