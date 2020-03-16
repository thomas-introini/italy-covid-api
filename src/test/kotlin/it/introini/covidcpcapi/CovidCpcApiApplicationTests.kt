package it.introini.covidcpcapi

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Profile
import org.springframework.test.context.ActiveProfiles

@SpringBootTest
@ActiveProfiles("test")
class CovidCpcApiApplicationTests {

	@Test
	fun contextLoads() {
	}

}
