package person.cznno.admin.aop;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import person.cznno.admin.service.ErrorHandlerService;
import person.cznno.common.dto.response.BaseResponse;
import person.cznno.common.dto.response.Response;
import person.cznno.common.enums.AuthStatusEnum;
import person.cznno.common.enums.BaseStatusEnum;
import person.cznno.common.enums.CrudStatusEnum;
import person.cznno.common.enums.RequestVerifyEnum;
import person.cznno.common.exception.CrudException;
import person.cznno.common.exception.NoPermissionException;
import person.cznno.common.exception.ParamErrorException;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/**
 * 所有controller的切面
 * 记录日志及异常处理
 * Created by cznno
 * Date: 18-1-3
 */
@Aspect
@Component
@Slf4j
@Order(1)
public class ControllerAspect {

    private final ErrorHandlerService errorHandler;

    @Autowired
    public ControllerAspect(ErrorHandlerService errorHandler) {this.errorHandler = errorHandler;}

    @Pointcut("execution(public * person.cznno.admin.controller..*(..))")
    public void controllerAspect() {}

    @Around("controllerAspect()")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) {

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        log.info("收到请求:\n url: {}\n method: {}\n uri: {}\n params: {}", url, method, uri, queryString);

        long startTime = System.currentTimeMillis();

        Response result;

        try {
            result = (Response) pjp.proceed();
            log.info(pjp.getSignature() + "use time:" + (System.currentTimeMillis() - startTime));
        } catch (Throwable e) {
            result = handlerException(pjp, e);
        }
        return result;
    }

    private Response handlerException(ProceedingJoinPoint pjp, Throwable e) {

        BaseResponse result;

        // 已知异常
        if (e instanceof AuthenticationException) {
            result = getResult(AuthStatusEnum.LOGIN_FAIL_NOT_MATCH, e);
        } else if (e instanceof NoPermissionException) {
            result = getResult(AuthStatusEnum.PERMISSION_DENY, e);
        } else if (e instanceof ParamErrorException) {
            result = getResult(RequestVerifyEnum.PARAM_ERROR, e);
        } else if (e instanceof CrudException) {
            result = getResult(e.getLocalizedMessage(), e);
        } else if (e.getCause() instanceof MySQLIntegrityConstraintViolationException) {
            result = getResult(CrudStatusEnum.DELETE_FAIL_CONSTRAINT, e);
        } else {
            Writer w = new StringWriter();
            PrintWriter pw = new PrintWriter(w);
            e.printStackTrace(pw);
            errorHandler.hello(w.toString());
            log.error("未知的异常" + pjp.getSignature() + " error ", e);
            result = new BaseResponse();
            result.setSuccess(false);
            result.setMsg("系统错误, 请稍后再试");
//            result.setMsg(e.toString());
        }
        return result;
    }

    private BaseResponse getResult(BaseStatusEnum statusEnum, Throwable e) {
        BaseResponse result = new BaseResponse();
        result.setSuccess(false);
        result.setMsg(statusEnum.getMsg());
//        log.error("发生异常: " + e.getLocalizedMessage());
        return result;
    }

    private BaseResponse getResult(String msg, Throwable e) {
        BaseResponse result = new BaseResponse();
        result.setSuccess(false);
        result.setMsg(msg);
//        log.error("发生异常: " + e.getLocalizedMessage());
        return result;
    }
}
