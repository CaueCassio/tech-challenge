package org.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

//fun main() {
//    val name = "Tech Challenger"
//    println("Hello, " + name + "!")
//
//}

@SpringBootApplication
class VehicleSaleApplication

fun main(args: Array<String>) {
    runApplication<VehicleSaleApplication>(*args)
}