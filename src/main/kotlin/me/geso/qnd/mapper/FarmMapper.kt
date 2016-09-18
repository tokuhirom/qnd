package me.geso.qnd.mapper

import me.geso.qnd.entity.Farm
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Select

interface FarmMapper {
    @Select("SELECT * FROM farm WHERE id=#{id}")
    fun findById(id: Long): List<Farm>

    @Select("SELECT * FROM farm ORDER BY name ASC")
    fun findAll(): List<Farm>

    @Insert("INSERT INTO farm (name) VALUES (#{name})")
    @Options(useGeneratedKeys = true)
    fun insert(farm: Farm): Void
}
