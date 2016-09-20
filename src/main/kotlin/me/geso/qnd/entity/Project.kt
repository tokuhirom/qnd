package me.geso.qnd.entity

import java.time.LocalDateTime

data class Project(
        var projectId: Long? = null,
        var farmId: Long? = null,
        var name: String? = null,
        var created: LocalDateTime? = null,
        var updated: LocalDateTime? = null
) {}
