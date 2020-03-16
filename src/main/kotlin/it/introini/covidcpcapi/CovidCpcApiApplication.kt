package it.introini.covidcpcapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CovidCpcApiApplication

fun main(args: Array<String>) {
	runApplication<CovidCpcApiApplication>(*args)
}
