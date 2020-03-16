package it.introini.covidcpcapi.controller

import it.introini.covidcpcapi.model.AndamentoNazione
import it.introini.covidcpcapi.service.StateService
import org.slf4j.LoggerFactory
import org.springframework.data.repository.query.Param
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import javax.inject.Inject

@RestController
class StateDataController {

    private val log = LoggerFactory.getLogger(StateDataController::class.java)

    @Inject private lateinit var stateService: StateService

    @GetMapping(
        value = ["/italy"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getStateData(@Param("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) from: LocalDate?, @Param("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) to: LocalDate?): List<AndamentoNazione> {
        log.info("Request for state data: [$from, $to]")
        return stateService.getStateData(from, to)
    }
}