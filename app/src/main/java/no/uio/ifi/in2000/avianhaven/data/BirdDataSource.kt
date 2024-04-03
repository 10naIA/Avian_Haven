package no.uio.ifi.in2000.avianhaven.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.client.request.headers
import io.ktor.serialization.gson.gson
import io.ktor.util.appendIfNameAbsent

object BirdDataSource {
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
    private var apiCallCounter = 0
    suspend fun fetchBirdData(): BirdDTO {
        val response = client.get("https://nuthatch.lastelm.software/v2/birds?pageSize=50&hasImg=true&operator=AND")
        apiCallCounter ++
        println("Nr of API calls: $apiCallCounter")
        return response.body<BirdDTO>()
    }
}