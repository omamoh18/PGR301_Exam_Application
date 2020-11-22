package no.kristiania.dragonballz.util

import no.kristiania.dragonballz.service.DragonBallZService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class DefaultData {

    @Autowired
    private lateinit var dragonBallZService: DragonBallZService

    @PostConstruct
    fun initializeDefault() {
        dragonBallZService.run {
            createEntity("Goku", "30", "9000", "5", "10")
            createEntity("Vegeta", "40", "20000", "3", "2")
            createEntity("Buu", "1000", "unknown", "0", "0")
            createEntity("Krillin", "10", "1000", "0", "1")
            createEntity("Whis", "1millionYearsOld", "unknown", "5", "0")
            createEntity("Gohan", "20", "9000", "2", "2")
        }
    }
}