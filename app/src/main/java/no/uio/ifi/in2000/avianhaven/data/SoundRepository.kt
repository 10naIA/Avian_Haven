package no.uio.ifi.in2000.avianhaven.data

object SoundRepository {
    private val soundDataSource: SoundDatasource = SoundDatasource
    private var birdData: SoundDTO? = null

    suspend fun getSound(id: Int): String? {
        birdData = soundDataSource.fetchSound(id)
        return birdData?.recordings?.firstOrNull()?.file
    }
}