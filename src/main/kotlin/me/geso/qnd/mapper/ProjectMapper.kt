package me.geso.qnd.mapper

import me.geso.qnd.entity.Project
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface ProjectMapper {
    @Select("""SELECT * FROM project WHERE farm_id=#{farmId}""")
    fun findByFarmId(farmId: String): List<Project>
}

