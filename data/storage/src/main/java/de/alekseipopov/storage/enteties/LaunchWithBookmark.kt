package de.alekseipopov.storage.enteties

import androidx.room.Embedded
import androidx.room.Relation

data class LaunchWithBookmark(
    @Embedded
    val launch: LaunchEntity,
    @Relation (
        parentColumn = "id",
        entityColumn = "launch"
    )
    val bookmark: BookmarkEntity
)
