package person.cznno.common.factory;

import person.cznno.common.dto.response.BaseResponse;
import person.cznno.common.dto.response.Response;
import person.cznno.common.enums.CrudStatusEnum;

import static person.cznno.common.util.VerifyUtil.isNullOrEmpty;

/**
 * Created by cznno
 * Date: 18-1-9
 */
public class CrudResponseFactory extends BaseResponseFactory {

    public static <T> Response get(CrudStatusEnum anEnum, T data) {

        BaseResponse<T> response = new BaseResponse<>();
        CrudStatusEnum resEnum = CrudStatusEnum.GENERAL_FAIL;
        Boolean success;

        success = !isNullOrEmpty(data) && !"0".equals(data.toString());

        switch (anEnum) {
            case SELECT:
                if (success)
                    resEnum = CrudStatusEnum.SELECT_SUCCESS;
                else
                    resEnum = CrudStatusEnum.SELECT_FAIL;
                break;
            case INSERT:
                if (success)
                    resEnum = CrudStatusEnum.INSERT_SUCCESS;
                else
                    resEnum = CrudStatusEnum.INSERT_FAIL;
                break;
            case UPDATE:
                if (success)
                    resEnum = CrudStatusEnum.UPDATE_SUCCESS;
                else
                    resEnum = CrudStatusEnum.UPDATE_FAIL;
                break;
            case DELETE:
                if (success)
                    resEnum = CrudStatusEnum.DELETE_SUCCESS;
                else
                    resEnum = CrudStatusEnum.DELETE_FAIL;
                break;
            default:
                break;
        }

        response.setMsg(resEnum.getMsg());
        response.setData(data);
        return response;
    }
}
