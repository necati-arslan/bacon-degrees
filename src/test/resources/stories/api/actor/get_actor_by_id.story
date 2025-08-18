Meta:
@api @actor @smoke

Narrative:
In order to fetch actor details
As an API consumer
I want to get an actor by nconst

Scenario: Get actor by nconst (happy path)
Given the API base is running
When I request actor by nconst 'nm0000001'
Then the response status should be 200
And the response content type should be JSON
And the actor payload should have nconst 'nm0000001'
And the actor payload should have primaryName 'Kevin Bacon'
And the actor payload should have birthYear 1958
And the actor payload should have deathYear null
And the actor payload should include profession 'actor'
And the actor payload should include knownFor 'tt0000001'

