Air_Booking_Round_Trip_2_Adults_With_Dollars

Meta:
@AirBooking

Narrative:
As an Anonymous user
I want to check the logic to apply Dollars as Payment Method
So that I can book a flight applying dollars

Scenario: scenario description
Given I am on the Plan a Trip page
When I fill the flight fields with the following itinerary data:
|key|value|
|flightType|Roundtrip|
|departureCity|DAL|
|departureDate|5|
|adultCounter|2|
|returnCity|AMA|
|returnDate|5|

And I search a flight
And I Sort By Price
And I chose the first departure flight with an available Anytime fare
And I chose the first return flight with an available Business select fare
And I continue to the Price Page
Then I validate I am on the Price page
And I continue to the Purchase Page
Then I validate I am on the Purchase Page
