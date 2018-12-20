package com.bookstore.mapper;

import com.bookstore.model.Customer;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface CustomerMapper {
    @Delete({
        "delete from bs_customer",
        "where cust_id = #{custId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer custId);

    @Insert({
        "insert into bs_customer (cust_name, ",
        "cust_password, cust_realName, ",
        "cust_email, cust_createDate)",
        "values (#{custName,jdbcType=VARCHAR}, ",
        "#{custPassword,jdbcType=VARCHAR}, #{custRealname,jdbcType=VARCHAR}, ",
        "#{custEmail,jdbcType=VARCHAR}, #{custCreatedate,jdbcType=DATE})"
    })
    @SelectKey(statement="select cust_id from bs_customer where cust_name=#{custName,jdbcType=VARCHAR}", keyProperty="custId", before=false, resultType=int.class)
    int insert(Customer customer);

    @Select({
        "select",
        "cust_id, cust_name, cust_password, cust_realName, cust_email, cust_createDate",
        "from bs_customer",
        "where cust_id = #{custId,jdbcType=INTEGER}"
    })
    @ConstructorArgs({
        @Arg(column="cust_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
        @Arg(column="cust_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="cust_password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="cust_realName", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="cust_email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
        @Arg(column="cust_createDate", javaType=java.sql.Date.class, jdbcType=JdbcType.DATE)
    })
    Customer selectByPrimaryKey(Integer custId);

    @Select("select  cust_id from bs_customer where cust_name = #{custName}")
    @ConstructorArgs({
            @Arg(column="cust_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
    })
    Integer selectByCustName(String custName);

//    @Select({
//        "select",
//        "cust_id, cust_name, cust_password, cust_realName, cust_email, cust_createDate",
//        "from bs_customer"
//    })
//    @ConstructorArgs({
//        @Arg(column="cust_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
//        @Arg(column="cust_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
//        @Arg(column="cust_password", javaType=String.class, jdbcType=JdbcType.VARCHAR),
//        @Arg(column="cust_realName", javaType=String.class, jdbcType=JdbcType.VARCHAR),
//        @Arg(column="cust_email", javaType=String.class, jdbcType=JdbcType.VARCHAR),
//        @Arg(column="cust_createDate", javaType=java.sql.Date.class, jdbcType=JdbcType.DATE)
//    })
//    List<Customer> selectAll();

    @Update({
        "update bs_customer",
        "set cust_name = #{custName,jdbcType=VARCHAR},",
          "cust_password = #{custPassword,jdbcType=VARCHAR},",
          "cust_realName = #{custRealname,jdbcType=VARCHAR},",
          "cust_email = #{custEmail,jdbcType=VARCHAR},",
          "cust_createDate = #{custCreatedate,jdbcType=DATE}",
        "where cust_id = #{custId,jdbcType=INTEGER}"
    })
    @SelectKey(statement="select cust_id from bs_customer where cust_name=#{custName,jdbcType=VARCHAR}", keyProperty="custId", before=false, resultType=int.class)
    int updateByPrimaryKey(Customer customer);
}