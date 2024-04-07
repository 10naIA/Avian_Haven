package no.uio.ifi.in2000.avianhaven.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.serialization.gson.gson

object SoundDatasource {
    private val client = HttpClient {
/*        defaultRequest {
            headers.appendIfNameAbsent("api-key", "1ccc4b54-68af-4d79-9844-e2b93704ebff")
        }*/
        defaultRequest {
            headers {
                append("User-Agent","Avian Haven/1.0 (Contact: Tina A)")
                append("api-key", "1ccc4b54-68af-4d79-9844-e2b93704ebff")
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