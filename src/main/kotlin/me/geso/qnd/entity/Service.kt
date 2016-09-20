package me.geso.qnd.entity

import java.time.LocalDateTime

data class Service(
        var serviceId: Long? = null,
        var name: String? = null,
        var created: LocalDateTime? = null,
        var updated: LocalDateTime? = null
) {}
