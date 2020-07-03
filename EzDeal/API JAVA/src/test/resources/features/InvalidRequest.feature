Feature: Request a service
  Scenario: Rejecting a request according to the advertiser's criteria
    Given A client who wants to request a service
    And Fill the request form with an agreed time which affects the time of another job already scheduled by the announcer
    When He select the send option
    Then The request will be sent to the announcer
    But It will be rejected by the announcer
    And He will send the reason for rejection

