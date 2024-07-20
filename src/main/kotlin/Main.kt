package org.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VehicleSaleApplication

fun main(args: Array<String>) {
    runApplication<VehicleSaleApplication>(*args)
}