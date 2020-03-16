package it.introini.covidcpcapi.service.impl

import com.google.cloud.firestore.Firestore
import it.introini.covidcpcapi.model.AndamentoRegione
import it.introini.covidcpcapi.service.RegionService
import it.introini.covidcpcapi.toGTimestamp
import org.springframework.stereotype.Service
import java.time.LocalDate
import javax.inject.Inject

@Service
class RegionServiceImpl: RegionService {

    @Inject lateinit var firestore: Firestore

    override fun getRegionData(regionName: String, from: LocalDate?, to: LocalDate?): List<AndamentoRegione> {
        return firestore.collection("regioni/${regionName}/storico")
                        .let { if (from != null) it.whereGreaterThanOrEqualTo("timestamp", from.toGTimestamp()) else it }
                        .let { if (to != null) it.whereLessThanOrEqualTo("timestamp", to.toGTimestamp()) else it }.get().get()
                        .documents.mapNotNull {
                            it.toObject(AndamentoRegione::class.java)
                        }
    }
}