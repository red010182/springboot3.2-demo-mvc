package com.example.demo

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.boot.with
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.oracle.OracleContainer
import org.testcontainers.utility.DockerImageName

@TestConfiguration(proxyBeanMethods = false)
class TestDemoApplication {

	@Bean
	@ServiceConnection
	fun oracleFreeContainer(): OracleContainer {
		return OracleContainer(DockerImageName.parse("gvenzl/oracle-free:latest"))
	}

}

fun main(args: Array<String>) {
	fromApplication<DemoApplication>().with(TestDemoApplication::class).run(*args)
}
