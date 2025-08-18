Narrative:
In order to fetch movie details
As an API consumer
I want to get a movie by tconst

Scenario: Get Film A by tconst
Given the Movie API base is running
When I request movie by tconst 'tt0000001'
Then the response should contain Film A details

Scenario: Movie not found by tconst
Given the Movie API base is running
When I request movie by tconst 'tt9999999'
Then the movie response should be empty result
