@Register

Feature: As an Internet user
  I want to register in Packlink Pro platform

  Background:
    Given an internet user on Firefox browser

  #HAPPY
  @Register-ValidateFields
  Scenario: Validate fields on register form
    When going to pro packlink register page
    Then it will see the registration form WITH required fields

  @Register-RegisterUser
  Scenario Outline: Register a user with valid values
    And going to pro packlink register page
    When registered WITH credentials
      | email   | phone   | password   | shipments   | platform   | ecomerce   |
      | <email> | <phone> | <password> | <shipments> | <platform> | <ecomerce> |
    Then shipments screen is loaded
    Examples:
      | email                       | phone     | password | shipments | platform | ecomerce  |
      | qacandidateMJ10@packlink.es | 999999999 | 123456   | 1-10      | Amazon   | pretaShop |
#      we can add other valid values
#      | xx | xx | xx   | xx      | xx   | xx |

 #UNHAPPY
  @Register-ExistentUser
  Scenario Outline: Register a user with an already registered user
    And going to pro packlink register page
    When registered WITH credentials
      | email   | phone   | password   | shipments   | platform   | ecomerce   |
      | <email> | <phone> | <password> | <shipments> | <platform> | <ecomerce> |
    Then an error message is displayed: "Client already exists"
    Examples:
      | email                       | phone     | password | shipments | platform | ecomerce  |
      | qacandidateMJ10@packlink.es | 999999999 | 123456   | 1-10      | Amazon   | pretaShop |

  @Register-NonValidPassword
  Scenario Outline: Register a user with non valid password
    And going to pro packlink register page
    When registered WITH credentials
      | email   | phone   | password   | shipments   | platform   | ecomerce   |
      | <email> | <phone> | <password> | <shipments> | <platform> | <ecomerce> |
    Then an error message is displayed: "Invalid value u'<password>' (unicode): must be at least 6 characters long (at password)"
    Examples:
      | email                       | phone     | password | shipments | platform | ecomerce  |
      | qacandidateMJ10@packlink.es | 999999999 | 123      | 1-10      | Amazon   | pretaShop |

    #in the scenario bellow validation is missing
  @Register-NonValidValues
  Scenario Outline: Register a user with non valid values <goal>
    And going to pro packlink register page
    When registered WITH credentials
      | email   | phone   | password   | shipments   | platform   | ecomerce   |
      | <email> | <phone> | <password> | <shipments> | <platform> | <ecomerce> |
    Examples:
      | goal                          | email                      | phone     | password | shipments | platform | ecomerce  |
      | Non valid value for email     | qacandidate MJ@packlink.es | 999999999 | 123456   | 1-10      | Amazon   | pretaShop |
      | empty value for email         | null                       | 999999999 | 123456   | 1-10      | Amazon   | pretaShop |
      | Non valid value for phone     | qacandidateMJ@packlink.es  | "·"$%%&/( | 123456   | 1-10      | Amazon   | pretaShop |
      | empty value for phone         | qacandidateMJ@packlink.es  | null      | 123456   | 1-10      | Amazon   | pretaShop |
      | Non valid value for password  | qacandidateMJ@packlink.es  | 999999999 | !"·$$&%  | 1-10      | Amazon   | pretaShop |
      | empty value for password      | qacandidateMJ@packlink.es  | 999999999 | null     | 1-10      | Amazon   | pretaShop |
      | Non valid value for shipments | qacandidateMJ@packlink.es  | 999999999 | 123      | qwe       | Amazon   | pretaShop |
      | empty value for shipments     | qacandidateMJ@packlink.es  | 999999999 | 123      | null      | Amazon   | pretaShop |
      | Non valid value for ecomerce  | qacandidateMJ@packlink.es  | 999999999 | 123      | 1-10      | qwe      | pretaShop |
      | empty value for ecomerce      | qacandidateMJ@packlink.es  | 999999999 | 123      | 1-10      | null     | pretaShop |