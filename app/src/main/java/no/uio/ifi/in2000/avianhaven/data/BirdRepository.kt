package no.uio.ifi.in2000.avianhaven.data

object BirdRepository {
    private val birdDatasource = BirdDatasource
    private var entityData: List<Entity> = listOf()

    suspend fun storeDeserializedData() {
        val storedData: BirdDTO = birdDatasource.fetchBirdData()
        entityData = storedData.entities
    }

    fun getStatus(): Boolean {
        return entityData.isNotEmpty()
    }

    fun getStoredData(): List<Entity> {
        return entityData
    }

/*    fun getChosenBird(chosenName: String): Entity? {
        return entityData.find { it.latinName == chosenName }
    }*/
    fun getChosenBird(chosenId: Int): Entity? {
        return entityData.find {it.id == chosenId}
    }
}























