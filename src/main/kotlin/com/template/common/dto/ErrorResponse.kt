package com.template.common.dto

import com.template.common.vo.ErrorCode
import com.template.common.vo.ResultType

data class Error(
    val errorCode: ErrorCode,
    val message: String,
)

data class ErrorResponse(
    val result: ResultType,
    val error: Error,
) {
    companion object {
        fun of(
            result: ResultType = ResultType.FAIL,
            errorCode: ErrorCode,
            message: String,
        ): ErrorResponse =
            ErrorResponse(
                result = result,
                error =
                    Error(
                        errorCode = errorCode,
                        message = message,
                    ),
            )
    }
}
