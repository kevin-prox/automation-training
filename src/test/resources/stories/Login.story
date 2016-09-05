Fail Login

Meta:


Narrative:
In order to get an invalid credential message
As a unregistered user
I try to login entering invalid credentials


Scenario: I want to perform a invalid message in the Log in dropdown

Given I am on the Home page
When I click on the Log In icon in the Primary Header Navigation of the page
Then I see the Login dropdown opened
When I enter $InvalidUser on the user field
When I enter Password value on the password field
And I click on Login Button button in the search dropdown
Then I see the error message at the bottom of the dropdown

