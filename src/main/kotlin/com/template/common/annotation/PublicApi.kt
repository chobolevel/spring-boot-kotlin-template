package com.template.common.annotation

import org.springframework.security.access.prepost.PreAuthorize

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
@PreAuthorize("permitAll()")
annotation class PublicApi
