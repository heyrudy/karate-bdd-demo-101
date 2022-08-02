Feature: Connection to a database

  Background:
    # Create JDBC connection with DbUtils java class
    * def config = {username: 'sa', password: 'sa', url: 'jdbc:h2:~/h2-db/testdb', driverClassName: 'org.hibernate.dialect.H2Dialect' }
    * def DbUtils = Java.type('features.dbstorageinteraction.util.DbUtils')
    * def db = new DbUtils(config)
    * db.insertRows("INSERT INTO COMMENT VALUES (1, 'Hello world, use Karate! :)')")
    * configure afterScenario = function(){ karate.call('after-scenario.feature'); }

  Scenario: Check db migration
    * def comments = db.readRows('SELECT * FROM COMMENT')
    Then match comments contains {ID:'#notnull', QUOTE:'#notnull'}
