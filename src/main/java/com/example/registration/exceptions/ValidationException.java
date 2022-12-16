package zw.co.afrosoft.epayments.exceptions;

import java.time.ZonedDateTime;

public class ValidationException {
    private final String message;
    public ValidationException(String message)

    {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}
