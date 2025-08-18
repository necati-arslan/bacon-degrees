Feature: Get actor by id

  Scenario: Get Kevin Bacon by nconst
    Given the API base is running
    When I request actor by nconst "nm0000001"
    Then the response should contain Kevin Bacon details
