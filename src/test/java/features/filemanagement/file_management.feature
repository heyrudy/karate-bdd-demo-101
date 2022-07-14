Feature: Uploading a file

  Background:
    * url baseUrl

  Scenario: Upload file

    Given path '/upload'
    And multipart file fileUpload = { read: 'classpath:features/filemanagement/test.txt', filename: 'test.txt' }
    When method POST
    Then status 200
    And match $ == {error: false, bytesUploaded:'#notnull'}

    Given path '/upload'
    And multipart file fileUpload = { read: 'classpath:features/filemanagement/test1.txt', filename: 'test1.txt' }
    When method POST
    Then status 200
    And match $ == {error: false, bytesUploaded:'#notnull'}


  Scenario: List uploaded files

    Given path '/files'
    When method GET
    Then status 200
    And match $.length() == 2
