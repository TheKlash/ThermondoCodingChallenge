package de.alekseipopov.storage.enteties

import androidx.room.Embedded
import androidx.room.Relation

data class LaunchesWithBookmarks(
    @Embedded
    val launch: LaunchEntity,
    @Relation (
        parentColumn = "launchId",
        entityColumn = "launch"
    )
    val bookmark: BookmarkEntity
)
