package co.edu.escuelaing.microframework.framework;

public class Response {

    private int status = 200;
    private String contentType = "text/plain";

    public int getStatus() {
        return status;
    }

    public String getContentType() {
        return contentType;
    }

    public void status(int status) {
        this.status = status;
    }

    public void type(String type) {
        this.contentType = type;
    }
}