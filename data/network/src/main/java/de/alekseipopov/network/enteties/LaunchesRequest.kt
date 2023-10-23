package de.alekseipopov.network.enteties

import com.google.gson.annotations.SerializedName

data class LaunchesRequest(
    @SerializedName("options") var options: Options? = Options()
)
data class Options(
    @SerializedName("populate") var populate: ArrayList<String?> = arrayListOf("rocket", "crew", "launchpad")
)
