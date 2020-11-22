package no.kristiania.dragonballz.util

import no.kristiania.dragonballz.models.dto.DragonBallZDto
import no.kristiania.dragonballz.models.entity.DbzCharacterEntity

class DragonBallZConverter {

    companion object {

        fun convertFromDto(dragonBallZDto: DragonBallZDto): DbzCharacterEntity {
            return DbzCharacterEntity(
                    dragonBallZDto.characterName!!, dragonBallZDto.age, dragonBallZDto.powerLevel,
                    dragonBallZDto.transformationForms, dragonBallZDto.deathStrike
            )
        }

        fun convertFromDtoMap(dragonBallZDto: Iterable<DragonBallZDto>): List<DbzCharacterEntity> {
            return dragonBallZDto.map { convertFromDto(it) }
        }

        fun convertToDto(dbzCharacterEntity: DbzCharacterEntity) : DragonBallZDto {
            return DragonBallZDto(
                    dbzCharacterEntity.characterName,
                    dbzCharacterEntity.age,
                    dbzCharacterEntity.powerLevel,
                    dbzCharacterEntity.transformationForms,
                    dbzCharacterEntity.deathStrike,
                    dbzCharacterEntity.id.toString()
            )
        }

        fun convertToDtoList(dbzCharacterEntity: Iterable<DbzCharacterEntity>) : List<DragonBallZDto> {
            return dbzCharacterEntity.map { convertToDto(it) }
        }
    }

}