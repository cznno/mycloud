package person.cznno.common.enums;

/**
 * Created by cznno
 * Date: 18-1-26
 */
public enum RequestStatusEnum implements BaseStatusEnum {

    SUCCESS(true, "请求成功"),
    FAIL(false, "请求失败"),
    ERROR(false, "错误");

    private final Boolean success;
    private final String msg;

    RequestStatusEnum(Boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public Boolean isSuccess() {
        return success;
    }
}
