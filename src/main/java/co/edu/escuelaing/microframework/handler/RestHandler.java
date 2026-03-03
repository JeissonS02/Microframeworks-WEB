package co.edu.escuelaing.microframework.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

import co.edu.escuelaing.microframework.framework.MicroFramework;
import co.edu.escuelaing.microframework.framework.Request;
import co.edu.escuelaing.microframework.framework.Response;
import co.edu.escuelaing.microframework.framework.Route;

public class RestHandler {

    public static boolean hasRoute(String path) {
        return MicroFramework.getRoute(path) != null;
    }

    public static ResponseEntity<?> handle(HttpServletRequest httpRequest) {

        String path = httpRequest.getRequestURI();
        Route route = MicroFramework.getRoute(path);

        if (route == null) {
            return ResponseEntity.status(404).body("404 Not Found");
        }

        Request req = new Request(path, httpRequest.getParameterMap());
        Response res = new Response();

        String result = route.handle(req, res);

        return ResponseEntity
                .status(res.getStatus())
                .header("Content-Type", res.getContentType())
                .body(result);
    }
}