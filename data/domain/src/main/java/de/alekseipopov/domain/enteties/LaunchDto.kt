package de.alekseipopov.domain.enteties

//TODO: Add crew later
data class LaunchDto(
    val uuid: String? = null,
    val name: String? = null,
    val patchBig: String? = null,
    val patchSmall: String? = null,
    val launchStatus: LaunchStatus = LaunchStatus.TBD,
    val timeUtc: String? = null,
    val timeLocal: String? = null,
    val datePrecision: String? = null,
    val launchpadName: String? = null,
    val rocketName: String? = null,
    val isBookmarked: Boolean = false,
)

enum class LaunchStatus {
    TBD, UPCOMING, SUCCESS, FAIL
}