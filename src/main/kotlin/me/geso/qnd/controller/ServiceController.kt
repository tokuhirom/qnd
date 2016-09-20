package me.geso.qnd.controller

import me.geso.qnd.entity.Service
import me.geso.qnd.entity.User
import me.geso.qnd.exception.NotFoundException
import me.geso.qnd.service.FarmService
import me.geso.qnd.service.ServiceService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class ServiceController(
        val serviceService: ServiceService,
        val farmService: FarmService
) {
    companion object {
        val log = org.slf4j.LoggerFactory.getLogger(this::class.java)!!
    }
    
    // list of services
    @GetMapping("/service/")
    fun index(user: User, model: Model): String {
        model.addAttribute("services", serviceService.findAll(user.userId!!))
        return "service/index"
    }

    // service register form
    @GetMapping("/service/register")
    fun register(): String {
        return "service/register"
    }

    // do register
    @PostMapping("/service/register")
    fun doRegister(@RequestParam("name") name: String, user: User): String {
        val service = Service(name = name)
        serviceService.insert(user.userId!!, service)

        // redirect to list of services
        return "redirect:/service/${service.serviceId}"
    }

    @GetMapping("/service/{serviceId}")
    fun show(@PathVariable("serviceId") serviceId: Long, user: User, model: Model): String {
        val service = serviceService.findById(user.userId!!, serviceId)
                ?: throw NotFoundException("Unknown service: $serviceId")
        model.addAttribute("service", service)

        log.info("Displaying service: {}", service)

        val farms = farmService.findByServiceId(
                userId = user.userId!!,
                serviceId = service.serviceId!!)
        model.addAttribute("farms", farms)

        return "service/show"
    }
}
