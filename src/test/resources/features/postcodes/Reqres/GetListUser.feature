Feature: Feature get list user to test Reqres
  @Latihan
  Scenario Outline: Get list user with valid parameter page
    Given Get list user with parameter page <page>
    When Send request get list user
    Then Should return 200 OK
    And Response body page should be <page>
    And Get list user json schema validator
    Examples:
      |page|
      |1   |
      |2   |

  @Tugas @Negative @GET
  Scenario Outline: Get list user with invalid parameter page
    Given Get list user with invalid parameter page "<page>"
    When Send request get list user
    Then Should return 404 Not Found
    Examples:
      |page|
      |abc |
      |@#$ |


  @Tugas @Negative @GET
  Scenario Outline: Get list user with parameter page more than exceed
    Given Get list user with exceed parameter page <page>
    When Send request get list user
    Then Should return 404 Not Found
    Examples:
      |page|
      |3   |