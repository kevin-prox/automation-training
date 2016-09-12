Air_Booking_One_Way_Adult_With_Dollars

Meta:
@AirBooking

Narrative:
As an Anonymous user
I want to check the logic to apply Dollars as Payment Method
So that I can book a flight applying dollars

Scenario: I want to select the first available WGA flight for a OW trip

Given I am on the Plan a Trip page
When I fill the flight fields with the following itinerary data:
|key|value|
|flightType|ONE_WAY|
|departureCity|DAL|
|departureDate|1|
|returnCity|HOU|

And I search a flight
And I select the first departure flight with an available WGA fare
And I continue to the Price page
Then I validate I am on the Price page
And I validate the departure and return stations are the ones selected in the Plan a Trip page
