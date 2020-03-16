package it.introini.covidcpcapi.controller

import it.introini.covidcpcapi.model.AndamentoRegione
import it.introini.covidcpcapi.service.RegionService
import org.slf4j.LoggerFactory
import org.springframework.data.repository.query.Param
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import javax.inject.Inject
import javax.ws.rs.PathParam

@RestController
class RegionDataController {

    private val log = LoggerFactory.getLogger(RegionDataController::class.java)

    @Inject lateinit var regionService: RegionService

    @GetMapping(
        value = ["/italy/regions/{regionName}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getRegionData(@PathVariable("regionName") regionName: String, @Param("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) from: LocalDate?, @Param("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) to: LocalDate?): List<AndamentoRegione> {
        log.info("Request for region data: $regionName [$from, $to]")
        return regionService.getRegionData(regionName, from, to)
    }
}