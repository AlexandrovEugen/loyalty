package com.evg

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class Boot

fun main(args: Array<String>){
    runApplication<Boot>(*args)
}

