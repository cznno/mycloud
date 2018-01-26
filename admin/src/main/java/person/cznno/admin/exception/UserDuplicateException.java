package person.cznno.admin.exception;

import person.cznno.common.exception.CheckException;

/**
 * Created by cznno
 * Date: 18-1-9
 */
public class UserDuplicateException extends CheckException {
    public UserDuplicateException() {
    }

    public UserDuplicateException(String message) {
        super(message);
    }

    public UserDuplicateException(Throwable cause) {
        super(cause);
    }

    public UserDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
