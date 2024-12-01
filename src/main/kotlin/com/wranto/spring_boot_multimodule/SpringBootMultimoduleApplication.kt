package com.wranto.spring_boot_multimodule

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootMultimoduleApplication

fun main(args: Array<String>) {
	runApplication<SpringBootMultimoduleApplication>(*args)
}
