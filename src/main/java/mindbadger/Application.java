package mindbadger;


import java.util.HashMap;
import java.util.Map;

import io.crnk.core.engine.registry.RegistryEntry;
//import io.crnk.core.engine.registry.ResourceRegistry;
//import io.crnk.spring.boot.v3.CrnkConfigV3;
import mindbadger.configuration.CorsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Configuration
@RestController
@SpringBootApplication(scanBasePackages="**/mindbadger/**/*")
@Import({CorsConfig.class})
//@Import({CrnkConfigV3.class})
public class Application {

	/*
	 * FOR SOME REASON THIS APP HAS TO BE IN THE mindbadger ROOT PACKAGE, OTHERWISE THE
	 * ECLIPSELINK COMPONENTS DON'T AUTO LOAD
	 */
//    @Autowired
//    private ResourceRegistry resourceRegistry;
//
//    @SuppressWarnings("deprecation")
//	@RequestMapping("/resources-info")
//    public Map<?, ?> getResources() {
//        Map<String, String> result = new HashMap<>();
//        // Add all resources (i.e. Project and Task)
//        for (RegistryEntry entry : resourceRegistry.getResources()) {
//            result.put(entry.getResourceInformation().getResourceType(),
//                resourceRegistry.getResourceUrl(entry.getResourceInformation()));
//        }
//        return result;
//    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
