package no.kristiania.dragonballz.controller

import io.micrometer.core.instrument.MeterRegistry
import io.micrometer.core.instrument.Tag
import no.kristiania.dragonballz.models.WrappedResponse
import no.kristiania.dragonballz.models.dto.DragonBallZDto
import no.kristiania.dragonballz.models.entity.DbzCharacterEntity
import no.kristiania.dragonballz.service.DragonBallZService
import no.kristiania.dragonballz.util.DragonBallZConverter
import no.kristiania.dragonballz.util.RestResponseFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.logging.Logger

@RequestMapping(
        path = ["/dragonballz"]
)

@RestController
class DragonBallZController {


    @Autowired
    private lateinit var dragonBallZService: DragonBallZService

    @Autowired
    private lateinit var registry: MeterRegistry

    private val logger: Logger = Logger.getLogger(this::class.java.name)


    @GetMapping("/characters")
    fun getAllCharacters(
    ): ResponseEntity<WrappedResponse<List<DragonBallZDto>>> {
        val result = DragonBallZConverter.convertToDtoList(dragonBallZService.getAll())
        registry.gaugeCollectionSize("retrieved.measurements.count", listOf(Tag.of("type", "collection")), result)
        logger.info("request for characters")
        return RestResponseFactory.payload(200, result)
    }

    @PostMapping
    fun postCharacters(@RequestBody dragonBallZDto: DragonBallZDto) : ResponseEntity<WrappedResponse<DragonBallZDto>> {
        val result = dragonBallZService.createCharacter(dragonBallZDto)
        logger.info("Received POST to /characters")

        return RestResponseFactory.payload(201, result!!)
    }

    @GetMapping(path = ["/{id}"])
    fun get(
            @PathVariable("id")
            id: String?) : ResponseEntity<WrappedResponse<Optional<DbzCharacterEntity>?>> {
        return RestResponseFactory.payload(200, dragonBallZService.findByCharacterId(id!!))
    }
}
