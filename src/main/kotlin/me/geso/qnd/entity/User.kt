package me.geso.qnd.entity

import java.time.LocalDateTime

class User(
        var id: Long?,
        var authProvider: String,
        var authData: String,
        var created: LocalDateTime?,
        var updated: LocalDateTime?
) {
    constructor(authProvider: String, authData: String) : this(null, authProvider, authData, null, null)
}