Feature: Double service request
  Scenario Outline: Advertiser accepts first of repeated requests and rejects the second request
    Given An unscheduled request with the date <date> and the time <time> to the service <serviceId>
    When Another client with username <username> and password <password> log in in the application
    And Send a new request with the same date <date> and time <time> and message <content> to the service <serviceId>
    Then The advertiser will log in in the application
    And Will click on "Accept" button located on the first client's request
    And Define the end time of the service appointment
    And He will click on "Reject" button located on the second request
    And Write a message clearing the reason of that rejection
  Examples:
|date         |time  |serviceId|username  |password |content
|"2020-05-31"|"13:00"|4        |"cesar947"|"3456789"|"I need your service"