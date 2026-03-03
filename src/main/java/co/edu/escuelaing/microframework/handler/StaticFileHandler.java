package co.edu.escuelaing.microframework.handler;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

import co.edu.escuelaing.microframework.framework.MicroFramework;

public class StaticFileHandler {

    public static ResponseEntity<?> handle(String path) throws IOException {

        String staticFolder = MicroFramework.getStaticFolder();

        if (staticFolder == null) {
            return ResponseEntity.status(404).body("404 Not Found");
        }

        ClassPathResource resource =
                new ClassPathResource(staticFolder + path);

        if (!resource.exists()) {
            return ResponseEntity.status(404).body("404 Not Found");
        }

        return ResponseEntity.ok()
                .contentType(MediaType.TEXT_HTML)
                .body(resource.getInputStream().readAllBytes());
    }
}