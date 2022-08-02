package features.dbstorageinteraction;

import com.intuit.karate.junit5.Karate;

class DbStorageConnectionIntegrationTest {

    @Karate.Test
    Karate testDbStorageConnection() {
        return Karate.run("db_storage_connection").relativeTo(getClass());
    }
}
