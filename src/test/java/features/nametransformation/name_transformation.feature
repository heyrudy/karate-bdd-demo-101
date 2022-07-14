Feature: Name transformation

  Background:
    * url 'http://localhost:3000'

  Scenario Outline: Transform multiple names

    Given path '/name'
    And request {name:'<name>'}
    When method POST
    Then status 200
    And match $ == {length:'<length>'}

    Examples:
      | name  | length |
      | Tim   | 3      |
      | Liz   | 3      |
      | Selma | 5      |
      | Ted   | 3      |
      | Luise | 5      |
