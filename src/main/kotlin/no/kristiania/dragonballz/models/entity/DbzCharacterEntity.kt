package no.kristiania.dragonballz.models.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.Size

@Entity
class DbzCharacterEntity (

        @get:Size(max = 128)
        var characterName: String? = null,

        @get:Size(max = 100)
        var age: String? = null,

        @get:Size(max = 2048)
        var powerLevel: String? = null,

        @get:Size(max = 2048)
        var  transformationForms: String? = null,

        @get:Size(max = 2048)
        var  deathStrike: String? = null,

        @get:Id
        @get:GeneratedValue
        var id: Long? = null
)