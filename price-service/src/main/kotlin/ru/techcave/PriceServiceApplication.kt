package ru.techcave

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
@EnableDiscoveryClient
class PriceServiceApplication

fun main(args: Array<String>) {
    SpringApplication.run(PriceServiceApplication::class.java, *args)
}

@RestController
open class PriceController {

    @RequestMapping("/")
    open fun prices() : Map<String, Double> {
        return mapOf("iPhone" to 788.99, "macbook" to 1599.99)
    }
}
