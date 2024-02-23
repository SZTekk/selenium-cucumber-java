Feature: As a User I want to test valid and invalid login functionality
				 of the application
				 
	
 Background: User is on Login screen
    Given User move to login screen			 
				 

  @login
  Scenario Outline: Verify user valid and invalid login scenario
  
    When I Enter "<Username>" in login text field
    And  I Enter "<Password>" in password text field
    When I Click on login button
    Then I Verify the "<ValidationMessage>" message

    Examples: 
      | Username  					| Password          | ValidationMessage    |
      | imran.pbh@gmail.com |                   | Password is required |
      |  										| wrongPasswordTest | Username is required |
      | imran.pbh@gmail.com | Register@12345    |                      |