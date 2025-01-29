package no.uio.ifi.in2000.avianhaven.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.serialization.gson.gson
import no.uio.ifi.in2000.avianhaven.BuildConfig

object BirdDatasource {
    private val client = HttpClient {
        defaultRequest {
            headers {
                append("User-Agent", BuildConfig.USER_AGENT)
                append("api-key", BuildConfig.API_KEY)
            }
        }
        install(ContentNegotiation) {
            gson{}
        }
    }
    suspend fun fetchBirdData(): BirdDTO {
        val response = client.get("https://nuthatch.lastelm.software/v2/birds?page=1&pageSize=80&region=Western%20Europe&hasImg=true")
        return response.body<BirdDTO>()
    }
}