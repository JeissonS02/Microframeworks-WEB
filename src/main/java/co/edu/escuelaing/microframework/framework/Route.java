package co.edu.escuelaing.microframework.framework;

@FunctionalInterface
public interface Route {
    String handle(Request req, Response res);
}