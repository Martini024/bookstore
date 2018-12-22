package com.bookstore.mapper;

import com.bookstore.model.Address;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

@Mapper
public interface AddressMapper {


    @Delete({
        "delete from bs_address",
        "where addr_id = #{addrId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer addrId);


    @Insert({
        "insert into bs_address (addr_id, cust_id, ",
        "addr_name, addr_phone, ",
        "addr_address, addr_zipcode)",
        "values (#{addrId,jdbcType=INTEGER}, #{customer.custId,jdbcType=INTEGER}, ",
        "#{addrName,jdbcType=VARCHAR}, #{addrPhone,jdbcType=VARCHAR}, ",
        "#{addrAddress,jdbcType=VARCHAR}, #{addrZipcode,jdbcType=VARCHAR})"
    })
    int insert(Address address);


    @Select({
        "select",
        "addr_id, cust_id, addr_name, addr_phone, addr_address, addr_zipcode",
        "from bs_address",
        "where addr_id = #{addrId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(id=true, property="addrId",column="addr_id"),
            @Result(property = "addrName", column = "addr_name"),
            @Result(property = "addrPhone", column = "addr_phone"),
            @Result(property = "addrAddress", column = "addr_address"),
            @Result(property = "addrZipcode", column = "addr_zipcode"),
            @Result(property="customer",column="cust_id", one=@One(select= "com.bookstore.mapper.CustomerMapper.selectByPrimaryKey"))
    })
    Address selectByPrimaryKey(Integer addrId);


//    @Select({
//        "select",
//        "addr_id, cust_id, addr_name, addr_phone, addr_address, addr_zipcode",
//        "from bs_address"
//    })
//    @ConstructorArgs({
//        @Arg(column="addr_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER, id=true),
//        @Arg(column="cust_id", javaType=Integer.class, jdbcType=JdbcType.INTEGER),
//        @Arg(column="addr_name", javaType=String.class, jdbcType=JdbcType.VARCHAR),
//        @Arg(column="addr_phone", javaType=String.class, jdbcType=JdbcType.VARCHAR),
//        @Arg(column="addr_address", javaType=String.class, jdbcType=JdbcType.VARCHAR),
//        @Arg(column="addr_zipcode", javaType=String.class, jdbcType=JdbcType.VARCHAR)
//    })
//    List<Address> selectAll();


    @Update({
        "update bs_address",
        "set addr_name = #{addrName,jdbcType=VARCHAR},",
          "addr_phone = #{addrPhone,jdbcType=VARCHAR},",
          "addr_address = #{addrAddress,jdbcType=VARCHAR},",
          "addr_zipcode = #{addrZipcode,jdbcType=VARCHAR}",
        "where addr_id = #{addrId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Address address);


}