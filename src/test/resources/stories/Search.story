Search

Meta:

Narrative:
As a Southwest Anonymous user
I want to perform a search
So I can validate the Search functionality

Scenario: I want to perform a search with results

Given I am on the Home page
When I click on the Search icon in the Primary Header Navigation of the page
Then I see the Search dropdown opened
When I enter Baggage value in the search field
And I click on Search button in the search dropdown
Then I see the search keyword in the Search title
