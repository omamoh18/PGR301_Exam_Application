package no.kristiania.dragonballz.repository

import no.kristiania.dragonballz.models.entity.DbzCharacterEntity
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DragonBallZRepository : CrudRepository<DbzCharacterEntity, Long> {

    fun findByCharacterName(characterName: String): Iterable<DbzCharacterEntity>

    fun findAllByCharacterNameContainingIgnoreCase(characterName: String): Iterable<DbzCharacterEntity>

    fun existsByCharacterName(characterName: String?): Boolean


    override fun findById(id: Long): Optional<DbzCharacterEntity>

}