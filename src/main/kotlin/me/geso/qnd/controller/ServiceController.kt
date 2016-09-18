package me.geso.qnd.controller

import me.geso.qnd.entity.Service
import me.geso.qnd.mapper.ServiceMapper
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class ServiceController(
        val serviceMapper: ServiceMapper
) {
    // list of services
    @GetMapping("/service/")
    fun index(model: Model): String {
        for (service in serviceMapper.findAll()) {
//            println(service.serviceId)
//            println(service.name)
//            println(service.created)
        };
        model.addAttribute("services", serviceMapper.findAll())
        return "service/index"
    }

    // service register form
    @GetMapping("/service/register")
    fun register(): String {
        return "service/register"
    }

    // do register
    @PostMapping("/service/register")
    fun doRegister(@RequestParam("name") name: String): String {
        val service = Service()
        service.name = name
        serviceMapper.insert(service)

        // redirect to list of services
        return "redirect:/service/"
    }
}

