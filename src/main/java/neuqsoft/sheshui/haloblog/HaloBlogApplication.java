package neuqsoft.sheshui.haloblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * @author sheshui
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class HaloBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(HaloBlogApplication.class, args);
    }

}
