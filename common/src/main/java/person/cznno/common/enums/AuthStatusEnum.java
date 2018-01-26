package person.cznno.common.enums;

import person.cznno.common.enums.BaseStatusEnum;

/**
 * 权限相关消息
 * Created by cznno
 * Date: 18-1-2
 */
public enum AuthStatusEnum implements BaseStatusEnum {

    LOGIN_SUCCESS(true, "登录成功"),
    LOGIN_FAIL_NOT_FOUND(false, "登录失败,账号不存在"),
    LOGIN_FAIL_NOT_MATCH(false, "登录失败,用户名密码错误"),
    PERMISSION_DENY(false, "没有权限"),
    REQUIRE_LOGIN(false, "没有登录或登陆已过期,请重新登陆"),
    LOGOUT_SUCCESS(true, "登出成功"),
    LOGOUT_FAIL(false, "登出失败"),
    REGISTER_SUCCESS(true, "注册成功"),
    REGISTER_FAIL(false, "注册失败"),
    REGISTER_REPEAT(false, "注册失败,用户重复");

    private final Boolean success;
    private final String msg;

    AuthStatusEnum(Boolean success, String msg) {
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