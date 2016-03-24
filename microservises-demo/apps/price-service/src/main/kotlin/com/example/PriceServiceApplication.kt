package com.example

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.cloud.netflix.hystrix.EnableHystrix
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
open class PriceServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(PriceServiceApplication::class.java, *args)
}

@RefreshScope
@RestController
open class PriceController {

    @Value("\${holidays.rate.factor}")
    open var factor: Double = 1.0;

    @HystrixCommand(fallbackMethod = "defaultPrices")
    @RequestMapping
    open fun prices(): Map<String, Double> {
        return mapOf("iPhone" to 799.99, "macbook" to 1599.99)
                .mapValues { it.value * factor }
    }

    open fun defaultPrices(): Map<String, Double> {
        return mapOf()
    }
}
