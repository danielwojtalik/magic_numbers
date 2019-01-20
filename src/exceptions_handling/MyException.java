package exceptions_handling;

public class MyException extends RuntimeException { // I don't want MyException are checked, cause extends RuntimeException

    private ExceptionInfo exceptionInfo;

    public MyException(ExceptionCode exceptionCode, String description) {

        this.exceptionInfo = new ExceptionInfo(exceptionCode, description);
    }

    public ExceptionInfo getExceptionInfo() {
        return exceptionInfo;
    }
}
