package me.geso.qnd.entity

import java.time.LocalDateTime


class Farm(
        var id: Long?,
        var name: String,
        var created: LocalDateTime?,
        var updated: LocalDateTime?
) {
    constructor(name: String) : this(null, name, null, null)
}
