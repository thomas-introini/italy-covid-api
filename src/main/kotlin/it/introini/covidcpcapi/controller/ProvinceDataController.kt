package it.introini.covidcpcapi.controller

import it.introini.covidcpcapi.model.AndamentoProvincia
import it.introini.covidcpcapi.model.AndamentoRegione
import it.introini.covidcpcapi.service.ProvinceService
import org.slf4j.LoggerFactory
import org.springframework.data.repository.query.Param
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import javax.inject.Inject

@RestController
class ProvinceDataController {
    private val log = LoggerFactory.getLogger(ProvinceDataController::class.java)

    @Inject private lateinit var provinceService: ProvinceService

    @GetMapping(
        value = ["/italy/regions/{regionName}/provinces/{provinceName}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getProvinceData(@PathVariable("regionName") regionName: String, @PathVariable("provinceName") provinceName: String, @Param("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) from: LocalDate?, @Param("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) to: LocalDate?): List<AndamentoProvincia> {
        log.info("Request for province data: $regionName -> $provinceName [$from, $to]")
        return provinceService.getProvinceData(regionName, provinceName, from, to)
    }
}