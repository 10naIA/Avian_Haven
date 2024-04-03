package no.uio.ifi.in2000.avianhaven.data


import com.google.gson.annotations.SerializedName

data class BirdDTO(
    //@SerializedName("entities")
    val entities: List<Entity>,
)
    data class Entity(
        //@SerializedName("family")
        val family: String,
        //@SerializedName("id")
        val id: Int,
        //@SerializedName("images")
        val images: List<String>,
        //@SerializedName("lengthMax")
        val lengthMax: Double,
        //@SerializedName("lengthMin")
        val lengthMin: Double,
        //@SerializedName("name")
        val name: String,
        //@SerializedName("order")
        val order: String,
        //@SerializedName("region")
        val region: List<String>,
        @SerializedName("sciName")
        val latinName: String,
        //@SerializedName("status")
        val status: String,
        //@SerializedName("wingspanMax")
        val wingspanMax: Double,
        //@SerializedName("wingspanMin")
        val wingspanMin: Double
    )
