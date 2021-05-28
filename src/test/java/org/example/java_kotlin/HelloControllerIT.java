package org.example.java_kotlin;

import org.junit.jupiter.api.BeforeEach;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.net.URL;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloControllerIT {

    private final static Logger LOGGER = LoggerFactory.getLogger(HelloControllerIT.class);

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws Exception {
        LOGGER.info("==== port: " + port + " ====");
        this.base = new URL("http://localhost:" + port + "/");
    }

//    @Test
//    public void getHello() throws Exception {
//        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
//        assertThat(response.getBody()).isEqualTo("Greetings from Spring Boot!");
//    }
}
