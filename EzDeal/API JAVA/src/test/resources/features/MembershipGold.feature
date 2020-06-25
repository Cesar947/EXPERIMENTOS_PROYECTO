Feature: Gold membreship acquirement
  Scenario Outline: An announcer acquire a gold membership and a client will see his services in the Home View
    Given An announcer with username <usernameA> and password <passwordA>
    And A client with username <usernameC> and password <passwordC>
    When The announcer clicks on I wanna be Gold button
    And He send the payment form filled
    Then The client will see the services of this announcer in the Home View

  Examples:
  |usernameA|passwordA|usernameC|passwordC
  |Slayz08  |7777777  |jair777  |135790
