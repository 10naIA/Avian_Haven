package no.uio.ifi.in2000.avianhaven.data


import com.google.gson.annotations.SerializedName

data class SoundDTO(
    @SerializedName("family")
    val family: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("lengthMax")
    val lengthMax: Int,
    @SerializedName("lengthMin")
    val lengthMin: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("order")
    val order: String,
    @SerializedName("recordings")
    val recordings: List<Recording>,
    @SerializedName("region")
    val region: List<String>,
    @SerializedName("sciName")
    val sciName: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("wingspanMax")
    val wingspanMax: Int,
    @SerializedName("wingspanMin")
    val wingspanMin: Int
) {
    data class Recording(
        @SerializedName("birdId")
        val birdId: Int,
        @SerializedName("bird-seen")
        val birdSeen: String,
        @SerializedName("en")
        val en: String,
        @SerializedName("file")
        val `file`: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("length")
        val length: String,
        @SerializedName("rec")
        val rec: String,
        @SerializedName("rmk")
        val rmk: String,
        @SerializedName("sp")
        val sp: String,
        @SerializedName("ssp")
        val ssp: String
    )
}