package com.template.common.dto

import com.template.common.vo.ResultType

data class PaginationResponse(
    val result: ResultType? = ResultType.SUCCESS,
    val page: Long,
    val size: Long,
    val totalCount: Long,
    val data: Any,
)
