package no.uio.ifi.in2000.avianhaven.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.serialization.gson.gson
import no.uio.ifi.in2000.avianhaven.BuildConfig

object SoundDatasource {
    private val client = HttpClient {
        defaultRequest {
            headers {
                append("USER_AGENT", BuildConfig.USER_AGENT)
                append("API_KEY", BuildConfig.API_KEY)
            }
        }
        install(ContentNegotiation) {
            gson{}
        }
    }
    suspend fun fetchSound(id: Int): SoundDTO {
        val response = client.get("https://nuthatch.lastelm.software/birds/$id")
        return response.body<SoundDTO>()
    }
}