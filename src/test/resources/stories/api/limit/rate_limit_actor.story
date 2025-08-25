Meta: @rateLimit @actors
Scenario: Actor API returns 429 when rate limit is exceeded
Given the Actor API base is running
When I burst 3 GET requests to "/api/actors/nm0000001" within 1 second
Then the last actor response status should be 429
And the last actor response should include header "Retry-After"
