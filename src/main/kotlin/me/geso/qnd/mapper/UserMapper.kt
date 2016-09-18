package me.geso.qnd.mapper

import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Options
import org.apache.ibatis.annotations.Select

interface UserMapper {
    @Insert("""INSERT INTO user (authProvider, authData)
                    VALUES (#{authProvider}, #{authData})""")
    @Options(useGeneratedKeys = true)
    fun insert(authProvider: String, authData: String)

    @Select("SELECT * FROM user WHERE id=#{id}")
    fun findById(id: Long)
}
