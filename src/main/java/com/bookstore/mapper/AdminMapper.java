package com.bookstore.mapper;

import com.bookstore.model.Admin;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface AdminMapper {
    @Delete({
        "delete from bs_admin",
        "where admin_name = #{adminName,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String adminName);

    @Insert({
        "insert into bs_admin (admin_password, admin_realName)",
        "values (#{adminPassword,jdbcType=VARCHAR}, #{adminRealname,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="adminName", before=false, resultType=String.class)
    int insert(Admin record);

    @Select({
        "select",
        "admin_name, admin_password, admin_realName",
        "from bs_admin",
        "where admin_name = #{adminName,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="admin_name", property="adminName", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="admin_password", property="adminPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="admin_realName", property="adminRealname", jdbcType=JdbcType.VARCHAR)
    })
    Admin selectByPrimaryKey(String adminName);

    @Select({
        "select",
        "admin_name, admin_password, admin_realName",
        "from bs_admin"
    })
    @Results({
        @Result(column="admin_name", property="adminName", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="admin_password", property="adminPassword", jdbcType=JdbcType.VARCHAR),
        @Result(column="admin_realName", property="adminRealname", jdbcType=JdbcType.VARCHAR)
    })
    List<Admin> selectAll();

    @Update({
        "update bs_admin",
        "set admin_password = #{adminPassword,jdbcType=VARCHAR},",
          "admin_realName = #{adminRealname,jdbcType=VARCHAR}",
        "where admin_name = #{adminName,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Admin record);
}