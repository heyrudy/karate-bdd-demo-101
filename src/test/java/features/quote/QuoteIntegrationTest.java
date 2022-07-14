package features.quote;

import com.intuit.karate.junit5.Karate;

class QuoteIntegrationTest {

    @Karate.Test
    Karate testQuotes() {
        return Karate.run("quote").relativeTo(getClass());
    }
}
