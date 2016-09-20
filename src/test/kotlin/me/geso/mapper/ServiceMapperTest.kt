package me.geso.mapper

import me.geso.qnd.DemoApplication
import me.geso.qnd.entity.Service
import me.geso.qnd.entity.ServiceUser
import me.geso.qnd.entity.User
import me.geso.qnd.mapper.ServiceMapper
import me.geso.qnd.mapper.ServiceUserMapper
import me.geso.qnd.mapper.UserMapper
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
    @Autowired
    val userMapper: UserMapper? = null
    @Autowired
    val serviceUserMapper: ServiceUserMapper? = null

    @Test
    fun testInsert() {
        val user = User(authProvider = "test", authData = "", displayName = null)
        userMapper!!.insert(user)

        val service = Service()
        service.name = "hoge"
        serviceMapper!!.insert(service)

        serviceUserMapper!!.insert(ServiceUser(
                serviceId = service.serviceId,
                userId = user.userId))

        assert(service.serviceId != null)
        val findById = serviceMapper.findById(
                userId = user.userId!!,
                serviceId = service.serviceId!!)
        assert(findById!!.name.equals("hoge"))
        assert(findById.serviceId != null)
        assert(findById.created != null)
    }
}
