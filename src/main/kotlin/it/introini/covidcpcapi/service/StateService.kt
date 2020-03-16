package it.introini.covidcpcapi.service

import it.introini.covidcpcapi.model.AndamentoNazione
import java.time.LocalDate

interface StateService {
    fun getStateData(from: LocalDate?, to: LocalDate?): List<AndamentoNazione>
}