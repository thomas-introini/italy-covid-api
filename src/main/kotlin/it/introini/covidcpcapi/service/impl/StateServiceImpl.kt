package it.introini.covidcpcapi.service.impl

import com.google.cloud.firestore.Firestore
import it.introini.covidcpcapi.model.AndamentoNazione
import it.introini.covidcpcapi.service.StateService
import it.introini.covidcpcapi.toGTimestamp
import org.springframework.stereotype.Service
import java.time.LocalDate
import javax.inject.Inject

@Service
class StateServiceImpl: StateService {
    @Inject lateinit var firestore: Firestore

    override fun getStateData(from: LocalDate?, to: LocalDate?): List<AndamentoNazione> {
        return firestore.collection("italia")
            .let { if (from != null) it.whereGreaterThanOrEqualTo("timestamp", from.toGTimestamp()) else it }
            .let { if (to != null) it.whereLessThanOrEqualTo("timestamp", to.toGTimestamp()) else it }.get().get()
            .documents.mapNotNull {
                it.toObject(AndamentoNazione::class.java)
            }
    }
}