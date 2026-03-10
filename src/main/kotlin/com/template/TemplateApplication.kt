package com.template

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = ["com.template.properties"])
class TemplateApplication

fun main(args: Array<String>) {
    runApplication<TemplateApplication>(*args)
}
