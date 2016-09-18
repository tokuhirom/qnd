package me.geso.qnd.mapper

import me.geso.qnd.entity.Service
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Select

interface ServiceMapper {
    @Select("SELECT * FROM service WHERE service_id=#{id}")
    fun findById(id: Long): Service?

    @Select("SELECT * FROM service ORDER BY name ASC")
    fun findAll(): List<Service>

    @Insert("INSERT INTO service (name) VALUES (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "serviceId")
    fun insert(service: Service)
}
