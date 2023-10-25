package de.alekseipopov.storage.enteties

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity("remote_key")
data class RemoteKeyEntity(
    @PrimaryKey val remoteKeyId: String,
    val nextPage: Int? = null
)