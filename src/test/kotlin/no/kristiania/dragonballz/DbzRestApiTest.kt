package no.kristiania.dragonballz

import io.restassured.RestAssured
import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import no.kristiania.dragonballz.models.dto.DragonBallZDto
import no.kristiania.dragonballz.repository.DragonBallZRepository
import no.kristiania.dragonballz.service.DragonBallZService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.junit.jupiter.SpringExtension
import javax.annotation.PostConstruct


@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DbzRestApiTest {

    @LocalServerPort
    protected var port = 0

    @Autowired
    protected lateinit var dragonBallZService: DragonBallZService

    @Autowired
    protected lateinit var dragonBallZRepository: DragonBallZRepository

    @PostConstruct
    fun init() {
        RestAssured.baseURI = "http://localhost"
        RestAssured.basePath = "/dragonballz"
        RestAssured.port = port
    }

    @BeforeEach
    fun cleanDB(){
        dragonBallZRepository.deleteAll()
    }

    @Test
    fun testCreateCharacter(){
        val dto = DragonBallZDto("Goku", "10","1000", "5", "6")
        given().contentType(ContentType.JSON)
                .body(dto)
                .post()
                .then()
                .statusCode(201)

    }

    @Test
    fun testGetAllCharacters(){

    }
}