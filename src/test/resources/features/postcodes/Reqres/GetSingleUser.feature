Feature: Feature get single user to test reqres

  @Tugas @Positive @GET
  Scenario Outline: Get single user with valid parameter id
    Given Get single user with parameter id <id>
    When Send request get single user
    Then Should return 200 OK
    And Response body should contain firstname "<firstname>" and lastname "<lastname>"
    And Get single user json schema validator
    Examples:
      |id|firstname|lastname|
      |1 |George   |Bluth   |
      |2 |Janet    |Weaver  |

  @Tugas @Negative @GET
  Scenario Outline: Get single user with invalid id
    Given Get single user with invalid id "<id>"
    When Send request get single user with invalid id
    Then Should return 404 Not Found
    Examples:
      |id |
      |asa|

  @Tugas @GET
  Scenario Outline: Get single user not found
    Given Get single user not found with id <id>
    When Send request get single user not found
    Then Should return 404 Not Found
    Examples:
      |id|
      |23|
      |31|