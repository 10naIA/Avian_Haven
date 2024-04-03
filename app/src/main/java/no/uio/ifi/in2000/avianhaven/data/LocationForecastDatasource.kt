package no.uio.ifi.in2000.avianhaven.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.serialization.gson.gson
import io.ktor.util.appendIfNameAbsent
import no.uio.ifi.in2000.avianhaven.data.LocationForecastDataDTO

class LocationForecastDataSource {
    private val client = HttpClient {
        defaultRequest {
            url("https://gw-uio.intark.uh-it.no/in2000/")
            headers.appendIfNameAbsent("X-Gravitee-API-Key", "aad98eec-0786-4798-93c1-4c3837a472a7")
        }
        install(ContentNegotiation) {
            gson{}
        }
    }

    suspend fun fetchLocationForecastData(): LocationForecastDataDTO {
        val response = client.get("https://api.met.no/weatherapi/locationforecast/2.0/compact?lat=59.91&lon=10.7")

        return response.body<LocationForecastDataDTO>()
    }
}