Feature: Feature delete to test reqres


  @Latihan
  Scenario Outline: Delete user with valid id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Should return 204 No Content
    Examples:
      |id|
      |1 |
      |2 |

  @Tugas @Negative @DELETE
  Scenario Outline: Delete user with invalid id
    Given Delete user with invalid id "<id>"
    When Send request delete user
    Then Should return 400 Bad Request
    Examples:
      |id|
      |asa|