Feature: Double service request
  Scenario: Advertiser accepts first of repeated requests and rejects the second request
    Given an announcer located in My Services page
    And has a service with two requests with the same hour and date
    When he hovers the mouse to see the requests of the service
    Then He will accept the request of who sent it first
    And Define the end time of the service
    But He will reject the other request
    And Write the message with the reasons of the rejection

