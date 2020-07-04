Feature: Request a service
  Scenario: Request submission error for hour already occupied
    Given A client in the detail of a service
    When He fill the request form with an agreed time that belongs to range of hours of a scheduled request
    And He clicks in send request option
    Then An alert will appear with a detailed message of error


