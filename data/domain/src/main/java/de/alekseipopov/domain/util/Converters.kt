package de.alekseipopov.domain.util

import de.alekseipopov.domain.enteties.LaunchDatePrecision
import de.alekseipopov.domain.enteties.LaunchDto
import de.alekseipopov.domain.enteties.LaunchStatus
import de.alekseipopov.network.enteties.Doc
import de.alekseipopov.storage.enteties.LaunchEntity
import de.alekseipopov.storage.enteties.LaunchWithBookmark

fun LaunchWithBookmark.toLaunchDto(): LaunchDto {
    return LaunchDto(
        uuid = launch.uuid,
        name = launch.name,
        patchBig = launch.bigPatchLink,
        patchSmall = launch.smallPatchLink,
        launchStatus = when {
            launch.tbd == true -> LaunchStatus.TBD
            launch.upcoming == true -> LaunchStatus.UPCOMING
            launch.success == true -> LaunchStatus.SUCCESS
            launch.success == false -> LaunchStatus.FAIL
            else -> LaunchStatus.UNKNOWN
        },
        timeUtc = launch.timeUtc,
        timeLocal = launch.timeLocal,
        datePrecision = when(launch.datePrecision) {
            "quarter" -> LaunchDatePrecision.QUARTER
            "half" -> LaunchDatePrecision.HALF
            "year" -> LaunchDatePrecision.YEAR
            "month" -> LaunchDatePrecision.MONTH
            "day" -> LaunchDatePrecision.DAY
            "hour" -> LaunchDatePrecision.HOUR
            else -> LaunchDatePrecision.UNKNOWN
        },
        launchpadName = launch.launchpadName,
        rocketName = launch.rocketName,
        isBookmarked = bookmark.launch != null
    )
}

fun Doc.toLaunchEntity(): LaunchEntity {
    return LaunchEntity(
        uuid = this.id,
        name = this.name,
        bigPatchLink = this.links?.patch?.large,
        smallPatchLink = this.links?.patch?.small,
        upcoming = this.upcoming,
        tbd = this.tbd,
        success = this.success,
        timeLocal = this.dateLocal,
        timeUtc = this.dateUtc,
        datePrecision = this.datePrecision,
        launchpadName = this.launchpad?.name,
        rocketName = this.rocket?.name
    )
}