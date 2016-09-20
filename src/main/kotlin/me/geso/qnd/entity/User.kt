package me.geso.qnd.entity

import java.time.LocalDateTime

data class User(
        var userId: Long? = null,
        var displayName: String?,
        var authProvider: String? = null,
        var authData: String? = null,
        var priv: UserPriv? = null,
        var created: LocalDateTime? = null,
        var updated: LocalDateTime? = null
) {}

