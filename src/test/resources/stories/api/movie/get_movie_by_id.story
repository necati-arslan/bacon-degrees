Meta:
@api @movie @smoke

Narrative:
In order to fetch movie details
As an API consumer
I want to get a movie by tconst

Scenario: Get movie by tconst (happy path)
Given the Movie API base is running
When I request movie by tconst 'tt0000001'
Then the movie response status should be 200
And the movie response content type should be JSON
And the movie payload should have tconst 'tt0000001'
And the movie payload should have primaryTitle 'Film A'
And the movie payload should have startYear 1990
And the movie payload should have endYear null


Scenario: Movie not found by tconst (null/empty body contract)
Given the Movie API base is running
When I request movie by tconst 'tt9999999'
Then the movie response status should be 200
And the movie response should be empty result
