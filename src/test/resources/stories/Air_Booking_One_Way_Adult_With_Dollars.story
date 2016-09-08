Air_Booking_One_Way_Adult_With_Dollars

Meta:

Narrative:
As an Anonymous user
I want to check the logic to apply Dollars as Payment Method
So that I can book a flight applying dollars

Scenario: I want to select the first available WGA flight for a OW trip

Given I am on the Plan a Trip page
When I select the one way flight type on the Plan a Trip Page
And I enter DAL into depart input field on the Plan a Trip Page
And I enter 09/08 date into depart day input field on the Plan a Trip Page
And I enter HOU into arrive input field on the Plan a Trip Page
And I search a flight
And I select the first departure flight with an available WGA fare
And I continue to the Price page
Then I validate I am on the Price page