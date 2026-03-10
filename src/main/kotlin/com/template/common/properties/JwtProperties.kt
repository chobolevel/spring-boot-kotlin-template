package com.template.common.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "jwt")
data class JwtProperties(
    val issuer: String,
    val secret: String,
    val cacheKey: String,
)
