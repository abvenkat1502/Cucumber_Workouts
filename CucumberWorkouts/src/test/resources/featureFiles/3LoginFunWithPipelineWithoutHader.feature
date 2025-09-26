@Three @Add
Feature: Verify login functionality with Pipeline without header
@Three-1
Scenario Outline: Login with valid functionality Pipeline without header
	Given Pipeline without header - Open chrome browser and hit test URL
	When  Pipeline without header - Enter valid user name and password
	
	| AB1 | Test@123 |

	And   Pipeline without header - Clicking the login button to ensure login success
  Then  Pipeline without header- User should be logged in successfully on expected site
  
 

