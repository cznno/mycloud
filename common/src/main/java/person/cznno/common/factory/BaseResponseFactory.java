package person.cznno.common.factory;

import person.cznno.common.dto.response.BaseResponse;
import person.cznno.common.dto.response.Response;
import person.cznno.common.enums.BaseStatusEnum;

/**
 * 基础返回消息工厂
 * Created by cznno
 * Date: 17-12-28
 */
public class BaseResponseFactory {

    public static<T> Response get(BaseStatusEnum anEnum, T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setSuccess(anEnum.isSuccess());
        response.setMsg(anEnum.getMsg());
        response.setData(data);
        return response;
    }

    public static Response get(BaseStatusEnum anEnum) {
        BaseResponse response = new BaseResponse();
        response.setSuccess(anEnum.isSuccess());
        response.setMsg(anEnum.getMsg());
        return response;
    }

    public static<T> Response get(Boolean success, String msg, T data) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setSuccess(success);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }

    public static Response get(Boolean success, String msg) {
        BaseResponse response = new BaseResponse();
        response.setSuccess(success);
        response.setMsg(msg);
        return response;
    }
}
