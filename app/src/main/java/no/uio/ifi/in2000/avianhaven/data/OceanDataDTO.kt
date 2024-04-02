package no.uio.ifi.in2000.avianhaven.data

data class OceanDataDTO(
    val geometry: Geometry,
    val properties: Properties,
    val type: String
) {
    data class Geometry(
        val coordinates: List<Double>,
        val type: String
    )

    data class Properties(
        val meta: Meta,
        val timeseries: List<Timeseries>
    ) {
        data class Meta(
            val units: Units,
            val updated_at: String
        ) {
            data class Units(
                val sea_surface_wave_from_direction: String,
                val sea_surface_wave_height: String,
                val sea_water_speed: String,
                val sea_water_temperature: String,
                val sea_water_to_direction: String
            )
        }

        data class Timeseries(
            val `data`: Data,
            val time: String
        ) {
            data class Data(
                val instant: Instant
            ) {
                data class Instant(
                    val details: Details
                ) {
                    data class Details(
                        val sea_surface_wave_from_direction: Double,
                        val sea_surface_wave_height: Double,
                        val sea_water_speed: Double,
                        val sea_water_temperature: Double,
                        val sea_water_to_direction: Double
                    )
                }
            }
        }
    }
}