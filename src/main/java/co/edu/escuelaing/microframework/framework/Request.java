package co.edu.escuelaing.microframework.framework;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private String path;
    private Map<String, String> queryParams = new HashMap<>();

    public Request(String path, Map<String, String[]> parameterMap) {
        this.path = path;

        if (parameterMap != null) {
            for (String key : parameterMap.keySet()) {
                queryParams.put(key, parameterMap.get(key)[0]);
            }
        }
    }

    public String getPath() {
        return path;
    }

    public String queryParam(String key) {
        return queryParams.get(key);
    }
}