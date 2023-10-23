package de.alekseipopov.storage.enteties

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BookmarkEntity(
    @PrimaryKey(autoGenerate = true)
    val bookmarkId: Int? = null,
    val launch: String? = null
)
