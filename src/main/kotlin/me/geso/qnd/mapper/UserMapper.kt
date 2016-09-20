package me.geso.qnd.mapper

import me.geso.qnd.entity.User
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Select

@Mapper
interface UserMapper {
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    //language=MySQL
    @Insert("""INSERT INTO user (auth_provider, auth_data, priv)
                    VALUES (#{authProvider}, #{authData}, #{priv})""")
    fun insert(user: User)

    @Select("SELECT * FROM user WHERE serviceId=#{serviceId}")
    fun findById(id: Long)
}
