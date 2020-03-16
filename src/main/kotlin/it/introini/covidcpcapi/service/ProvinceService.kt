package it.introini.covidcpcapi.service

import it.introini.covidcpcapi.model.AndamentoProvincia
import it.introini.covidcpcapi.model.AndamentoRegione
import java.time.LocalDate

interface ProvinceService {
    fun getProvinceData(regionName: String, provinceName: String, from: LocalDate?, to: LocalDate?): List<AndamentoProvincia>
}