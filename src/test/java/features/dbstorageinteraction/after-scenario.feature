@ignore
Feature: Database cleaning
  Scenario: clean the database before each scenario begins
    #Create JDBC connection with DbUtils java class
    * def config = {username: 'sa', password: 'sa', url: 'jdbc:h2:~/h2-db/testdb', driverClassName: 'org.hibernate.dialect.H2Dialect' }
    * def DbUtils = Java.type('features.dbstorageinteraction.util.DbUtils')
    * def db = new DbUtils(config)
    * db.cleanDatatable("TRUNCATE TABLE COMMENT")
