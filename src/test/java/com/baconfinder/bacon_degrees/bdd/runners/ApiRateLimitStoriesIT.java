package com.baconfinder.bacon_degrees.bdd.runners;



import com.baconfinder.bacon_degrees.bdd.config.BaseStoriesIT;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles({"test", "rl"})
public class ApiRateLimitStoriesIT extends BaseStoriesIT {
    @Override protected List<String> metaFilters() { return List.of("+rateLimit"); }
}
