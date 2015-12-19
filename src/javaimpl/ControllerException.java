package javaimpl;

public class ControllerException extends RuntimeException {
    private final Integer responseCode;

    public Integer getResponseCode() {
        return responseCode;
    }

    public ControllerException(Integer responseCode) {
        this.responseCode = responseCode;
    }
}
