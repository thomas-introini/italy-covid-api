package it.introini.covidcpcapi.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.google.cloud.Timestamp
import it.introini.covidcpcapi.annotation.NoArgsConstructor

@NoArgsConstructor
data class AndamentoNazione(
    val data: String,
    val stato: String,
    val ricoverati_con_sintomi: Int,
    val terapia_intensiva: Int,
    val totale_ospedalizzati: Int,
    val isolamento_domiciliare: Int,
    val totale_attualmente_positivi: Int,
    val nuovi_attualmente_positivi: Int,
    val dimessi_guariti: Int,
    val deceduti: Int,
    val totale_casi: Int,
    val tamponi: Int,
    @JsonIgnore
    val timestamp: Timestamp
)

@NoArgsConstructor
data class AndamentoRegione(
    val data: String,
    val stato: String,
    val codice_regione: Int,
    val denominazione_regione: String,
    val ricoverati_con_sintomi: Int,
    val terapia_intensiva: Int?,
    val totale_ospedalizzati: Int,
    val isolamento_domiciliare: Int,
    val totale_attualmente_positivi: Int,
    val nuovi_attualmente_positivi: Int,
    val dimessi_guariti: Int,
    val deceduti: Int,
    val totale_casi: Int,
    val tamponi: Int,
    val lat: Double,
    val long: Double,
    @JsonIgnore
    val timestamp: Timestamp
)

@NoArgsConstructor
data class AndamentoProvincia(
    val data: String,
    val stato: String,
    val codice_regione: Int,
    val denominazione_regione: String,
    val codice_provincia: Int,
    val denominazione_provincia: String,
    val sigla_provincia: String,
    val lat: Double,
    val long: Double,
    val totale_casi: Int,
    @JsonIgnore
    val timestamp: Timestamp
)