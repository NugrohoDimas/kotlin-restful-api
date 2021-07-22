package its.nugroho.kotlin.restful.controller

import its.nugroho.kotlin.restful.error.NotFoundException
import its.nugroho.kotlin.restful.error.UnauthorizedException
import its.nugroho.kotlin.restful.model.WebResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.validation.ConstraintViolationException

@RestControllerAdvice
class ErrorController {
    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): WebResponse<String?> {
        return WebResponse(
                code = 400,
                status = "BAD REQUEST",
                data = constraintViolationException.message
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFoundHandler(notFoundException: NotFoundException): WebResponse<String?> {
        return WebResponse(
                code = 404,
                status = "NOT FOUND",
                data = "Not Found"
        )
    }

    @ExceptionHandler(value = [UnauthorizedException::class])
    fun unauthorized(unauthorizedException: UnauthorizedException): WebResponse<String?> {
        return WebResponse(
                code = 401,
                status = "UNAUTHORIZED",
                data = "Put your API key"
        )
    }
}
