Feature: Feature update user to test reqres

  @Latihan
  Scenario Outline: Put update user with valid json
    Given Put update user with id <id>
    When Send request put update user
    Then Should return 200 OK
    And Response body should contain name "Ilham Syah" and job "QA Edit"
    And Put update user json schema validator
    Examples:
      |id|
      |1 |
      |2 |

  @Tugas @Negative @PUT
  Scenario Outline: Put update user with invalid id
    Given Put update user with id "<id>"
    When Send request put update user
    Then Should return 400 Bad Request
    Examples:
      |id |
      |asa|
      |$#@|

  @Tugas @Negative @PUT
  Scenario Outline: Put update user without field name
    Given Put update user without field name on id <id>
    When Send request put update user without field name
    Then Should return 400 Bad Request
    Examples:
      |id|
      |1 |
      |2 |

  @Tugas @Negative @PUT
  Scenario Outline: Put update user without field job
    Given Put update user without field job on id <id>
    When Send request put update user without field job
    Then Should return 400 Bad Request
    Examples:
      |id|
      |1 |
      |2 |

  @Tugas @Negative @PUT
  Scenario Outline: Put update user with empty name
    Given Put update user with empty name on id <id>
    When Send request put update user with empty name
    Then Should return 400 Bad Request
    Examples:
      |id|
      |1 |
      |2 |

  @Tugas @Negative @PUT
  Scenario Outline: Put update user with empty job
    Given Put update user with empty job on id <id>
    When Send request put update user with empty job
    Then Should return 400 Bad Request
    Examples:
      |id|
      |1 |
      |2 |
