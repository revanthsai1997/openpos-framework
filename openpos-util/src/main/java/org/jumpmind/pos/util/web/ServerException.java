package org.jumpmind.pos.util.web;

public class ServerException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ServerException() {
        super();
    }
    public ServerException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServerException(String message) {
        super(message);
    }

    public ServerException(Throwable cause) {
        super(cause);
    }

}
