package ru.itis.homeworkmvvm.data.model
import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("active")
    val active: Int = 0,
    @SerializedName("cases")
    val cases: Int = 0,
    @SerializedName("casesPerOneMillion")
    val casesPerOneMillion: Int = 0,
    @SerializedName("country")
    val country: String = "",
    @SerializedName("countryInfo")
    val countryInfo: CountryInfo = CountryInfo(),
    @SerializedName("critical")
    val critical: Int = 0,
    @SerializedName("deaths")
    val deaths: Int = 0,
    @SerializedName("deathsPerOneMillion")
    val deathsPerOneMillion: Int = 0,
    @SerializedName("recovered")
    val recovered: Int = 0,
    @SerializedName("tests")
    val tests: Int = 0,
    @SerializedName("testsPerOneMillion")
    val testsPerOneMillion: Int = 0,
    @SerializedName("todayCases")
    val todayCases: Int = 0,
    @SerializedName("todayDeaths")
    val todayDeaths: Int = 0,
    @SerializedName("updated")
    val updated: Long = 0
)

data class CountryInfo(
    @SerializedName("flag")
    val flag: String = "",
    @SerializedName("_id")
    val id: Int = 0,
    @SerializedName("iso2")
    val iso2: String = "",
    @SerializedName("iso3")
    val iso3: String = "",
    @SerializedName("lat")
    val lat: Double = 0.0,
    @SerializedName("long")
    val long: Double = 0.0
)
