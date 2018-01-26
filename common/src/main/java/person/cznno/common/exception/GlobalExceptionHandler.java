package person.cznno.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import person.cznno.common.dto.response.BaseResponse;
import person.cznno.common.dto.response.Response;
import person.cznno.common.enums.AuthStatusEnum;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 没有权限
     *
     * @param request HttpServletRequest
     * @param exception NoPermissionException
     * @return response
     */
    @ExceptionHandler(value = NoPermissionException.class)
    public Response allExceptionHandler(HttpServletRequest request, Exception exception){
        exception.printStackTrace();
        BaseResponse response = new BaseResponse();
        response.setSuccess(false);
        response.setMsg(AuthStatusEnum.PERMISSION_DENY.getMsg());
        return response;
    }
}