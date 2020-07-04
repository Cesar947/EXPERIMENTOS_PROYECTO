Feature: Evaluate a request
  Scenario: Rejected request
    Given An announcer in his services view
    And He has a service with at least one request that is not convinient
    When He selects the reject option
    Then He will write and send a message with the reason of rejection
    And The client will see his message in his request view
    And He will be able to make a request again