package no.uio.ifi.in2000.avianhaven.data

object SoundRepository {
    private val soundDataSource: SoundDatasource = SoundDatasource
    private var foundSound: SoundDTO? = null

    suspend fun getSound(): String? {
        foundSound = soundDataSource.fetchSound()
        return foundSound?.recordings?.firstOrNull()?.file
    }
}