package person.cznno.admin.aop;

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
import person.cznno.common.enums.BaseStatusEnum;

import javax.servlet.http.HttpServletRequest;

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

    @Pointcut("execution(public * person.cznno.admin.controller..*(..))")
    public void controllerAspect() {}

    @Around("controllerAspect()")
    public Response handlerControllerMethod(ProceedingJoinPoint pjp) {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        log.info("收到请求:\n url: {}\n method: {}\n uri: {}\n params: {}",
                url, method, uri, queryString);

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

        BaseResponse result = new BaseResponse();
        result.setSuccess(false);

        // 可处理/已预料的异常
        result.setMsg(ExceptionHandler.foo(pjp, e));
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
