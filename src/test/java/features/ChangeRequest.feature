Feature: Create and validate change request

  Scenario: Create a change request and validate the status code
    Given Set the Endpoint
    And Set the Auth
    When hit the post method to create a change request
    Then validate the response code and the response body

  Scenario: Fetch a single record from the change request and validate the status code
    Given Set the Endpoint
    And Set the Auth
    When hit the get method to fetch a single record base on the "7e64bcc383fe9210695bc7b6feaad3ed" sysId
    Then validate the get method response code
