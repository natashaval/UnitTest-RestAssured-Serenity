#@Regression
#  tag di atas feature, berarti ada di setiap scenario, lalu bisa dimasukkin ke cucumberSteps tags = ""
#  nama tag nya terserah
Feature: As a user, I want to test selenium easy
#  https://www.seleniumeasy.com/test/
#  1 feature, bisa banyak skenario
#  1 skenario, bisa banyak steps
#  Tag memberi penanda untuk skenario tertentu yang ingin dijalankan
# yang dalam petik " nanti jadi variable

#  background akan dijalankan sebelum setiap scenario
  Background: User on selenium easy homepage
    Given user open selenium easy homepage
    When user click button Start Practising

  Scenario: User go to form demo and try to input something
    When user click on "Simple Form Demo" on homepage
    Then user should on simple form demo page
    When user type "Hello World!" on message
    When user click on Show Message
    Then user should able to see "Hello World!" message

  @Regression
  Scenario Outline: User go to Select List demo and try to test day "<day>"
    When user click on "Select Dropdown List" on homepage
    Then user should on simple select demo page
    When user select "<day>" on select demo
    Then user should be able to see "<day>" on select page
    # sekali tulis bisa nyoba sebanyak yang ada di example
    # ini efisien jika ada beberapa form dan mencoba validasi (mungkin) jadi kosong, terisi, error
    Examples:
      | day |
      | Sunday |
      | Monday |
      | Tuesday |
      | Wednesday |
      | Thursday |
      | Friday |
      | Saturday |