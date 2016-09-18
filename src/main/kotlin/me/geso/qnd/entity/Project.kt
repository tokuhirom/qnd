package me.geso.qnd.entity

import java.time.LocalDateTime

class Project(
        var id: Long?,
        var name: String,
        var created: LocalDateTime?,
        var updated: LocalDateTime?
) {
    constructor(name: String) : this(null, name, null, null)
}