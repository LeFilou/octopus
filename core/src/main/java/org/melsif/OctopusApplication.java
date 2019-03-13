package org.melsif;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OctopusApplication {

    @Value("${config.database.username}")
    private String pseudoProperty;

    public static void main(String[] args) {
        SpringApplication.run(OctopusApplication.class, args);
    }

    @GetMapping("/property")
    public ResponseEntity<String> getProperty() {
        return ResponseEntity.ok(pseudoProperty);
    }

}