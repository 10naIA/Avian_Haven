package no.uio.ifi.in2000.avianhaven.data


import com.google.gson.annotations.SerializedName

data class SoundDTO(
    @SerializedName("images")
    val images: List<String>,
    @SerializedName("lengthMin")
    val lengthMin: Int,
    @SerializedName("lengthMax")
    val lengthMax: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("sciName")
    val sciName: String,
    @SerializedName("region")
    val region: List<String>,
    @SerializedName("family")
    val family: String,
    @SerializedName("order")
    val order: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("recordings")
    val recordings: List<Recording>,
) {
    data class Recording(
        @SerializedName("date")
        val date: String,
        @SerializedName("loc")
        val loc: String,
        @SerializedName("birdId")
        val birdId: Int,
        @SerializedName("lic")
        val lic: String,
        @SerializedName("type")
        val type: String,
        @SerializedName("rmk")
        val rmk: String,
        @SerializedName("rec")
        val rec: String,
        @SerializedName("gen")
        val gen: String,
        @SerializedName("ssp")
        val ssp: String,
        @SerializedName("file")
        val `file`: String,
        @SerializedName("uploaded")
        val uploaded: String,
        @SerializedName("playback-used")
        val playbackUsed: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("sp")
        val sp: String,
        @SerializedName("lat")
        val lat: String,
        @SerializedName("lng")
        val lng: String,
        @SerializedName("bird-seen")
        val birdSeen: String,
        @SerializedName("length")
        val length: String,
        @SerializedName("cnt")
        val cnt: String,
        @SerializedName("alt")
        val alt: String,
        @SerializedName("sono")
        val sono: List<String>,
        @SerializedName("en")
        val en: String,
        @SerializedName("also")
        val also: List<String>,
        @SerializedName("url")
        val url: String,
        @SerializedName("q")
        val q: String,
        @SerializedName("time")
        val time: String,
        @SerializedName("file-name")
        val fileName: String
    )
}