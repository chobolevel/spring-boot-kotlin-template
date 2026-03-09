package com.template.common.extension

import java.security.Principal
import java.time.OffsetDateTime

fun Principal.getUserId(): Long = this.name.toLong()

fun OffsetDateTime.toMillis(): Long = this.toInstant().toEpochMilli()
