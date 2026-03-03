package co.edu.escuelaing.microframework.framework;

import java.util.HashMap;
import java.util.Map;

public class MicroFramework {

    private static Map<String, Route> getRoutes = new HashMap<>();
    private static String staticFolder;

    public static void get(String path, Route route) {
        getRoutes.put(path, route);
    }

    public static Route getRoute(String path) {
        return getRoutes.get(path);
    }

    public static void staticFiles(String folder) {
        staticFolder = folder;
    }

    public static String getStaticFolder() {
        return staticFolder;
    }
}