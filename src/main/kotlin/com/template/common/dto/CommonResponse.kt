package com.template.common.dto

import com.template.common.vo.ResultType

data class CommonResponse(
    val result: ResultType = ResultType.SUCCESS,
    val data: Any? = null,
)
