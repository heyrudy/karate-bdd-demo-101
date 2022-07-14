package features.nametransformation;

import com.intuit.karate.junit5.Karate;

class NameTransformationIntegrationTest {

    @Karate.Test
    Karate testNamesTransformation() {
        return Karate.run("name_transformation").relativeTo(getClass());
    }
}
