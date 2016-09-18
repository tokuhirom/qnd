package me.geso.mapper

import me.geso.qnd.DemoApplication
import me.geso.qnd.entity.Service
import me.geso.qnd.mapper.ServiceMapper
import org.junit.Test
import org.junit.runner.RunWith
import org.mybatis.spring.annotation.MapperScan
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(classes = arrayOf(DemoApplication::class))
@MapperScan(basePackageClasses = arrayOf(DemoApplication::class))
class ServiceMapperTest {
    // junit test runner says "Test class should have exactly one public zero-argument constructor"
    @Autowired
    val serviceMapper: ServiceMapper? = null

    @Test
    fun testInsert() {
        val service = Service()
        service.name = "hoge"
        serviceMapper!!.insert(service)
        assert(service.serviceId != null)
        val findById = serviceMapper.findById(service.serviceId!!)
        assert(findById!!.name.equals("hoge"))
        assert(findById.serviceId != null)
        assert(findById.created != null)
    }
}
