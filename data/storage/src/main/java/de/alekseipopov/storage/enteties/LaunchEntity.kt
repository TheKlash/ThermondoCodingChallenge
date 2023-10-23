package de.alekseipopov.storage.enteties

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LaunchEntity(
    @PrimaryKey(autoGenerate = true)
    val launchId: Int,
    val name: String? = null,
    val bigPatchLink: String? = null,
    val smallPatchLink: String? = null,
    val upcoming: Boolean? = null,
    val tbd: Boolean? = null,
    val timeUtc: String? = null,
    val timeLocal: String? = null,
    val datePrecision: String? = null,
    val launchpadName: String? = null,
    val rocketName: String? = null
)
