package features.filemanagement;

import com.intuit.karate.junit5.Karate;

class FileManagementIntegrationTest {

    @Karate.Test
    Karate testFilesManagement() {
        return Karate.run("file_management").relativeTo(getClass());
    }
}
