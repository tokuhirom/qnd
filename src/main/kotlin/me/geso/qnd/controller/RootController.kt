package me.geso.qnd.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RootController {
    @GetMapping("/hello")
    fun hello(): String {
        return "service/index.ftl"
    }
}
