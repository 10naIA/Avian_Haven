package no.uio.ifi.in2000.avianhaven.data

object BirdRepository {
    private val birdDataSource = BirdDataSource
    private var birdData: List<Entity> = listOf()

    suspend fun storeDeserializedData() {
        val storedData: BirdLibraryDTO = birdDataSource.fetchBirdData()
        birdData = storedData.entities
    }

    fun getStoredData(): List<Entity> {
        return birdData
    }

    fun getChosenBird(chosenName: String): Entity? {
        return birdData.find { it.sciName == chosenName }
    }
}























