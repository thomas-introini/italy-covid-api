package it.introini.covidcpcapi.service.impl

import com.google.cloud.firestore.Firestore
import it.introini.covidcpcapi.model.AndamentoProvincia
import it.introini.covidcpcapi.service.ProvinceService
import it.introini.covidcpcapi.toGTimestamp
import org.springframework.stereotype.Service
import java.time.LocalDate
import javax.inject.Inject

@Service
class ProvinceServiceImpl: ProvinceService {
    @Inject lateinit var firestore: Firestore
    override fun getProvinceData(
        regionName: String,
        provinceName: String,
        from: LocalDate?,
        to: LocalDate?
    ): List<AndamentoProvincia> {
        return firestore.collection("regioni/${regionName}/province/${provinceName.toUpperCase()}/storico")
                        .let { if (from != null) it.whereGreaterThanOrEqualTo("timestamp", from.toGTimestamp()) else it }
                        .let { if (to != null) it.whereLessThanOrEqualTo("timestamp", to.toGTimestamp()) else it }.get().get()
                        .documents.mapNotNull {
                            it.toObject(AndamentoProvincia::class.java)
                        }
    }
}