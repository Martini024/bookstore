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
        "insert into bs_admin (admin_name, admin_password, ",
        "admin_realName)",
        "values (#{adminName,jdbcType=VARCHAR}, #{adminPassword,jdbcType=VARCHAR}, ",
        "#{adminRealname,jdbcType=VARCHAR})"
    })
    int insert(Admin record);

    @Select({
        "select",
        "admin_name, admin_password, admin_realName",
        "from bs_admin",
        "where admin_name = #{adminName,jdbcType=VARCHAR}"
    })
    @ConstructorArgs({
        @Arg(column="admin_name", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="admin_password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="admin_realName", javaType=String.class, jdbcType=JdbcType.VARCHAR)
    })
    Admin selectByPrimaryKey(String adminName);

    @Select({
        "select",
        "admin_name, admin_password, admin_realName",
        "from bs_admin"
    })
    @ConstructorArgs({
        @Arg(column="admin_name", javaType=String.class, jdbcType=JdbcType.VARCHAR, id=true),
        @Arg(column="admin_password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="admin_realName", javaType=String.class, jdbcType=JdbcType.VARCHAR)
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