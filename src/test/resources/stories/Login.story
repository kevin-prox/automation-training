Meta:

Narrative:
As a Southwest.com user
I want to see the login dropdown
So I can validate inline errors, max and min length

Scenario: I want to validate error messages appear when I fill in the login dropdown fields with invalid account number or username format and I click the login button

Given I am on the Home page
When I click on the Log In link in the Primary header navigation of the page
And I enter 12345! in the ACCOUNT NUMBER OR USERNAME field in the Log In dropdown
And I enter Test1234 in the PASSWORD field in the Log In dropdown
And I click on Log In button
Then I see Enter a valid Account Number or Username. error message
And I see the Log In fields empty