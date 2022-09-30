Feature: Feature create new user to test reqres

  @Latihan
  Scenario: Post create new user with valid json
    Given Post create new user
    When Send request post create new user
    Then Should return 201 created
    And Response body should contain name "Ilham Syahrul" and job "Junior QA"
    And Post create new user json schema validator

  @Tugas @Negative @POST
  Scenario: Post create new user without field name
    Given Post create new user without field name
    When Send request post create new user without field name
    Then Should return 400 Bad Request

  @Tugas @Negative @POST
  Scenario: Post create new user without field job
    Given Post create new user without field job
    When Send request post create new user without field job
    Then Should return 400 Bad Request

  @Tugas @Negative @POST
  Scenario: Post create new user with empty name
    Given Post create new user with empty name
    When Send request post create new user with empty name
    Then Should return 400 Bad Request

  @Tugas @Negative @POST
  Scenario: Post create new user with empty job
    Given Post create new user with empty job
    When Send request post create new user with empty job
    Then Should return 400 Bad Request