@Blibli
Feature: As a user, I want to register to Blibli.com

  Scenario Outline: User register on Blibli page and insert "<email>" and "<password>"
    Given user open blibli page
    When user click Daftar Button
    Then modal Daftar Akun Baru appeared
    When user enter "<email>" on input email
    When user enter "<password>" on input password
    When user click Daftar account Button
    Then user redirected to verify phone number Page
    When user click on Verifikasi Nanti
    Then check on user profile "<email>"
    Examples:
      | email | password |
      |ngungun@gmail.com|ngun123|
#      | jeng123@gmail.com | jeng123 |
#      | jengjeng123@gmail.com | jengjeng123 |
#      | jengjengjeng@gmail.com | jengjengjeng |