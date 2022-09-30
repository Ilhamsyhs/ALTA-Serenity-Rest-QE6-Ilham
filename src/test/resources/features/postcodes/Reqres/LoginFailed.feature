Feature: Feature login failed to test reqres
@Tugas @POST
Scenario Outline: Login unsuccessfull with invalid json
Given Post login unsuccess
When Send request post login unsuccess
Then Should return 400 Bad Request
And Response body should show message "<error>"
Examples:
|error            |
|Missing password |