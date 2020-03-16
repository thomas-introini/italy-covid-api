package it.introini.covidcpcapi.service

import it.introini.covidcpcapi.model.AndamentoRegione
import java.time.LocalDate

interface RegionService {
    fun getRegionData(regionName: String, from: LocalDate?, to: LocalDate?): List<AndamentoRegione>
}