package person.cznno.common.exception;


/**
 * Created by cznno
 * Date: 18-1-9
 */
public class CrudException extends RuntimeException {

    public CrudException() {
    }

    public CrudException(String message) {
        super(message);
    }

    public CrudException(Throwable cause) {
        super(cause);
    }

    public CrudException(String message, Throwable cause) {
        super(message, cause);
    }

    public CrudException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CrudException(CrudStatusEnum statusEnum) {
        super(statusEnum.getMsg());
    }

    public CrudException(CrudStatusEnum statusEnum, Throwable cause) {
        super(statusEnum.getMsg(), cause);
    }
}
