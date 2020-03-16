package it.introini.covidcpcapi.configuration

import com.google.api.gax.core.CredentialsProvider
import com.google.auth.oauth2.ComputeEngineCredentials
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.FirestoreOptions
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.inject.Inject

@Configuration
class Configuration {
    private val log: Logger = LoggerFactory.getLogger(it.introini.covidcpcapi.configuration.Configuration::class.java)

    @Inject lateinit var credentialsProvider: CredentialsProvider

    @Bean
    fun getFirebaseClient(): Firestore {
        val cred = credentialsProvider.credentials
        if (cred is ComputeEngineCredentials) {
            log.info("Credentials -> ${cred.account}")
        }
        return FirestoreOptions.getDefaultInstance()
                               .toBuilder()
                               .setCredentialsProvider(credentialsProvider)
                .setProjectId("covid-270517")
                               .build()
                               .service
    }
}