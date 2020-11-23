package no.kristiania.dragonballz.service

import no.kristiania.dragonballz.models.dto.DragonBallZDto
import no.kristiania.dragonballz.models.entity.DbzCharacterEntity
import no.kristiania.dragonballz.repository.DragonBallZRepository
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*

@Service("DragonBallZService")
class DragonBallZService(
        val dragonBallZRepository: DragonBallZRepository
) {

    fun createCharacter(dragonBallZDto: DragonBallZDto): DragonBallZDto? {
        val dragonBallZ = DbzCharacterEntity()
        dragonBallZ.apply {
            this.characterName = dragonBallZDto.characterName
            this.age = dragonBallZDto.age
            this.powerLevel = dragonBallZDto.powerLevel
            this.transformationForms = dragonBallZDto.transformationForms
            this.deathStrike = dragonBallZDto.deathStrike
        }
        if (dragonBallZRepository.existsByCharacterName(dragonBallZDto.characterName)) return null
        dragonBallZRepository.save(dragonBallZ)
        return dragonBallZDto
    }

    fun createEntity(characterName: String,age: String, powerLevel: String, transformationForms: String,deathStrike: String): ResponseEntity<Void> {
        val dragonBallZ = DbzCharacterEntity(characterName, age, powerLevel, transformationForms, deathStrike)
        if (dragonBallZRepository.existsByCharacterName(characterName)) return ResponseEntity.badRequest().build()
        dragonBallZRepository.save(dragonBallZ)
        return ResponseEntity.ok().build()
    }

    fun getAll(): MutableIterable<DbzCharacterEntity> {
        return dragonBallZRepository.findAll()
    }

    fun findByCharacterId(id: String): Optional<DbzCharacterEntity>? {
        if (!dragonBallZRepository.existsById(id.toLong())) return null
        return dragonBallZRepository.findById(id.toLong())

    }


}