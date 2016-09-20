package me.geso.qnd.mapper

import me.geso.qnd.entity.Farm
import org.apache.ibatis.annotations.*


@Mapper
interface FarmMapper {
    @Select("SELECT * FROM farm WHERE farm_id=#{serviceId}")
    fun findById(id: Long): Farm?

    @Select("SELECT * FROM farm ORDER BY name ASC")
    fun findAll(): List<Farm>

    @Insert("INSERT INTO farm (service_id, name) VALUES (#{serviceId}, #{name})")
    @Options(useGeneratedKeys = true, keyProperty = "farmId")
    fun insert(farm: Farm)

    //language=MySQL
    @Select("""
    SELECT *
    FROM farm
      INNER JOIN service_user ON (service_user.service_id=farm.service_id)
    WHERE farm.service_id=#{serviceId}
        AND service_user.user_id=#{userId}
    ORDER BY NAME ASC""")
    fun findByServiceId(@Param("userId") userId: Long, @Param("serviceId") serviceId: Long): List<Farm>
}
