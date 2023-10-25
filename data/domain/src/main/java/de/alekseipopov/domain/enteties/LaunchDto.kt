package de.alekseipopov.domain.enteties

//TODO: Add crew later
data class LaunchDto(
    val uuid: String? = null,
    val name: String? = null,
    val patchBig: String? = null,
    val patchSmall: String? = null,
    val launchStatus: LaunchStatus = LaunchStatus.UNKNOWN,
    val timeUtc: String? = null,
    val timeLocal: String? = null,
    val datePrecision: LaunchDatePrecision? = LaunchDatePrecision.UNKNOWN,
    val launchpadName: String? = null,
    val rocketName: String? = null,
    val isBookmarked: Boolean = false,
)

enum class LaunchStatus {
    TBD, UPCOMING, SUCCESS, FAIL, UNKNOWN
}

//Valid values are quarter, half, year, month, day, hour
enum class LaunchDatePrecision {
    QUARTER, HALF, YEAR, MONTH, DAY, HOUR, UNKNOWN
}