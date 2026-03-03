package co.edu.escuelaing.microframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.escuelaing.microframework.framework.MicroFramework;

@SpringBootApplication
public class MicroframeworkApplication {

    public static void main(String[] args) {

        MicroFramework.staticfiles("webroot");

        MicroFramework.get("/hello", (req, res) -> "Hello " + req.getValues("name"));

        MicroFramework.get("/pi", (req, res) -> String.valueOf(Math.PI));

        MicroFramework.get("/test", (req, res) -> "Framework working");

        MicroFramework.get("/sum", (req, res) -> {
            int a = Integer.parseInt(req.getValues("a"));
            int b = Integer.parseInt(req.getValues("b"));
            return "Sum = " + (a + b);
        });

        MicroFramework.get("/optional", (req, res) -> {
            String name = req.getValues("name");
            if (name == null) {
                return "No name provided";
            }
            return "Hello " + name;
        });

        MicroFramework.get("/square", (req, res) -> {
            int x = Integer.parseInt(req.getValues("x"));
            return "Square = " + (x * x);
        });

        MicroFramework.get("/custom", (req, res) -> {
            res.status(201);
            return "Created!";
        });

        SpringApplication.run(MicroframeworkApplication.class, args);
    }
}