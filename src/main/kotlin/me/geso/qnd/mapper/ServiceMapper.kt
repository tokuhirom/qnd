package me.geso.qnd.mapper

import me.geso.qnd.entity.Service
import org.apache.ibatis.annotations.*

@Mapper
interface ServiceMapper {
    //language=MySQL
    @Select("""SELECT service.*
        FROM service
        INNER JOIN service_user ON (
                service_user.user_id=#{userId}
                AND service.service_id=service_user.service_id)
        WHERE service.service_id=#{serviceId}""")
    fun findById(@Param("userId") userId: Long, @Param("serviceId") serviceId: Long): Service?

    //language=MySQL
    @Select("""
    SELECT service.*
    FROM service INNER JOIN service_user ON (service_user.user_id = #{userId} AND service.service_id=service_user.service_id)
    ORDER BY name ASC
    """)
    fun findAll(userId: Long): List<Service>

    @Insert("INSERT INTO service (name) VALUES (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "serviceId")
    fun insert(service: Service)
}
