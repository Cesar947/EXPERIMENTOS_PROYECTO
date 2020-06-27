Feature: Service start
  Scenario Outline: A logged in announcer looks at his schedule to see his appointments and
                    start a specific service
    Given An announcer logged in with username <username> and password <password>
    When He clicks on My Schedule option
    And He clicks on his first appointment's start button
    Then He will see the start time of that service
    Examples:
    |username|password|
    |Slayz08 |7777777 |