package com.template.common.exception

import com.template.common.dto.ErrorResponse
import com.template.common.vo.ErrorCode
import jakarta.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {
    private val logger = LoggerFactory.getLogger(this::class.java)

    @ExceptionHandler(InvalidParameterException::class)
    fun invalidParameterExceptionHandler(e: InvalidParameterException): ResponseEntity<ErrorResponse> =
        ResponseEntity.status((HttpStatus.BAD_REQUEST)).body(
            ErrorResponse.of(
                errorCode = e.errorCode,
                message = e.message,
            ),
        )

    @ExceptionHandler(PolicyViolationException::class)
    fun policyViolationExceptionHandler(e: PolicyViolationException): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ErrorResponse.of(
                errorCode = e.errorCode,
                message = e.message,
            ),
        )

    @ExceptionHandler(UnauthorizedException::class)
    fun unauthorizedExceptionHandler(e: UnauthorizedException): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
            ErrorResponse.of(
                errorCode = e.errorCode,
                message = e.message,
            ),
        )

    @ExceptionHandler(ForbiddenException::class)
    fun forbiddenExceptionHandler(e: ForbiddenException): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.FORBIDDEN).body(
            ErrorResponse.of(
                errorCode = e.errorCode,
                message = e.message,
            ),
        )

    @ExceptionHandler(DataNotFoundException::class)
    fun dataNotFoundException(e: DataNotFoundException): ResponseEntity<ErrorResponse> =
        ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
            ErrorResponse.of(
                errorCode = e.errorCode,
                message = e.message,
            ),
        )

    @ExceptionHandler(Exception::class)
    fun handle(
        request: HttpServletRequest,
        e: Exception,
    ): ResponseEntity<ErrorResponse> {
        logger.error("[(${request.method}) ${request.requestURL} ] Internal server error: ${e.message}", e)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
            ErrorResponse.of(
                errorCode = ErrorCode.INTERNAL_SERVER_ERROR,
                message = "서버 에러 발생 나중에 다시 시도해주세요.",
            ),
        )
    }
}
