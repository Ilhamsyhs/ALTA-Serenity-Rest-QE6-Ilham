Feature: Feature register to test reqres


  @Tugas @Positive @POST
  Scenario: Post Register success with valid json
    Given Post register success
    When Send request post register success
    Then Should return 200 OK
    And Post register success json schema validator

  @Tugas @Negative @POST
  Scenario Outline: Post Register without email
    Given Post Register without email
    When Send request post register without email
    Then Should return 400 Bad Request
    And Response body should show message "<error>"
    And Post register without email json schema validator
    Examples:
      |error                      |
      |Missing email or username  |

  @Tugas @Negative @POST
  Scenario Outline: Post Register without password
    Given Post Register without password
    When Send request post register without password
    Then Should return 400 Bad Request
    And Response body should show message "<error>"
    And Post register without password json schema validator
    Examples:
      |error             |
      |Missing password  |
