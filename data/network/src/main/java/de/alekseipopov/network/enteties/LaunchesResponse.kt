package de.alekseipopov.network.enteties

import com.google.gson.annotations.SerializedName

data class LaunchesResponse(
    @SerializedName("docs") var launchesList: ArrayList<Launch> = arrayListOf(),
    @SerializedName("totalDocs") var totalDocs: Int? = null,
    @SerializedName("limit") var limit: Int? = null,
    @SerializedName("totalPages") var totalPages: Int? = null,
    @SerializedName("page") var page: Int? = null,
    @SerializedName("pagingCounter") var pagingCounter: Int? = null,
    @SerializedName("hasPrevPage") var hasPrevPage: Boolean? = null,
    @SerializedName("hasNextPage") var hasNextPage: Boolean? = null,
    @SerializedName("prevPage") var prevPage: Int? = null,
    @SerializedName("nextPage") var nextPage: Int? = null
)

data class Launch(
    @SerializedName("links") var links: Links? = Links(),
    @SerializedName("rocket") var rocket: Rocket? = Rocket(),
    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("details") var details: String? = null,
    @SerializedName("crew") var crew: ArrayList<CrewMember> = arrayListOf(),
    @SerializedName("launchpad") var launchpad: Launchpad? = Launchpad(),
    @SerializedName("name") var name: String? = null,
    @SerializedName("date_utc") var dateUtc: String? = null,
    @SerializedName("date_local") var dateLocal: String? = null,
    @SerializedName("upcoming") var upcoming: Boolean? = null,
    @SerializedName("tbd") var tbd: Boolean? = null,
    @SerializedName("id") var id: String? = null
)

data class Launchpad(
    @SerializedName("name") var name: String? = null,
    @SerializedName("latitude") var latitude: Double? = null,
    @SerializedName("longitude") var longitude: Double? = null,
    @SerializedName("id") var id: String? = null
)

data class Links(
    @SerializedName("patch") var patch: Patch? = Patch()
)

data class Patch(
    @SerializedName("small") var small: String? = null,
    @SerializedName("large") var large: String? = null
)

data class CrewMember(
    @SerializedName("name") var name: String? = null,
    @SerializedName("agency") var agency: String? = null,
    @SerializedName("image") var image: String? = null
)

data class Rocket(
    @SerializedName("name") var name: String? = null,
    @SerializedName("company") var company: String? = null
)