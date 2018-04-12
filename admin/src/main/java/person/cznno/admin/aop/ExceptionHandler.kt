package person.cznno.admin.aop

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException
import org.apache.http.auth.AuthenticationException
import org.aspectj.lang.ProceedingJoinPoint
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import person.cznno.admin.service.ErrorHandlerService
import person.cznno.common.enums.AuthStatusEnum
import person.cznno.common.enums.CrudStatusEnum
import person.cznno.common.enums.RequestVerifyEnum
import person.cznno.common.exception.CrudException
import person.cznno.common.exception.NoPermissionException
import person.cznno.common.exception.ParamErrorException
import java.io.PrintWriter
import java.io.StringWriter

/**
 * Created by cznno
 * Date: 18-3-27
 */
@Component
object ExceptionHandler {

    private val logger = LoggerFactory.getLogger(ExceptionHandler::class.java)

    @Autowired
    private lateinit var errorHandler: ErrorHandlerService

    @JvmStatic
    fun foo(pjp: ProceedingJoinPoint, e: Throwable): String? {
        when (e) {
            is AuthenticationException -> return AuthStatusEnum.LOGIN_FAIL_NOT_MATCH.msg
            is NoPermissionException -> return AuthStatusEnum.PERMISSION_DENY.msg
            is ParamErrorException -> return RequestVerifyEnum.PARAM_ERROR.msg
            is CrudException -> return e.message
        }
        when (e.cause) {
            is MySQLIntegrityConstraintViolationException -> return CrudStatusEnum.DELETE_FAIL_CONSTRAINT.msg
        }
        logger.error("未知的异常: " + pjp.signature + " error ", e)
        sendMail(e)
        return "系统错误, 请稍后再试"
    }

    private fun sendMail(e: Throwable) {
        val w = StringWriter()
        val pw = PrintWriter(w)
        e.printStackTrace(pw)
        errorHandler.alertMail(w.toString())
    }
}

