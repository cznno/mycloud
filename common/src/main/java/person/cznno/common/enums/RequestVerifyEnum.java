package person.cznno.common.enums;

/**
 * Created by cznno
 * Date: 18-1-9
 */
public enum RequestVerifyEnum implements BaseStatusEnum {

    PARAM_ERROR("请求的参数不合法", false);

    private final String msg;
    private final Boolean success;

    RequestVerifyEnum(String msg, Boolean success) {
        this.msg = msg;
        this.success = success;
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
