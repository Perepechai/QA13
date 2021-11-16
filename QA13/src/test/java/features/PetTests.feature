#Feature: User API tests
#
#
#  Scenario Outline: Verify ability to remove existing user from the system
#    Given create new user with firstName "<firstName>", lastName "<lastName>", userName "<userName>"
#    When a client deletes a user with "<userName>" from the system
#    Then verify that user with "<userName>" has been deleted
#
#    Examples:
#      | firstName | userName     | lastName |
#      | Nikita    | qwqwqwqwqw12 | csdcsdc  |
#      | James     | cmvbcmv      | sdvsdvcd |
Feature: Pet API tests


  Scenario Outline: Verify ability to remove existing pet from the system
    Given create new pet with name "<name>", status "<status>"
    When a client deletes a pet with "<name>" from the system
    Then verify that pet with "<name>" has been deleted

    Examples:
      | name      | status     |
      | Biba      | available  |
      | Boba      | available  |