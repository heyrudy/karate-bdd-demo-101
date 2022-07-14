Feature: Quote generator

  Background:
    * url 'http://localhost:3000'

  Scenario: Fetch random quote

    Given path 'quote'
    When method GET
    Then status 200
    And match $ == {quote:'#notnull'}
