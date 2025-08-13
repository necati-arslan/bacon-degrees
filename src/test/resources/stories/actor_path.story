Narrative:
In order to fetch actor details
As an API consumer
I want to get an actor by nconst

Scenario: Get Kevin Bacon by nconst
Given the API base is running
When I request actor by nconst 'nm0000001'
Then the response should contain Kevin Bacon details