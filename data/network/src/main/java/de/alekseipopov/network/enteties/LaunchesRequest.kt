package de.alekseipopov.network.enteties

import com.google.gson.annotations.SerializedName

data class LaunchesRequest(
    @SerializedName("options")
    var options: Options? = Options()
)
data class Options(
    //One of the possible solutions was to load crews, rockets and launchpads in WorkManager
    //But unfortunatelly I'm out of time
    @SerializedName("populate")
    var populate: ArrayList<String?> = arrayListOf("rocket", "crew", "launchpad"),
    @SerializedName("page")
    var page: Int = 1
)
