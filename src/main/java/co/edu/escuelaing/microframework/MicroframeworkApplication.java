package co.edu.escuelaing.microframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.escuelaing.microframework.framework.MicroFramework;

@SpringBootApplication
public class MicroframeworkApplication {

    public static void main(String[] args) {

        MicroFramework.staticFiles("public");

        MicroFramework.get("/hello", (req, res) -> "hello world!");

        MicroFramework.get("/greet", (req, res) -> {
            String name = req.getValues("name");
            return "Hello " + name;
        });

        SpringApplication.run(MicroframeworkApplication.class, args);
    }
}