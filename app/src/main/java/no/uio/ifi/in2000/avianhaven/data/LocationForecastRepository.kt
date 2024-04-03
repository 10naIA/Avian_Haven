package no.uio.ifi.in2000.avianhaven.data

class LocationForecastRepository(
    private val locForecastDataSource: LocationForecastDataSource
) {
    suspend fun fetchAirTemp(): Double? {
        val locForecastData = locForecastDataSource.fetchLocationForecastData()
        return locForecastData.properties.timeseries.firstOrNull()?.data?.instant?.details?.air_temperature
    }

    suspend fun fetchWind(): Double? {
        val locForecastData = locForecastDataSource.fetchLocationForecastData()
        return locForecastData.properties.timeseries.firstOrNull()?.data?.instant?.details?.wind_speed
    }
}