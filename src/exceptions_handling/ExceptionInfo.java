package exceptions_handling;

import java.time.LocalDateTime;

public class ExceptionInfo {

    private ExceptionCode exceptionCode;
    private String description;
    private LocalDateTime exceptionTime;

    public ExceptionInfo(ExceptionCode exceptionCode, String description) {
        this.exceptionCode = exceptionCode;
        this.description = description;
        this.exceptionTime = LocalDateTime.now();
    }

    public ExceptionCode getExceptionCode() {
        return exceptionCode;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getExceptionTime() {
        return exceptionTime;
    }

}
