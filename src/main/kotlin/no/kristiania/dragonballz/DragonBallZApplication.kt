package no.kristiania.dragonballz

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class DragonBallZApplication{}

fun main(args: Array<String>) {
    SpringApplication.run(DragonBallZApplication::class.java, "--spring.profiles.active=production")
}