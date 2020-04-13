package error;

public class NativeStructBuildException extends Exception {

    public NativeStructBuildException(String message) {
        super(message);
    }

    public NativeStructBuildException(String message, Throwable err) {
        super(message, err);
    }

}
