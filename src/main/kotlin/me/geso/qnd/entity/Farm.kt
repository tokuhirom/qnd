package me.geso.qnd.entity

import java.time.LocalDateTime


// Mybatis requires Java beans.
data class Farm(
        var farmId: Long? = null,
        var serviceId: Long? = null,
        var name: String? = null,
        var created: LocalDateTime? = null,
        var updated: LocalDateTime? = null
) {}
