package co.edu.escuelaing.microframework.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import co.edu.escuelaing.microframework.handler.RestHandler;
import co.edu.escuelaing.microframework.handler.StaticFileHandler;

@RestController
public class DynamicController {

    @GetMapping("/**")
    public ResponseEntity<?> handle(HttpServletRequest request) throws IOException {

        String path = request.getRequestURI();

        if (RestHandler.hasRoute(path)) {
            return RestHandler.handle(request);
        }

        return StaticFileHandler.handle(path);
    }
}